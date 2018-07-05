package carInsurance.models;

public class Truck extends Vehicle {
    private int loadability;

    public Truck(int carYear, int usageOfTheVehicle, int loadability) {
        super(carYear, usageOfTheVehicle);
        this.loadability = loadability;

    }

    public int getLoadability() {
        return loadability;
    }
}
