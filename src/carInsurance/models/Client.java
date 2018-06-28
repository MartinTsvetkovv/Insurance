package carInsurance.models;

import java.util.ArrayList;
import java.util.List;

public class Client {
    private int years;
    private String addressOfTheClient;
    private String carAccidents;

    public Client(int yearsOfTheClient, String addressOfTheClient, String carAccidents){
         this.setYearsOfTheClient(yearsOfTheClient);
         this.addressOfTheClient = addressOfTheClient;
         this.carAccidents = carAccidents;
    }

    public int getYearsOfTheClient() {
        return years;
    }

    public String getAddressOfTheClient() {
        return addressOfTheClient;
    }

    private void setYearsOfTheClient(int yearsOfTheClient) {
        if (yearsOfTheClient < 18 || yearsOfTheClient > 100){
            throw new IllegalArgumentException("Invalid owner's years.");
        }
        this.years = yearsOfTheClient;
    }

    public String getCarAccidents() {
        return this.carAccidents;
    }
}
