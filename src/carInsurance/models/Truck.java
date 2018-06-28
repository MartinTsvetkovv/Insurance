package carInsurance.models;

public class Truck extends Vehicle {
    private int loadability;

    public Truck(int carYear, int usageOfTheVehicle, int loadability) {
        super(carYear, usageOfTheVehicle);
        this.setLoadability(loadability);
    }

    public void setLoadability(int loadability) {
        if (loadability < 1.5){
            throw new IllegalArgumentException("Invalid loadability.");
        }
        this.loadability = loadability;
    }

    public double getLoadability() {
        return loadability;
    }
}
