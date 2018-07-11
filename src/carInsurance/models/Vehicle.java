package carInsurance.models;

public abstract class Vehicle {
    private int yearOfProduction;
    private int engineVolume;
    private int vehicleUsage;

    Vehicle(int engineVolume, int year, int vehicleUsage) {
         this.yearOfProduction = year;
         this.engineVolume = engineVolume;
         this.vehicleUsage = vehicleUsage;
    }


    Vehicle(int engineVolume, int vehicleUsage) {
        this.engineVolume = engineVolume;
        this.vehicleUsage = vehicleUsage;
    }

    Vehicle(int vehicleUsage){
        this.vehicleUsage = vehicleUsage;
    }

    public int getYear() {
        return yearOfProduction;
    }

    public int getEngineVolume() {
        return this.engineVolume;
    }

    public int getUsageOfTheVehicle() {
        return vehicleUsage;
    }


}
