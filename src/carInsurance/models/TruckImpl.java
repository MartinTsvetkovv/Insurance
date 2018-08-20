package carInsurance.models;


import carInsurance.interfaces.Truck;

public class TruckImpl extends AbstractVehicle implements Truck {
    private int loadAbility;

    public TruckImpl(int loadAbility, int usageOfTheVehicle, int carYear) {
        super(carYear, usageOfTheVehicle);
        this.loadAbility = loadAbility;

    }
     @Override
    public int getLoadAbility() {
        return this.loadAbility;
    }
}
