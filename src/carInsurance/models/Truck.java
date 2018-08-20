package carInsurance.models;

import carInsurance.interfaces.TruckInsurance;

public class Truck extends AbstractVehicle implements TruckInsurance {
    private int loadAbility;

    public Truck(int loadAbility, int usageOfTheVehicle, int carYear) {
        super(carYear, usageOfTheVehicle);
        this.loadAbility = loadAbility;

    }
     @Override
    public int getLoadAbility() {
        return loadAbility;
    }
}
