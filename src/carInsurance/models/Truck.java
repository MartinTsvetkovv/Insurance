package carInsurance.models;

public class Truck extends Vehicle {
    private int loadAbility;

    public Truck(int loadAbility, int usageOfTheVehicle, int carYear) {
        super(carYear, usageOfTheVehicle);
        this.loadAbility = loadAbility;

    }

    public int getLoadAbility() {
        return loadAbility;
    }
}
