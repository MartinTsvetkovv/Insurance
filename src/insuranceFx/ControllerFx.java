package insuranceFx;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.*;

public class ControllerFx {
    private static final String SELECT = "-- изберете --";
    private static final String SELECT_TOWN = "-- избери населено място --";
    private static final String SELECT_MUNICIPALITY = "-- избери община --";
    @FXML
    private ComboBox<String> vehicleComboBox = new ComboBox<>();
    @FXML
    private ComboBox<String> volumeComboBox = new ComboBox<>();
    @FXML
    private Label label = new Label();
    @FXML
    private ComboBox<String> userYearsComboBox = new ComboBox<>();
    @FXML
    private ComboBox<String> carYearComboBox = new ComboBox<>();
    @FXML
    private ComboBox<String> vehicleUsageComboBox = new ComboBox<>();
    @FXML
    private ComboBox<String> insuranceTermComboBox = new ComboBox<>();
    @FXML
    private Label insTermLable = new Label();
    @FXML
    private ComboBox regionComboBox = new ComboBox();
    @FXML
    private ComboBox municipalityComboBox = new ComboBox();
    @FXML
    private ComboBox townsComboBox = new ComboBox();

    private Map<String, List<String>> volumeData = new HashMap<>();

    private Map<String, Set<String>> regionData = new HashMap<>();

    private Map<String, Set<String>> municipalityTown = new HashMap<>();


    @SuppressWarnings("unchecked")
    public void setInsuranceData() throws FileNotFoundException, SQLException, ClassNotFoundException {
        DataBaseInfo dataBaseInfo = new DataBaseInfo();

        Map<Integer, String> vehicleType = dataBaseInfo.readDataBaseInfo("vehicletype");


        ObservableList<String> vType = FXCollections.observableArrayList(vehicleType.values());
        this.vehicleComboBox.setItems(vType);

        Map<Integer, String> volume1 = dataBaseInfo.readDataBaseInfo("engine_volume");
        Map<Integer, String> motorcycleVolume = dataBaseInfo.readDataBaseInfo("bike_engine_volume");
        Map<Integer, String> truckLoadability = dataBaseInfo.readDataBaseInfo("truck_loadability");
        Map<Integer, String> busSeats = dataBaseInfo.readDataBaseInfo("bus_seats");
        Map<Integer, String> insuranceTerm = dataBaseInfo.readDataBaseInfo("insurance_term");

        setVehicle(vehicleType, volume1, motorcycleVolume, truckLoadability, busSeats, insuranceTerm);

        this.vehicleComboBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            ObservableList<String> volumeBox = FXCollections.observableArrayList(volumeData.get(newValue));
            volumeComboBox.setItems(volumeBox);
            Platform.runLater(() -> volumeComboBox.setValue(SELECT));
            updateLabels();
        });

        regionData = dataBaseInfo.readRegionData("area", "municipality");
        municipalityTown = dataBaseInfo.readRegionData("municipality", "town");


        ObservableList<String> regions = FXCollections.observableArrayList(regionData.keySet());


        regionComboBox.setItems(regions);
        regionComboBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {

            ObservableList<String> municipality = FXCollections.observableArrayList(regionData.get(newValue));
            municipalityComboBox.setItems(municipality);
            Platform.runLater(() -> municipalityComboBox.setValue(SELECT_MUNICIPALITY));
        });

        municipalityComboBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {

            try {
                if (newValue != null) {
                    ObservableList<String> towns = FXCollections.observableArrayList(municipalityTown.get(newValue));
                    townsComboBox.setItems(towns);
                    Platform.runLater(() -> townsComboBox.setValue(SELECT_TOWN));
                }
            } catch (NullPointerException e) {
                municipalityComboBox.setValue(SELECT_MUNICIPALITY);
                townsComboBox.getItems().clear();
                townsComboBox.setValue(SELECT_TOWN);
            }
        });


        List<String> years = dataBaseInfo.addUserYears();
        ObservableList<String> userYears1 = FXCollections.observableArrayList(years);
        this.userYearsComboBox.setItems(userYears1);

        List<String> carYears = dataBaseInfo.addCarYears();
        ObservableList<String> cYears = FXCollections.observableArrayList(carYears);
        this.carYearComboBox.setItems(cYears);

        Map<Integer, String> vehicleUsage = dataBaseInfo.readDataBaseInfo("vehicle_usage");
        ObservableMap<Integer, String> usageMap = FXCollections.observableHashMap();
        for (Integer id : vehicleUsage.keySet()) {
            usageMap.putIfAbsent(id, vehicleUsage.get(id));
        }
        ObservableList<String> usageValues = FXCollections.observableArrayList(usageMap.values());
        this.vehicleUsageComboBox.setItems(usageValues);

        ObservableMap<Integer, String> terms = FXCollections.observableHashMap();
        for (Integer id : insuranceTerm.keySet()) {
            terms.putIfAbsent(id, insuranceTerm.get(id));
        }
        ObservableList<String> InsTerms = FXCollections.observableArrayList(terms.values());
        this.insuranceTermComboBox.setItems(InsTerms);

    }

    private void setVehicle(Map<Integer, String> vehicleType, Map<Integer, String> volume1,
                            Map<Integer, String> motorcycleVolume,
                            Map<Integer, String> truck_loadability, Map<Integer, String> busSeats, Map<Integer, String> insuranceTerm) {

        List<String> carVolume = new ArrayList<>(volume1.values());
        List<String> bikeVolume = new ArrayList<>(motorcycleVolume.values());
        List<String> truckLoads = new ArrayList<>(truck_loadability.values());
        List<String> busInfo = new ArrayList<>(busSeats.values());
        List<String> term = new ArrayList<>(insuranceTerm.values());
        for (Integer id : vehicleType.keySet()) {
            switch (id) {
                case 1:
                    this.volumeData.putIfAbsent(vehicleType.get(id), carVolume);
                    break;
                case 3:
                    this.volumeData.put(vehicleType.get(id), truckLoads);
                    break;
                case 4:
                    this.volumeData.put(vehicleType.get(id), busInfo);
                    break;
                case 6:
                    this.volumeData.put(vehicleType.get(id), bikeVolume);
                    break;
                case 10:
                    this.volumeData.put(vehicleType.get(id), term);
                    break;
                default:
                    this.volumeData.put(vehicleType.get(id), carVolume);
                    break;
            }
        }
    }

    @FXML
    private void handleComboBoxAction() {
        int selIdx = this.vehicleComboBox.getSelectionModel().getSelectedIndex();
        if (selIdx == 1 || selIdx == 4 || selIdx == 7 || selIdx == 8
                || selIdx == 6 || selIdx == 10 || selIdx == 11 || selIdx == 12 || selIdx == 13) {
            this.label.setVisible(false);
            this.volumeComboBox.setVisible(false);
        } else {
            this.label.setVisible(true);
            this.volumeComboBox.setVisible(true);
        }
        if (selIdx == 5) {
            this.insTermLable.setVisible(true);
            this.insuranceTermComboBox.setVisible(true);
        } else {
            this.insTermLable.setVisible(false);
            this.insuranceTermComboBox.setVisible(false);
        }
    }

    @SuppressWarnings("unchecked")
    private void updateLabels() {
        int selectedIndex = this.vehicleComboBox.getSelectionModel().getSelectedIndex();
        switch (selectedIndex) {
            case 2:
                this.label.setText("Товаримост:");
                break;
            case 3:
                this.label.setText("Брой места:");
                break;
            case 9:
                this.label.setText("Срок на застраховката:");
                break;
            default:
                this.label.setText("Кубатура:");
                volumeComboBox.getSelectionModel().select("-- изберете --");
                break;
        }

    }

}
