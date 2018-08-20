package carInsurance.models;


import carInsurance.interfaces.Motorcycle;

public class MotorcycleImpl extends AbstractVehicle implements Motorcycle {
    private int durationOfTheInsurance;

    public MotorcycleImpl(int carYear, int engineVolume, int usageOfTheVehicle, int durationOfTheInsurance) {
        super(carYear, engineVolume, usageOfTheVehicle);
        this.durationOfTheInsurance = durationOfTheInsurance;
    }
    @Override
    public int getDurationOfTheInsurance() {
        return this.durationOfTheInsurance;
    }


}
