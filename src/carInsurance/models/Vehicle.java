package carInsurance.models;

public abstract class Vehicle {
    private int yearOfProduction;
    private int engineVolume;
    private int vehicleUsage;

    Vehicle(int year, int engineVolume, int vehicleUsage) {
         this.yearOfProduction = year;
         this.engineVolume = engineVolume;
         this.vehicleUsage = vehicleUsage;
    }


    Vehicle(int carYear, int vehicleUsage) {
        this.yearOfProduction = carYear;
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
