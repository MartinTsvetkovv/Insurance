

import insuranceFx.ControllerFx;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);

    }
    @Override
    public void start(Stage primaryStage) throws Exception {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/insuranceFx/insurance.fxml"));
        //Parent root = FXMLLoader.load(getClass().getResource("/insuranceFx/insurance.fxml"));

        Parent root = loader.load();
        ControllerFx controllerFx = loader.getController();

        primaryStage.setTitle("Car Insurance");
        primaryStage.setScene(new Scene(root, 800, 660));
        primaryStage.show();

        controllerFx.setInsuranceData();


    }
}
