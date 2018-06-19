package carInsurance.models;

public class Motorcycle extends Vehicle {
    private String durationOfTheInsurance;

    public Motorcycle(int carYear, int engineVolume, String usageOfTheVehicle, String durationOfTheInsurance) {
        super(carYear, engineVolume, usageOfTheVehicle);
        this.durationOfTheInsurance = durationOfTheInsurance;
    }

    public String getDurationOfTheInsurance() {
        return durationOfTheInsurance;
    }


}
