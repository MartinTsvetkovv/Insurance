package carInsurance.models;

import java.util.ArrayList;
import java.util.List;

public class Client {
    private int years;
    private String addressOfTheClient;

    public Client(int yearsOfTheClient, String addressOfTheClient){
         this.setYearsOfTheClient(yearsOfTheClient);
         this.addressOfTheClient = addressOfTheClient;
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
}
