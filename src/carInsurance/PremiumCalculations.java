package carInsurance;

import carInsurance.models.Car;
import carInsurance.models.Client;
import carInsurance.models.Truck;
import carInsurance.models.Vehicle;

public class PremiumCalculations {
    private double premium ;
    public PremiumCalculations() {
        this.premium = 0.0;
    }
    public double truckPremiumCalculations(Truck truck, Client client) {

        if (truck.getLoadability() == 1.5) {
            premium = (1500 * 0.05);
        }
        if (truck.getLoadability() > 1.5 && truck.getLoadability() <= 3.5) {
            premium = (2000 * 0.05);
        }
        if (truck.getLoadability() > 3.5 && truck.getLoadability() <= 5.0) {
            premium = (3000 * 0.05);
        }
        if (truck.getLoadability() > 5.0) {
            premium = (3500 * 0.05);
        }

        premium = getCalculateClientYears(client, premium);
        premium = getAddressCalculations(client, premium);
        premium = getVehicleUsageCalculations(truck, premium);

        return premium;
    }

    private double getCalculateClientYears(Client client, double premium) {
        if (client.getYearsOfTheClient() >= 18 && client.getYearsOfTheClient() <= 26) {
            premium += 50;
        }
        if (client.getYearsOfTheClient() > 26 && client.getYearsOfTheClient() <= 36) {
            premium += 45;
        }
        if (client.getYearsOfTheClient() > 36 && client.getYearsOfTheClient() <= 46) {
            premium += 40;
        }
        if (client.getYearsOfTheClient() > 46 && client.getYearsOfTheClient() <= 56) {
            premium += 45;
        }
        if (client.getYearsOfTheClient() > 56) {
            premium += 50;
        }
        return premium;
    }

    public double carPremiumCalculations(Car car, Client client) {

        if (car.getEngineVolume() >= 1100 && car.getEngineVolume() <= 1200) {
            premium = (1100 * 0.05) + 10;
        }
        if (car.getEngineVolume() > 1200 && car.getEngineVolume() <= 1400) {
            premium = (1300 * 0.05) + 13;
        }
        if (car.getEngineVolume() > 1400 && car.getEngineVolume() <= 1600) {
            premium = (1500 * 0.05) + 15.2;
        }
        if (car.getEngineVolume() > 1600 && car.getEngineVolume() <= 2500) {
            premium = (1700 * 0.05) + 18;
        }
        if (car.getEngineVolume() > 2500) {
            premium = (2000 * 0.05) + 21;
        }
        premium = getCalculateClientYears(client, premium);
        premium = getAddressCalculations(client, premium);
        premium = getVehicleUsageCalculations(car, premium);
        return premium;
    }


    private double getAddressCalculations(Client client, double premium) {
        switch (client.getAddressOfTheClient()) {
            case "София":
                premium += 35;
                break;
            case "Варна":
                premium += 22; // и т.н.
                break;
            default:
                break;

        }
        return premium;
    }

    private double getVehicleUsageCalculations(Vehicle vehicle, double premium) {
        String usage = vehicle.getUsageOfTheVehicle().toLowerCase();
        switch (usage) {
            case "личен":
                premium += 25;
                break;
            case "служебен":
                premium += 30; // и т.н.
                break;
            default:
                break;
        }
        return premium;
    }


}
