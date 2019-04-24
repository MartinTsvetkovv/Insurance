package carInsurance.models;

import carInsurance.interfaces.Vehicle;
import insuranceFx.Constants;

public abstract class AbstractVehicle implements Vehicle {


    private int yearOfProduction;
    private int engineVolume;
    private int vehicleUsage;

    protected  AbstractVehicle(int engineVolume, int year, int vehicleUsage) {
        this.yearOfProduction = year;
        this.engineVolume = engineVolume;
        this.vehicleUsage = vehicleUsage;
    }


    protected  AbstractVehicle(int engineVolume, int vehicleUsage) {
        this(engineVolume, Constants.DEFAULT_YEAR, vehicleUsage);

    }

    protected  AbstractVehicle(int vehicleUsage) {
        this(Constants.DEFAULT_ENGINE_VOLUME, Constants.DEFAULT_YEAR, vehicleUsage);

    }


    public int getYear() {
        return this.yearOfProduction;
    }

    public int getEngineVolume() {
        return this.engineVolume;
    }

    public int getUsageOfTheVehicle() {
        return this.vehicleUsage;
    }
}

