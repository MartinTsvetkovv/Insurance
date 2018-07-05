package carInsurance.models;


public class Car extends Vehicle {

    public Car(int carYear, int vehicleUsage){
        super(carYear, vehicleUsage);
    }

    public Car(int carYear, int engineVolume, int usageOfTheVehicle) {
        super(carYear, engineVolume, usageOfTheVehicle);

    }

}
