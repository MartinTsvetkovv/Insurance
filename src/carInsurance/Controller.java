package carInsurance;

import carInsurance.interfaces.Truck;
import carInsurance.models.Car;
import carInsurance.models.ClientImpl;

import java.util.Scanner;

public class Controller {

    private Car car;
    private ClientImpl clientImpl;
    private Truck truck;
    private PremiumCalculations premiumCalculations;

    public Controller() {

    }

    public void carInput(Scanner scanner) {
        System.out.print("Кубатура: ");
        int volume = Integer.parseInt(scanner.nextLine());
        System.out.print("Година на производство: ");
        int year = Integer.parseInt(scanner.nextLine());
        System.out.print("Възраст на водача: ");
        int years = Integer.parseInt(scanner.nextLine());
        System.out.print("Град: ");
        String region = scanner.nextLine();
        System.out.print("Използва за: ");
        String usage = scanner.nextLine();
        //car = new Car(year, volume, usage);
        if (clientYearsValidation(years, region)){
            return;
        }
        //premiumCalculations = new PremiumCalculations();
        //System.out.println(premiumCalculations.carPremiumCalculations(car, clientImpl));
    }



    public void truckInput(Scanner scanner) {
        System.out.print("Година на производство: ");
        int year = Integer.parseInt(scanner.nextLine());
        System.out.print("Товаримост: ");
        String[] input = scanner.nextLine().split(" ");
        double load = Double.parseDouble(input[0]);
        System.out.print("Възраст на водача: ");
        int years = Integer.parseInt(scanner.nextLine());
        System.out.print("Град: ");
        String region = scanner.nextLine();
        System.out.print("Използва за: ");
        String usage = scanner.nextLine();
        try{
           // truck = new Truck(year,usage,load);
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
        if (clientYearsValidation(years, region)){
            return;
        }
        //premiumCalculations = new PremiumCalculations();
        //System.out.println(premiumCalculations.truckPremiumCalculations(truck,clientImpl));

    }
    private boolean clientYearsValidation(int years, String region) {
        try {
            //clientImpl = new ClientImpl(years, region);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return true;
        }
        return false;
    }
}
