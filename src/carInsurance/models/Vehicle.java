package carInsurance.models;

public abstract class Vehicle {
    private int yearOfProduction;
    private int engineVolume;
    private String usageOfTheVehicle;

    Vehicle(int carYear, int engineVolume, String usageOfTheVehicle) {
         this.yearOfProduction = carYear;
         this.engineVolume = engineVolume;
         this.usageOfTheVehicle = usageOfTheVehicle;
    }


    Vehicle(int carYear, String usageOfTheVehicle) {
        this.yearOfProduction = carYear;
        this.usageOfTheVehicle = usageOfTheVehicle;
    }

    public int getCarYear() {
        return yearOfProduction;
    }

    public int getEngineVolume() {
        return engineVolume;
    }

    public String getUsageOfTheVehicle() {
        return usageOfTheVehicle;
    }


}
