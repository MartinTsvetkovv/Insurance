package carInsurance.models;


public class Car extends Vehicle {

    public Car(int engineVolume, int vehicleUsage){
        super(engineVolume, vehicleUsage);
    }

    public Car( int engineVolume,int carYear, int vehicleUsage) {
        super(engineVolume,carYear,  vehicleUsage);

    }

    public Car(int vehicleUsage){
        super(vehicleUsage);
    }

}
