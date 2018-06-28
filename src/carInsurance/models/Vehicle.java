package carInsurance.models;

public abstract class Vehicle {
    private int yearOfProduction;
    private int engineVolume;
    private int usageOfTheVehicle;

    Vehicle(int carYear, int engineVolume, int usageOfTheVehicle) {
         this.yearOfProduction = carYear;
         this.engineVolume = engineVolume;
         this.usageOfTheVehicle = usageOfTheVehicle;
    }


    Vehicle(int carYear, int usageOfTheVehicle) {
        this.yearOfProduction = carYear;
        this.usageOfTheVehicle = usageOfTheVehicle;
    }

    public int getCarYear() {
        return yearOfProduction;
    }

    public int getEngineVolume() {
        return this.engineVolume;
    }

    public int getUsageOfTheVehicle() {
        return usageOfTheVehicle;
    }


}
