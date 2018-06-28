package carInsurance;

import carInsurance.models.Car;
import carInsurance.models.Client;
import carInsurance.models.Truck;
import carInsurance.models.Vehicle;

public class PremiumCalculations {
    private static double premium;

    private PremiumCalculations() {
        premium = 0.0;
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

    private static double getCalculateClientYears(Client client, double premium) {
        if (client.getYearsOfTheClient() >= 18 && client.getYearsOfTheClient() <= 24) {
            premium += 90.98;
        } else {
            premium += 15.45;
        }

        return premium;
    }


    public static double carPremiumCalculations(Car car, Client client) {
        if (car.getEngineVolume() == 0 || car.getEngineVolume() == 1) {
            premium = (1100 * 0.11) + 17;
        } else if (car.getEngineVolume() == 2) {
            premium = (1100 * 0.11) + 18.32;
        } else if (car.getEngineVolume() == 3) {
            premium = (1100 * 0.11) + 19.21;
        } else if (car.getEngineVolume() == 4) {
            premium = (1100 * 0.11) + 22;
        }else if(car.getEngineVolume() == 5){
            premium = (1100 * 0.11) + 30.52;
        }else if(car.getEngineVolume() == 6){
            premium = (1100 * 0.11) + 63.65;
        }else if (car.getEngineVolume() == 7){
            premium = (1100 * 0.11) + 68;
        }else {
            premium = (1100 * 0.11) + 89.22;
        }

        premium = getCalculateClientYears(client, premium);
        premium = getAddressCalculations(client, premium);
        premium = getVehicleUsageCalculations(car, premium);
        premium = getCarYearsCalculations(car, premium);
        premium = getCarAccidentCalc(client, premium);
        return premium;
    }

    private static double getCarYearsCalculations(Vehicle vehicle, double premium) {
        if (vehicle.getCarYear() <= 2004) {
            premium += 7.36;
        } else {
            premium += 11.28;
        }
        return premium;
    }


    private static double getAddressCalculations(Client client, double premium) {
        switch (client.getAddressOfTheClient().toLowerCase()) {
            case "софия":
                premium += 30.25;
                break;
            case "варна":
                premium += 22.47; // и т.н.
                break;
            default:
                break;

        }
        return premium;
    }

    private static double getCarAccidentCalc(Client client, double premium){
        String carAccidents = client.getCarAccidents();
        if (carAccidents.equals("Да")){
            premium += 48.12;
        }
           return premium;
    }

    private static double getVehicleUsageCalculations(Vehicle vehicle, double premium) {
        int usage = vehicle.getUsageOfTheVehicle();
        switch (usage) {
            case 0:
                premium += 25;
                break;
            case 1:
                premium += 60.25; // и т.н.
                break;
            default:
                break;
        }
        return premium;
    }


}
