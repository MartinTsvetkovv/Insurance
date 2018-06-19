

import insuranceFx.ControllerFx;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.*;


public class Main extends Application {

    private static final String TRUCK = "товарен автомобил";
    private static final String CAR_VEHICLE = "Лек автомобил";
    private static final String ELECTRIC_VEHICLE = "Електромобил";
    private static final String SSL_CONNECTION = "?autoReconnect=true&useSSL=false";
    //private static Controller controller;
    private static Scanner scanner;

    public static void main(String[] args) throws FileNotFoundException, SQLException, ClassNotFoundException {
        launch(args);


    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/insuranceFx/insurance.fxml"));
        //Parent root = FXMLLoader.load(getClass().getResource("/insuranceFx/insurance.fxml"));

        Parent root = loader.load();
        ControllerFx controllerFx = loader.getController();

        primaryStage.setTitle("Car Insurance");
        primaryStage.setScene(new Scene(root, 800, 500));
        primaryStage.show();

        controllerFx.setInsuranceData();


    }
}


//        scanner = new Scanner(System.in);
//        controller = new Controller();
//
//        System.out.print("Вид МПС: ");
//        String vehicle = scanner.nextLine().toLowerCase();
//        switch (vehicle){
//            case (CAR_VEHICLE):
//                controller.carInput(scanner);
//                break;
//            case ELECTRIC_VEHICLE :
//                controller.carInput(scanner);
//                break;
//            case TRUCK:
//                controller.truckInput(scanner);
//                break;
//        }





//        Enumeration<Integer> enumeration;
//        int key;
//        for (enumeration = dataBaseInfo.keys(); enumeration.hasMoreElements(); ) {
//            key = enumeration.nextElement();
//            System.out.println(key + ": " + dataBaseInfo.get(key));
//        }

