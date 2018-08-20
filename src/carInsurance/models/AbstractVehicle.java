package carInsurance.models;

import carInsurance.interfaces.Vehicle;

public abstract class AbstractVehicle implements Vehicle {
    private int yearOfProduction;
    private int engineVolume;
    private int vehicleUsage;

    AbstractVehicle(int engineVolume, int year, int vehicleUsage) {
        this.yearOfProduction = year;
        this.engineVolume = engineVolume;
        this.vehicleUsage = vehicleUsage;
    }


    AbstractVehicle(int engineVolume, int vehicleUsage) {
        this.engineVolume = engineVolume;
        this.vehicleUsage = vehicleUsage;
    }

    AbstractVehicle(int vehicleUsage) {
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

