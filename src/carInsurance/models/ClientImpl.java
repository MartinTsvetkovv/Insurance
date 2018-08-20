package carInsurance.models;


import carInsurance.interfaces.Client;

public class ClientImpl implements Client {
    private int years;
    private String region;
    private String carAccidents;
    private String municipality;
    private String town;

    public ClientImpl(int yearsOfTheClient, String region, String municipality, String town, String carAccidents) {
        this.setYearsOfTheClient(yearsOfTheClient);
        this.region = region;
        this.carAccidents = carAccidents;
        this.municipality = municipality;
        this.town = town;
    }

    private void setYearsOfTheClient(int yearsOfTheClient) {
        if (yearsOfTheClient < 18 || yearsOfTheClient > 100) {
            throw new IllegalArgumentException("Invalid owner's years.");
        }
        this.years = yearsOfTheClient;
    }
    public int getYearsOfTheClient() {
        return years;
    }
    public String getRegion() {
        return this.region;
    }

    public String getCarAccidents() {
        return this.carAccidents;
    }

    public String getMunicipality() {
        return this.municipality;
    }
    public String getTown() {
        return this.town;
    }
}
