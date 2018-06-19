package carInsurance.models;

public class Truck extends Vehicle {
    private double loadability;

    public Truck(int carYear, String usageOfTheVehicle, double loadability) {
        super(carYear, usageOfTheVehicle);
        this.setLoadability(loadability);
    }

    public void setLoadability(double loadability) {
        if (loadability < 1.5){
            throw new IllegalArgumentException("Invalid loadability.");
        }
        this.loadability = loadability;
    }

    public double getLoadability() {
        return loadability;
    }
}
