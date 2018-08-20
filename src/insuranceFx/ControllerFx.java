package insuranceFx;

import carInsurance.PremiumCalculations;
import carInsurance.interfaces.Client;
import carInsurance.interfaces.MotorcycleInsurance;
import carInsurance.interfaces.TruckInsurance;
import carInsurance.interfaces.Vehicle;
import carInsurance.models.*;
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
    @FXML
    private Label totalPrice = new Label();
    @FXML
    private Label installments1 = new Label();
    @FXML
    private Label installment2 = new Label();
    @FXML
    private Label installment3 = new Label();
    @FXML
    private Label installment4 = new Label();
    @FXML
    private Label installment5 = new Label();
    @FXML
    private Label installment6 = new Label();

    private double premiumPrice;

    private Client client;
    private TruckInsurance truck;
    private MotorcycleInsurance motorcycle;


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
            updateLabels();
            volumeComboBox.setValue(Constants.SELECT);
            //Platform.runLater(() -> volumeComboBox.setValue(Constants.SELECT));
        });

        regionData = dataBaseInfo.readRegionData("area", "municipality");
        municipalityTown = dataBaseInfo.readRegionData("municipality", "town");

        ObservableList<String> regions = FXCollections.observableArrayList(regionData.keySet());

        regionComboBox.setItems(regions);
        regionComboBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {

            if (newValue != null) {
                ObservableList<String> municipality = FXCollections.observableArrayList(regionData.get(newValue));
                municipalityComboBox.setItems(municipality);
                municipalityComboBox.setValue(Constants.SELECT_MUNICIPALITY);


//                municipality.add(0, Constants.SELECT_MUNICIPALITY);
//                municipalityComboBox.getSelectionModel().selectFirst();


            }
        });

        municipalityComboBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            //TODO:

            try {

                if (newValue != null) {
                    ObservableList<String> towns = FXCollections.observableArrayList(municipalityTown.get(newValue));
                    townsComboBox.setItems(towns);
                    townsComboBox.setValue(Constants.SELECT_TOWN);
//                    towns.add(0,Constants.SELECT_TOWN);
//                    townsComboBox.getSelectionModel().selectFirst();

                }
            } catch (NullPointerException e) {
                municipalityComboBox.setValue(Constants.SELECT_MUNICIPALITY);
                townsComboBox.getItems().clear();
                townsComboBox.setValue(Constants.SELECT_TOWN);
//                townsComboBox.getSelectionModel().clearSelection();
//                townsComboBox.getSelectionModel().selectFirst();
//                townsComboBox.getItems().remove(1,townsComboBox.getItems().size());




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

        this.calculationButton.setOnAction(event -> {

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
            String region = (String) regionComboBox.getSelectionModel().getSelectedItem();
            String municipality = (String) municipalityComboBox.getSelectionModel().getSelectedItem();
            String town = (String) townsComboBox.getSelectionModel().getSelectedItem();

            int volumeIndex = volumeComboBox.getSelectionModel().getSelectedIndex();
            int usage = vehicleUsageComboBox.getSelectionModel().getSelectedIndex();

            int termIndex = insuranceTermComboBox.getSelectionModel().getSelectedIndex();

            String carAccident = toggleRadioButtons.getSelectedToggle().getUserData().toString();

            client = new ClientImpl(user, region, municipality, town, carAccident);
            switch (vehicleSelect) {
                case Constants.CAR:
                    if (volumeIndex == -1) {
                        Toolkit.getDefaultToolkit().beep();
                        JOptionPane.showMessageDialog(null, Constants.VOLUME_MESSGAE);
                        return;
                    } else if (addressAndUsageVerification(region, municipality, town, usage)) {
                        return;
                    }

                    Vehicle car = new Car(volumeIndex, carYear, usage);
                    premiumPrice = PremiumCalculations.carPremiumCalculations(car, client);
                    premiumPrice(premiumPrice);
                    paymentOfInstallments(premiumPrice);
                    break;
                case Constants.ELECTRIC_CAR:
                    if (addressAndUsageVerification(region, municipality, town, usage)) {
                        return;
                    }
                    Vehicle electricCar = new ElectricCar(usage);
                    premiumPrice = PremiumCalculations.electricCarCalculations(electricCar, client);
                    premiumPrice(premiumPrice);
                    paymentOfInstallments(premiumPrice);

                    break;
                case Constants.CARGO_VEHICLE:
                    if (volumeIndex == -1) {
                        Toolkit.getDefaultToolkit().beep();
                        JOptionPane.showMessageDialog(null, "Избери товаримост !");
                        return;
                    } else if (addressAndUsageVerification(region, municipality, town, usage)) {
                        return;
                    }
                    truck = new Truck(volumeIndex, usage, carYear);
                    premiumPrice = PremiumCalculations.truckPremiumCalculations(truck, client);
                    premiumPrice(premiumPrice);
                    paymentOfInstallments(premiumPrice);
                    break;

                case Constants.BUS:
                    if (volumeIndex == -1) {
                        Toolkit.getDefaultToolkit().beep();
                        JOptionPane.showMessageDialog(null, "Избери брой места !");
                        return;
                    }
                    if (addressAndUsageVerification(region, municipality, town, usage)) {
                        return;
                    }
                    Vehicle bus = new Bus(volumeIndex, usage);
                    premiumPrice = PremiumCalculations.busCalculations(bus, client);
                    premiumPrice(premiumPrice);
                    paymentOfInstallments(premiumPrice);
                    break;
                case Constants.SADDLE_TRACTORS:
                    if (addressAndUsageVerification(region, municipality, town, usage)) {
                        return;
                    }
                    Vehicle saddleTractor = new SaddleTractor(usage);
                    premiumPrice = PremiumCalculations.saddleTractors(saddleTractor, client);
                    premiumPrice(premiumPrice);
                    paymentOfInstallments(premiumPrice);
                    break;

                case Constants.MOTORCYCLE:
                    if (volumeIndex == -1) {
                        Toolkit.getDefaultToolkit().beep();
                        JOptionPane.showMessageDialog(null, Constants.VOLUME_MESSGAE);
                        return;
                    }
                    if (addressAndUsageVerification(region, municipality, town, usage)) {
                        return;
                    }
                    if (termIndex == -1 || insuranceTermComboBox.getSelectionModel().getSelectedItem().equals(Constants.SELECT)) {
                        Toolkit.getDefaultToolkit().beep();
                        JOptionPane.showMessageDialog(null, "Избери срок на застраховката !");
                        return;
                    }
                    motorcycle = new Motorcycle(volumeIndex, carYear, usage, termIndex);
                    premiumPrice = PremiumCalculations.bikeCalculations(motorcycle, client);
                    premiumPrice(premiumPrice);
                    paymentOfInstallments(premiumPrice);
                    break;
                case Constants.ATV:
                    if (addressAndUsageVerification(region, municipality, town, usage)) {
                        return;
                    }
                    Vehicle atv = new ATV(usage);
                    premiumPrice = PremiumCalculations.calculationsATV(atv, client);
                    premiumPrice(premiumPrice);
                    paymentOfInstallments(premiumPrice);
                    break;
                case Constants.CARGO_TRAILER:
                    if (addressAndUsageVerification(region, municipality, town, usage)) {
                        return;
                    }
                    Vehicle cargoTrailer = new CargoTrailer(usage);
                    premiumPrice = PremiumCalculations.cargoTrailer(cargoTrailer, client);
                    premiumPrice(premiumPrice);
                    paymentOfInstallments(premiumPrice);
                    break;
                case Constants.LUGGAGE_TRAILERS:
                    if (addressAndUsageVerification(region, municipality, town, usage)) {
                        return;
                    }
                    Vehicle luggageTrailer = new LuggageTrailer(usage);
                    premiumPrice = PremiumCalculations.luggageTrailers(luggageTrailer, client);
                    premiumPrice(premiumPrice);
                    paymentOfInstallments(premiumPrice);
                    break;

                case Constants.CAMPING_TRAILERS:
                    if (volumeIndex == -1) {
                        Toolkit.getDefaultToolkit().beep();
                        JOptionPane.showMessageDialog(null, "Избери срок на застраховката !");
                        return;
                    }
                    if (addressAndUsageVerification(region, municipality, town, usage)) {
                        return;
                    }
                    Vehicle campingTrailers = new CampingTrailers(volumeIndex, usage);
                    premiumPrice = PremiumCalculations.campingTrailers(campingTrailers, client);
                    premiumPrice(premiumPrice);
                    paymentOfInstallments(premiumPrice);
                    break;
                case Constants.TROLLEYBUSES:
                    if (addressAndUsageVerification(region, municipality, town, usage)) {
                        return;
                    }
                    Vehicle trolleybus = new Trolleybus(usage);
                    premiumPrice = PremiumCalculations.trolleyBusesCalculations(trolleybus, client);
                    premiumPrice(premiumPrice);
                    paymentOfInstallments(premiumPrice);
                    break;
                case Constants.AGRICULTURAL_MACINERY:
                    if (addressAndUsageVerification(region, municipality, town, usage)) {
                        return;
                    }
                    Vehicle agriculturalMachinery = new AgriculturalMachinery(usage);
                    premiumPrice = PremiumCalculations.agriculturalMachineryCalculations(agriculturalMachinery, client);
                    premiumPrice(premiumPrice);
                    paymentOfInstallments(premiumPrice);
                    break;
                case Constants.CONSTRUCTION_MACHINERY:
                    if (addressAndUsageVerification(region, municipality, town, usage)) {
                        return;
                    }
                    Vehicle constructionMachinery = new ConstructionMachinery(usage);
                    premiumPrice = PremiumCalculations.constructionMachinery(constructionMachinery, client);
                    premiumPrice(premiumPrice);
                    paymentOfInstallments(premiumPrice);
                    break;

            }
        });
    }

    private void premiumPrice(double price) {
        String format = String.format("%.2f", price);
        totalPrice.setText(format + " лв.");
    }

    private void paymentOfInstallments(double price) {
        double firstInst = (price * 0.53);
        String format1 = String.format("%.2f", firstInst);
        double secondInst = (price * 0.47);
        String format2 = String.format("%.2f", secondInst);
        double thirdInst = (price * 0.29);
        String format3 = String.format("%.2f", thirdInst);
        double fourthInst = (price * 0.24);
        String format4 = String.format("%.2f", fourthInst);
        installments1.setText("Първа вноска = " + format1 + " лв.");
        installment2.setText("Втора вноска = " + format2 + " лв.");
        installment3.setText("Първа вноска = " + format3 + " лв.");
        installment4.setText("Втора вноска = " + format4 + " лв.");
        installment5.setText("Трета вноска = " + format4 + " лв.");
        installment6.setText("Четвърта вноска = " + format4 + " лв.");
    }

    private void setVehicle(Map<Integer, String> vehicleType, Map<Integer, String> volume1,
                            Map<Integer, String> motorcycleVolume,
                            Map<Integer, String> truckLoadability, Map<Integer, String> busSeats, Map<Integer, String> insuranceTerm) {

        List<String> carVolume = new ArrayList<>(volume1.values());
        List<String> bikeVolume = new ArrayList<>(motorcycleVolume.values());
        List<String> truckLoads = new ArrayList<>(truckLoadability.values());
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
