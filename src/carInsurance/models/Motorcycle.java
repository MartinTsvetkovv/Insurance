package carInsurance.models;

import carInsurance.interfaces.MotorcycleInsurance;

public class Motorcycle extends AbstractVehicle implements MotorcycleInsurance {
    private int durationOfTheInsurance;

    public Motorcycle(int carYear, int engineVolume, int usageOfTheVehicle, int durationOfTheInsurance) {
        super(carYear, engineVolume, usageOfTheVehicle);
        this.durationOfTheInsurance = durationOfTheInsurance;
    }
    @Override
    public int getDurationOfTheInsurance() {
        return this.durationOfTheInsurance;
    }


}
