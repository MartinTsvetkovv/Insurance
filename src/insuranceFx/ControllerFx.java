package insuranceFx;

import carInsurance.PremiumCalculations;
import carInsurance.models.Car;
import carInsurance.models.Client;
import carInsurance.models.Motorcycle;
import carInsurance.models.Truck;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.*;
import java.util.List;

public class ControllerFx {

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
    @FXML
    private ToggleGroup toggleRadioButtons = new ToggleGroup();
    @FXML
    private RadioButton yesButton = new RadioButton();
    @FXML
    private RadioButton noButton = new RadioButton();
    @FXML
    private Button calculationButton = new Button();

    private Car car;

    private Client client;

    private Truck truck;

    private Motorcycle motorcycle;

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

        //-----------Vehicle type------------
        this.vehicleComboBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            ObservableList<String> volumeBox = FXCollections.observableArrayList(volumeData.get(newValue));
            volumeComboBox.setItems(volumeBox);
            Platform.runLater(() -> volumeComboBox.setValue(Constants.SELECT));
            updateLabels();
        });

        regionData = dataBaseInfo.readRegionData("area", "municipality");
        municipalityTown = dataBaseInfo.readRegionData("municipality", "town");

        //regionData.keySet()
        ObservableList<String> regions = FXCollections.observableArrayList(regionData.keySet());

        regionComboBox.setItems(regions);
        regionComboBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {

            ObservableList<String> municipality = FXCollections.observableArrayList(regionData.get(newValue));
            municipalityComboBox.setItems(municipality);
            Platform.runLater(() -> municipalityComboBox.setValue(Constants.SELECT_MUNICIPALITY));
        });

        municipalityComboBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            //TODO:
            try {
                if (newValue != null) {
                    ObservableList<String> towns = FXCollections.observableArrayList(municipalityTown.get(newValue));
                    townsComboBox.setItems(towns);
                    Platform.runLater(() -> townsComboBox.setValue(Constants.SELECT_TOWN));
                }
            } catch (NullPointerException e) {
                municipalityComboBox.setValue(Constants.SELECT_MUNICIPALITY);
                townsComboBox.getItems().clear();
                townsComboBox.setValue(Constants.SELECT_TOWN);
            }
        });


        List<String> years = dataBaseInfo.addUserYears();
        ObservableList<String> userYears1 = FXCollections.observableArrayList(years);
        this.userYearsComboBox.setItems(userYears1);

        List<String> carYears = dataBaseInfo.addCarYears();
        ObservableList<String> cYears = FXCollections.observableArrayList(carYears);
        this.carYearComboBox.setItems(cYears);

        Map<Integer, String> vehicleUsage = dataBaseInfo.readDataBaseInfo("vehicle_usage");

        ObservableList<String> usageValues = FXCollections.observableArrayList(vehicleUsage.values());
        this.vehicleUsageComboBox.setItems(usageValues);

        ObservableList<String> InsTerms = FXCollections.observableArrayList(insuranceTerm.values());
        this.insuranceTermComboBox.setItems(InsTerms);

        //--------------------RadioButtons---------------------
        this.yesButton.setToggleGroup(toggleRadioButtons);
        this.yesButton.setUserData("Да");
        this.noButton.setToggleGroup(toggleRadioButtons);
        this.noButton.setUserData("Не");
        this.noButton.setSelected(true);


        this.calculationButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {


                int vehicleSelect = vehicleComboBox.getSelectionModel().getSelectedIndex();
                if (vehicleSelect == -1) {
                    Toolkit.getDefaultToolkit().beep();
                    JOptionPane.showMessageDialog(null, Constants.VEHICLE_DIALOG_MESSAGE);
                    return;
                }
                int carYear;

                try {
                    String selectedItem = carYearComboBox.getSelectionModel().getSelectedItem();
                    String[] splitSelectedYear = selectedItem.split(" ");
                    carYear = Integer.parseInt(splitSelectedYear[0]);
                } catch (NumberFormatException e) {
                    Toolkit.getDefaultToolkit().beep();
                    JOptionPane.showMessageDialog(null, Constants.YEAR_OF_PRODUCTION_MESSAGE);
                    return;
                }
                int user;

                try {
                    String userYears = userYearsComboBox.getSelectionModel().getSelectedItem();
                    String[] split1 = userYears.split(" ");
                    user = Integer.parseInt(split1[0]);
                } catch (NumberFormatException e) {
                    Toolkit.getDefaultToolkit().beep();
                    JOptionPane.showMessageDialog(null, Constants.USER_YEARS_MESSAGE);
                    return;
                }
                //TODO
                String region = (String) regionComboBox.getSelectionModel().getSelectedItem();
                String municipality = (String) municipalityComboBox.getSelectionModel().getSelectedItem();
                String town = (String) townsComboBox.getSelectionModel().getSelectedItem();

                int volumeIndex = volumeComboBox.getSelectionModel().getSelectedIndex();
                int usage = vehicleUsageComboBox.getSelectionModel().getSelectedIndex();

                int termIndex = insuranceTermComboBox.getSelectionModel().getSelectedIndex();

                String carAccident = toggleRadioButtons.getSelectedToggle().getUserData().toString();

                client = new Client(user, region, municipality, town, carAccident);
                switch (vehicleSelect) {
                    case 0:
                        if (volumeIndex == -1) {
                            Toolkit.getDefaultToolkit().beep();
                            JOptionPane.showMessageDialog(null, Constants.VOLUME_MESSGAE);
                            return;
                        } else if (addressAndUsageVerification(region, municipality, town, usage)) {
                            return;
                        }

                        car = new Car(carYear, volumeIndex, usage);
                        double premium = PremiumCalculations.carPremiumCalculations(car, client);

                        JOptionPane.showMessageDialog(null, String.format("Крайна цена %.2f лв.", premium));
                        break;
                    case 1:
                        if (addressAndUsageVerification(region, municipality, town, usage)) {
                            return;
                        }
                        car = new Car(carYear, usage);
                        double premium1 = PremiumCalculations.electricCarCalculations(car, client);
                        JOptionPane.showMessageDialog(null, String.format("Крайна цена %.2f лв.", premium1));

                        break;
                    case 2:
                        if (volumeIndex == -1) {
                            Toolkit.getDefaultToolkit().beep();
                            JOptionPane.showMessageDialog(null, "Избери товаримост !");
                            return;
                        } else if (addressAndUsageVerification(region, municipality, town, usage)) {
                            return;
                        }
                        truck = new Truck(carYear, usage, volumeIndex);
                        double premium2 = PremiumCalculations.truckPremiumCalculations(truck, client);
                        JOptionPane.showMessageDialog(null, String.format("Крайна цена %.2f лв.", premium2));
                        break;

                    case 3:
                        if (volumeIndex == -1){
                            Toolkit.getDefaultToolkit().beep();
                            JOptionPane.showMessageDialog(null, "Избери брой места !");
                            return;
                        }
                        if (addressAndUsageVerification(region, municipality, town, usage)) {
                            return;
                        }
                        car = new Car(volumeIndex,usage);
                        double busPremium = PremiumCalculations.busCalculations(car,client);
                        JOptionPane.showMessageDialog(null, String.format("Крайна цена %.2f лв.", busPremium));
                        break;
                    case 5:
                        if (volumeIndex == -1){
                            Toolkit.getDefaultToolkit().beep();
                            JOptionPane.showMessageDialog(null, Constants.VOLUME_MESSGAE);
                            return;
                        }
                        if (addressAndUsageVerification(region, municipality, town, usage)) {
                            return;
                        }
                        if (termIndex == -1 || insuranceTermComboBox.getSelectionModel().getSelectedItem().equals(Constants.SELECT)){
                            Toolkit.getDefaultToolkit().beep();
                            JOptionPane.showMessageDialog(null, "Избери срок на застраховката !");
                            return;
                        }
                        motorcycle = new Motorcycle(carYear, volumeIndex, usage, termIndex);
                        double bikePremium = PremiumCalculations.bikeCalculations(motorcycle, client);
                        JOptionPane.showMessageDialog(null, String.format("Крайна цена %.2f лв.", bikePremium));
                        break;

                }
            }
        });
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
        if (selIdx == 0 || selIdx == 2 || selIdx == 3 || selIdx == 5 || selIdx == 9) {
            this.label.setVisible(true);
            this.volumeComboBox.setVisible(true);
        } else {
            this.label.setVisible(false);
            this.volumeComboBox.setVisible(false);
            this.volumeComboBox.getItems().clear();
        }
        if (selIdx != 5) {
            this.insTermLable.setVisible(false);
            this.insuranceTermComboBox.setVisible(false);
            //this.insuranceTermComboBox.getItems().clear();
        } else {
            this.insTermLable.setVisible(true);
            this.insuranceTermComboBox.setVisible(true);
            Platform.runLater(() -> insuranceTermComboBox.setValue(Constants.SELECT));
        }
    }

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
    private boolean addressAndUsageVerification(String region, String municipality, Object town, int usage) {
        if (region.equals(Constants.DEFAULT_REGION_VALUE)) {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, Constants.REGION_DIALOG_MESSAGE);
            return true;
        }

        if (municipality.equals(Constants.DEFAULT_MUNICIPALITY_VALUE)) {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, Constants.REGION_MESSAGE);
            return true;
        }

        if (town.equals(Constants.DEFAULT_TOWN_VALUE)) {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, Constants.TOWN_MESSAGE);
            return true;
        }
        if (usage == -1) {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, Constants.VEHICLE_USAGE_MESSAGE);
            return true;
        }
        return false;
    }
}
