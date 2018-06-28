package carInsurance.models;

public class Motorcycle extends Vehicle {
    private int durationOfTheInsurance;

    public Motorcycle(int carYear, int engineVolume, int usageOfTheVehicle, int durationOfTheInsurance) {
        super(carYear, engineVolume, usageOfTheVehicle);
        this.durationOfTheInsurance = durationOfTheInsurance;
    }

    public int getDurationOfTheInsurance() {
        return durationOfTheInsurance;
    }


}
