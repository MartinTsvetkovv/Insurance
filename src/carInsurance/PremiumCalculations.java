package carInsurance;

import carInsurance.interfaces.Client;
import carInsurance.interfaces.Motorcycle;
import carInsurance.interfaces.Truck;
import carInsurance.interfaces.Vehicle;
import insuranceFx.Constants;

public class PremiumCalculations {

    private double premium;

    public PremiumCalculations() {
        this.premium = 0.0;
    }

    public double truckPremiumCalculations(Truck truckInsurance, Client client) {
        this.premium = 0;
        int usage = truckInsurance.getUsageOfTheVehicle();
        int load = truckInsurance.getLoadAbility();
        int useYears = client.getYearsOfTheClient();
        String carAccidents = client.getCarAccidents();
        boolean specialUsage = isSpecialUsage(usage);

        switch (load) {
            case Constants.UP_TO_TON_AND_A_HALF:
                this.premium += truckLoadCalc(client, load, usage, useYears, carAccidents, specialUsage);
                break;
            case Constants.UP_T0_THREE_TONS:
                this.premium += truckLoadCalc(client, load, usage, useYears, carAccidents, specialUsage);
                break;
            case Constants.UP_TO_FIVE_TONS:
               this.premium += truckLoadCalc(client, load, usage, useYears, carAccidents, specialUsage);
                break;
            case Constants.UP_TO_TEN_TONS:
                this.premium += truckLoadCalc(client,load,usage, useYears, carAccidents, specialUsage);
                break;
            case Constants.UP_TO_TWENTY_TONS:
               this.premium += truckLoadCalc(client, load,usage, useYears, carAccidents, specialUsage);
                break;
            case Constants.OVER_TWENTY_TONS:
                this.premium += truckLoadCalc(client, load, usage, useYears, carAccidents, specialUsage);
                break;

        }

        return this.premium;
    }
    public double campingTrailers(Vehicle vehicle, Client client) {
        this.premium = 0;
        int termOfTheInsurance = vehicle.getEngineVolume();
        String carAccidents = client.getCarAccidents();
        int userYears = client.getYearsOfTheClient();
        int vehicleUsage = vehicle.getUsageOfTheVehicle();
        boolean specialUsage = isSpecialUsage(vehicleUsage);

        switch (termOfTheInsurance) {
            case Constants.INSURANCE_TERM_UP_TO_30_DAYS:
                this.premium += upToThirtyDays(carAccidents, userYears, vehicleUsage, specialUsage);
                break;
            case Constants.INSURANCE_TERM_UP_TO_90_DAYS:
                this.premium += upToNinetyDays(carAccidents, userYears, vehicleUsage, specialUsage);
                break;
            case Constants.INSURANCE_TERM_UP_TO_180_DAYS:
                this.premium += upToOneHundredEightyAndOneYear(termOfTheInsurance,carAccidents,
                        userYears, vehicleUsage, specialUsage );
                break;
            case Constants.INSURANCE_TERM_UP_TO_1_YEAR:
                 this.premium +=upToOneHundredEightyAndOneYear(termOfTheInsurance,
                         carAccidents, userYears, vehicleUsage, specialUsage);
                break;
        }
        return this.premium;
    }

    public double luggageTrailers(Vehicle vehicle, Client client) {
        this.premium = 0;
        int vehicleUsage = vehicle.getUsageOfTheVehicle();
        int userYears = client.getYearsOfTheClient();
        String carAccidents = client.getCarAccidents();
        boolean specialUsage = isSpecialUsage(vehicleUsage);

        this.premium += luggageTrailersCalc(client, vehicleUsage, userYears, carAccidents, specialUsage);

        return this.premium;
    }

    public double trolleyBusesCalculations(Vehicle vehicle, Client client) {
        this.premium = 0;
        int vehicleUsage = vehicle.getUsageOfTheVehicle();
        int userYears = client.getYearsOfTheClient();
        String carAccidents = client.getCarAccidents();
        boolean specialUsage = isSpecialUsage(vehicleUsage);

        this.premium += trolleybusCalc(client, vehicleUsage, userYears, carAccidents, specialUsage);
        return this.premium;
    }

    public double constructionMachinery(Vehicle vehicle, Client client) {
        this.premium = 0;
        int vehicleUsage = vehicle.getUsageOfTheVehicle();
        int userYears = client.getYearsOfTheClient();
        boolean specialUsage = isSpecialUsage(vehicleUsage);
        this.premium += constructionMachineryCalc(client, vehicleUsage, userYears, specialUsage);

        return this.premium;
    }

    public double agriculturalMachineryCalculations(Vehicle machinery, Client client) {
        this.premium = 0;
        int vehicleUsage = machinery.getUsageOfTheVehicle();
        int userYears = client.getYearsOfTheClient();
        String carAccidents = client.getCarAccidents();
        boolean specialUsage = isSpecialUsage(vehicleUsage);
        this.premium += agricultureCalculations(client, vehicleUsage, userYears, carAccidents, specialUsage);

        return this.premium;
    }

    public double cargoTrailer(Vehicle cargoTrailer, Client client) {
        this.premium = 0;
        int vehicleUsage = cargoTrailer.getUsageOfTheVehicle();
        int userYears = client.getYearsOfTheClient();
        String carAccidents = client.getCarAccidents();
        boolean specialUsage = isSpecialUsage(vehicleUsage);
        this.premium += cargoCalculations(vehicleUsage, userYears, carAccidents, specialUsage);
        return this.premium;
    }

    public double saddleTractors(Vehicle vehicle, Client client) {
        this.premium = 0;
        int vehicleUsage = vehicle.getUsageOfTheVehicle();
        int userYears = client.getYearsOfTheClient();
        String carAccidents = client.getCarAccidents();
        boolean specialUsage = isSpecialUsage(vehicleUsage);
        this.premium += saddleTractorsCalc(vehicleUsage, userYears, carAccidents, specialUsage);

        return this.premium;
    }

    public double calculationsATV(Vehicle vehicle, Client client) {
        this.premium = 0;
        int vehicleUsage = vehicle.getUsageOfTheVehicle();
        int userYears = client.getYearsOfTheClient();
        String carAccidents = client.getCarAccidents();
        boolean specialUsage = isSpecialUsage(vehicleUsage);

        this.premium += atvCalculations(client, vehicleUsage, userYears, carAccidents, specialUsage);

        return this.premium;
    }

    public double busCalculations(Vehicle vehicle, Client client) {
        this.premium = 0;
        int busSeats = vehicle.getEngineVolume();
        String carAccidents = client.getCarAccidents();
        int userYears = client.getYearsOfTheClient();
        int vehicleUsage = vehicle.getUsageOfTheVehicle();
        boolean specialUsage = isSpecialUsage(vehicleUsage);

        if (isUpToTwentySeats(busSeats)){
            this.premium += upToTwentySeats(client, carAccidents, userYears, vehicleUsage, specialUsage);
        }
        if (isUptoFortyOrOver(busSeats)){
            this.premium += upToFortySeats(busSeats, carAccidents, userYears, vehicleUsage, specialUsage);
        }
        return this.premium;
    }

    public double bikeCalculations(Motorcycle motorcycleInsurance, Client client) {
        this.premium = 0;
        int engineVolume = motorcycleInsurance.getEngineVolume();
        int yearsOfTheClient = client.getYearsOfTheClient();
        int usage = motorcycleInsurance.getUsageOfTheVehicle();
        int durationOfTheInsurance = motorcycleInsurance.getDurationOfTheInsurance();
        boolean specialUsage = isSpecialUsage(usage);
        String municipality = client.getMunicipality();
        String town = client.getTown();

        this.premium += baseUsageCalculation(thirtyDaysInsurance(durationOfTheInsurance), Constants.BASE_DURATION_PRICE);

        if (isUpToThreeHundredFiftyCc(engineVolume)) {
            this.premium += upToThreeHundredFiftyCalc(client, yearsOfTheClient, usage, durationOfTheInsurance, specialUsage);
        }

        switch (engineVolume) {
            case Constants.UP_TO_FOUR_HUNDRED_NINETY:
                this.premium += upToFourHundredNinetyCc(engineVolume ,client, yearsOfTheClient, usage,
                        durationOfTheInsurance, specialUsage, municipality, town);
                break;
            case Constants.UP_TO_SEVEN_HUNDRED_FIFTY:
                this.premium += upToSevenHundredFiftyCc(client, engineVolume, yearsOfTheClient, usage,
                        durationOfTheInsurance, specialUsage, municipality, town);
                break;
            case Constants.OVER_SEVEN_HUNDRED_FIFTY:
                this.premium += overSevenHundredFiftyCc(client, engineVolume, yearsOfTheClient, usage,
                        durationOfTheInsurance, municipality, town);
                break;
        }
        return this.premium;
    }
    public double carPremiumCalculations(Vehicle vehicle, Client client) {
        this.premium = 0;
        int engineVolume = vehicle.getEngineVolume();
        int usage = vehicle.getUsageOfTheVehicle();
        String carAccidents = client.getCarAccidents();
        int carYear = vehicle.getYear();
        boolean specialUsage = isSpecialUsage(usage);

        if (upToTwelveHundred(engineVolume)) {
           this.premium += carCalculations(client, carYear, usage, carAccidents, specialUsage);

        }
        switch (engineVolume) {
            case Constants.UP_TO_ONE_THOUSAND_FOUR_HUNDRED:
                this.premium += upToOneThousandFourHundred(client, usage, carAccidents, carYear, specialUsage);
                break;
            case Constants.UP_TO_ONE_THOUSEND_SIX_HUNDRED:
                this.premium += upToOneThousandSixHundred(client, usage, carAccidents, carYear, specialUsage);
                break;
            case Constants.UP_TO_ONE_THOUSAND_EIGHT_HUNDRED:
                this.premium += upToOneThousandEightHundred(client, usage, carAccidents, carYear, specialUsage);
                break;
            case Constants.UP_TO_TWO_THOUSAND:
                this.premium += upToTwoThousand(client, usage, carAccidents, carYear, specialUsage);
                break;
            case Constants.UP_TO_TWO_THOUSAND_TWO_HUNDRED:
               this.premium += upToTwoThousandTwoHundred(client, usage, carAccidents, carYear, specialUsage);
                break;
            case Constants.UP_TO_TWO_THOUSAND_FIVE_HUNDRED:
                this.premium += upToTwoThousandFiveHundred(client, usage, carAccidents, carYear, specialUsage);
                break;
            case Constants.OVER_TWO_THOUSAND_FIVE_HUNDRED:
                this.premium += overTwoThousandFiveHundred(client, usage, carAccidents, carYear, specialUsage);
                break;
        }
        return premium;
    }

    private boolean upToTwelveHundred(int engineVolume) {
        return engineVolume == 0 || engineVolume == 1;
    }

    private double overTwoThousandFiveHundred(Client client, int usage, String carAccidents, int carYear, boolean specialUsage) {
        double addictive = 0;
       addictive += carCalculations(client, carYear, usage, carAccidents, specialUsage);

        if (isForPersonalUsage(usage)) {
            if (carAccidents.equals(Constants.CAR_ACCIDENT_CONFIRMATION)) {
                addictive -= 2.14;
            }
            addictive -= 9.12;
            //addictive += 74.2;///
        }
        addictive += baseCalculation(specialUsage,  137.53, 257.86, 102.9, 85.96,
                isTaxiUsage(usage), isRental(usage));
        addictive += baseUsageCalculation(vehicleAccidentConfirmation(carAccidents, specialUsage), 21.56);

        if (specialTownsBurgasSofiaStaraZagora(client)) {
           addictive += carCalculationsBurgasSofiaSz(usage, specialUsage);
        }
        if (specialTownsVarnaPlovdiv(client)) {
            addictive += baseUsageCalculation(isForPersonalUsage(usage), 3.8);
            addictive += baseCalculation(specialUsage, 7.3, 13.74, 5.74, 4.26, isTaxiUsage(usage),
                    isRental(usage));
            addictive +=baseUsageCalculation(vehicleAccidentConfirmation(carAccidents, specialUsage), 4.21);
        }
        if (client.getMunicipality().equalsIgnoreCase(Constants.SOFIA_TOWN)) {
            if (isForPersonalUsage(usage)) {
                addictive += baseUsageCalculation(carYear > 2003, 3.1);
                addictive += 7.93;
            }
           addictive += baseCalculation(specialUsage,  14.69, 27.54, 11.27, 9.18,
                   isTaxiUsage(usage), isRental(usage));
           addictive += baseUsageCalculation(vehicleAccidentConfirmation(carAccidents, specialUsage), 3.1);
        }
        return addictive;
    }
    private double constructionMachineryCalc(Client client, int vehicleUsage, int userYears, boolean specialUsage) {
        double addictive = 0;
        addictive += baseCalculation(specialUsage,  197.32, 358.68, 151.21, 128.16,
                isTaxiUsage(vehicleUsage), isRental(vehicleUsage));

        if (vehicleAccidentConfirmation(client.getCarAccidents(), specialUsage)) {
            addictive += 28.82;
        }

        addictive += baseUsageCalculation(isUserYearsLessThan24(userYears) && !specialUsage, 25.5);
        return addictive;
    }

    private double upToTwoThousandFiveHundred(Client client, int usage, String carAccidents, int carYear, boolean specialUsage) {
        double addictive = 0;
        addictive += carCalculations(client, carYear, usage, carAccidents, specialUsage);

        addictive += baseUsageCalculation(isForPersonalUsage(usage), -7.48);
        addictive += baseCalculation(specialUsage,  91.97, 171.94, 68.53, 57.32, isTaxiUsage(usage), isRental(usage));
        addictive += baseUsageCalculation(vehicleAccidentConfirmation(carAccidents, specialUsage), 14.32);

        if (specialTownsBurgasSofiaStaraZagora(client)) {
           addictive += carCalculationsBurgasSofiaSz(usage, specialUsage);
        }
        addictive += carCalculationsVarnaPlovdiv(client, usage, carAccidents, specialUsage);

        addictive += caCalculationsSofiaTown(client, carYear, usage, carAccidents, specialUsage);
        return addictive;
    }

    private double upToTwoThousandTwoHundred(Client client, int usage,
                                             String carAccidents, int carYear, boolean specialUsage) {
        double addictive = 0;
        addictive += carCalculations(client, carYear, usage, carAccidents, specialUsage);
        addictive += baseUsageCalculation(isForPersonalUsage(usage), -7.15);
        addictive += baseCalculation(specialUsage, 89.86, 168.48, 67.14, 56.16,
                isTaxiUsage(usage), isRental(usage));
        addictive += baseUsageCalculation(vehicleAccidentConfirmation(carAccidents, specialUsage), 14.0);
        if (specialTownsBurgasSofiaStaraZagora(client)) {
            addictive += carCalculationsBurgasSofiaSz(usage, specialUsage);
        }
       addictive += carCalculationsVarnaPlovdiv(client, usage, carAccidents, specialUsage);

        addictive += caCalculationsSofiaTown(client, carYear, usage, carAccidents, specialUsage);
        return addictive;
    }

    private double upToTwoThousand(Client client, int usage, String carAccidents, int carYear, boolean specialUsage) {
        double addictive = 0;
        addictive += carCalculations(client, carYear, usage, carAccidents, specialUsage);
       // addictive += baseUsageCalculation(isForPersonalUsage(usage), 14.86);
        addictive += baseCalculation(specialUsage, 23.84, 44.7, 17.63, 14.9,
                   isTaxiUsage(usage), isRental(usage));
        if (carAccidents.equalsIgnoreCase(Constants.CAR_ACCIDENT_CONFIRMATION) && !specialUsage) {
            addictive += 3.21;
        }
        if (specialTownsVarnaPlovdiv(client)) {
           addictive += baseUsageCalculation(isForPersonalUsage(usage), 7.77);
           addictive += baseCalculation(specialUsage, 14.66, 27.48, 11.24,
                    9.16, isTaxiUsage(usage), isRental(usage));
           addictive += baseUsageCalculation(vehicleAccidentConfirmation(carAccidents, specialUsage), 4.21);
        }

        if (client.getMunicipality().equalsIgnoreCase(Constants.SOFIA_TOWN)) {
           addictive += baseUsageCalculation(isForPersonalUsage(usage), 10.89);
           addictive += baseCalculation(specialUsage, 20.16, 37.79, 15.37, 12.6, isTaxiUsage(usage), isRental(usage));
           addictive += baseUsageCalculation(vehicleAccidentConfirmation(carAccidents, specialUsage), 4.21);
        }
        return addictive;
    }

    private double upToOneThousandSixHundred(Client client, int usage, String carAccidents, int carYear, boolean specialUsage) {
        double addictive = 0;
       addictive += carCalculations(client, carYear, usage, carAccidents, specialUsage);
        //return
       addictive += taxiAndSpecialUsageCalc(specialUsage, isTaxiUsage(usage), 3.38, 10.0);

        if (isRental(usage)) {
            addictive += 2.34;
        } else if (carAccidents.equals(Constants.CAR_ACCIDENT_CONFIRMATION) && specialTownsVarnaPlovdiv(client)) {
            addictive += 2.86;
        }
        addictive += baseUsageCalculation(client.getMunicipality().equalsIgnoreCase(Constants.SOFIA_TOWN), 2.1);
        addictive += 3.96;
        return addictive;
    }

    private double baseUsageCalculation(boolean usage, double v) {
        double addictive = 0;
        if (usage) {
            addictive += v;
        }
        return addictive;
    }

    private double upToOneThousandEightHundred(Client client, int usage, String carAccidents, int carYear, boolean specialUsage) {
        double addictive = 0;
        addictive += carCalculations(client, carYear, usage, carAccidents, specialUsage);
        addictive += taxiUsageAndRentalCarCalc(isTaxiUsage(usage), 5.06, isRental(usage), 2.3);
        addictive += taxiUsageAndRentalCarCalc(specialUsage, 14.68,
                vehicleAccidentConfirmation(carAccidents, specialUsage), 2.20);
        if (carAccidents.equals(Constants.CAR_ACCIDENT_CONFIRMATION) && specialTownsBurgasSofiaStaraZagora(client)) {
            addictive -= 3.1;
        }
        if (specialTownsVarnaPlovdiv(client) || client.getMunicipality().equalsIgnoreCase(Constants.SOFIA_TOWN)) {
            addictive += 4.95;
        }
        if ((specialTownsVarnaPlovdiv(client) && isTaxiUsage(usage))
                || (client.getMunicipality().equalsIgnoreCase(Constants.SOFIA_TOWN) && isTaxiUsage(usage))) {
            addictive += 4.98;
        }
        if ((specialTownsVarnaPlovdiv(client) && specialUsage) ||
                (client.getMunicipality().equalsIgnoreCase(Constants.SOFIA_TOWN) && specialUsage)) {
            addictive += 12.39;
        }
        if (specialTownsVarnaPlovdiv(client) && carAccidents.equals(Constants.CAR_ACCIDENT_CONFIRMATION)
                && !specialUsage) {
            addictive += 4.86;
        }
        addictive += 5.94;
        return addictive;
    }

    private double taxiUsageAndRentalCarCalc(boolean taxiUsage, double v, boolean rental, double v2) {
        double addictive = 0;
        if (taxiUsage) {
            addictive += v;
        }
        if (rental) {
            addictive += v2;
        }
        return addictive;
    }

    private double taxiAndSpecialUsageCalc(boolean specialUsage, boolean taxiUsage, double v, double v2) {
        double addictive = 0;
        if (taxiUsage) {
            addictive += v;
        }
        if (specialUsage) {
            addictive += v2;
        }
        return addictive;
    }
    private double upToOneThousandFourHundred(Client client, int usage, String carAccidents, int carYear, boolean specialUsage) {
        double addictive = 0;
         addictive += carCalculations(client, carYear, usage, carAccidents, specialUsage);
        if (isTaxiUsage(usage) || isRental(usage)) {
            addictive += 2.1;
        }
        if (specialUsage) {
            addictive += 5.1;
        }
//        if ((carYear > 2003 && !specialUsage) && (!specialTownsVarnaPlovdiv(client) && !specialTownsBurgasSofiaStaraZagora(client)
//                && !client.getMunicipality().equalsIgnoreCase(Constants.SOFIA_TOWN))) {
//            addictive += 1.86;
//        }
        addictive += 2.1;
        return addictive;
    }

    private double caCalculationsSofiaTown(Client client, int carYear, int usage, String carAccidents, boolean specialUsage) {
        double addictive = 0;
        if (client.getMunicipality().equalsIgnoreCase(Constants.SOFIA_TOWN)) {
            if (isForPersonalUsage(usage)) {
                if (carYear > 2003) {
                    addictive += 2.1;
                }
                addictive += 12.86;
            }
           addictive += baseCalculation(specialUsage,  25.66, 48.1, 19.5, 16.04,
                   isTaxiUsage(usage), isRental(usage));
            if (vehicleAccidentConfirmation(carAccidents, specialUsage)) {
                addictive += 4.21;
            }
        }
        return addictive;
    }

    private static boolean vehicleAccidentConfirmation(String carAccidents, boolean specialUsage) {
        return carAccidents.equals(Constants.CAR_ACCIDENT_CONFIRMATION) && !specialUsage;
    }

    private double userUnder24YearsTruckCalculations(int useYears, boolean specialUsage) {
        double addictive = 0;
        if (isUserYearsLessThan24(useYears) && !specialUsage) {
            addictive += 61.2;
        }
        return addictive;
    }

    private double carCalculationsVarnaPlovdiv(Client client, int usage, String carAccidents, boolean specialUsage) {
        double addictive = 0;
        if (specialTownsVarnaPlovdiv(client)) {
           addictive += baseUsageCalculation(isForPersonalUsage(usage), 8.75);
           addictive += baseCalculation(specialUsage,  16.5, 30.94, 12.63, 10.32, isTaxiUsage(usage), isRental(usage));
           addictive += baseUsageCalculation(vehicleAccidentConfirmation(carAccidents, specialUsage), 4.21);
        }
        return addictive;
    }

    private double carCalculationsBurgasSofiaSz(int usage, boolean specialUsage) {
        double addictive = 0;
        if (isForPersonalUsage(usage)) {
            addictive -= 3.69;
        }
        addictive += rentalAndSpecialUsageCalc(usage, isRental(usage), 6.62, specialUsage, 12.42, 4.6, 4.14);
        return addictive;
    }

    private double carSpecialMunicCalc(Client client, String carAccidents, double... args) {
        double addictive = 0;
        double v = args[0]; double v2 = args[1]; double v3 =args[2]; double v4 = args[3]; double v5 = args[4];
        if (client.getMunicipality().equalsIgnoreCase(Constants.SOFIA_TOWN)) {
            addictive += v;
        }
        if (specialTownsBurgasSofiaStaraZagora(client)) {
            addictive -= v2;
        }
        if (specialTownsVarnaPlovdiv(client)) {
            addictive += v3;
        }
        if (carAccidents.equals(Constants.CAR_ACCIDENT_CONFIRMATION)) {
            addictive += v4;
        }
        addictive += v5;
        return addictive;
    }

    public double electricCarCalculations(Vehicle vehicle, Client client) {
        premium = 0;
        int usage = vehicle.getUsageOfTheVehicle();
        String carAccidents = client.getCarAccidents();
        int userYears = client.getYearsOfTheClient();
        boolean specialUsage = isSpecialUsage(usage);

        premium += electricCarCalc(client, usage, carAccidents, userYears, specialUsage);

        return premium;
    }

    private double electricCarCalc(Client client, int usage, String carAccidents, int userYears, boolean specialUsage) {
        double addictive = 0;
        if (isForPersonalUsage(usage)) {
            if (carAccidents.equals(Constants.CAR_ACCIDENT_CONFIRMATION)) {
                addictive -= 6.19;
            }
            //addictive += 208.06;
        }
        addictive += baseCalculation(specialUsage,  364.79, 672.7, 276.82, 232.83, isTaxiUsage(usage), isRental(usage));
        //RETURN
        addictive += taxiAndSpecialUsageCalc(isUserYearsLessThan24(userYears) && !specialUsage, vehicleAccidentConfirmation(carAccidents, specialUsage), 54.98, 79.56);

        if (specialTownsBurgasSofiaStaraZagora(client)) {
            if (isForPersonalUsage(usage)) {
                addictive += 16.21;
            }
            addictive += rentalAndSpecialUsageCalc(usage, isRental(usage), 30.06, specialUsage, 56.37, 22.55, 18.79);
        }

        if (specialTownsVarnaPlovdiv(client)) {
            if (isForPersonalUsage(usage)) {
                addictive += 4.58;
            }
            addictive += baseCalculation(specialUsage,  7.33, 14.0, 5.49, 4.58, isTaxiUsage(usage),
                    isRental(usage));
            addictive +=baseUsageCalculation(vehicleAccidentConfirmation(carAccidents, specialUsage), 1.67);
        }
        if (client.getMunicipality().equalsIgnoreCase(Constants.SOFIA_TOWN)) {
            addictive += baseUsageCalculation(isForPersonalUsage(usage), 12.86);
            addictive += baseCalculation(specialUsage,  23.83, 44.67, 17.87, 14.89,
                    isTaxiUsage(usage), isRental(usage));
            addictive += baseUsageCalculation(vehicleAccidentConfirmation(carAccidents, specialUsage), 3.5);
        }
        return addictive;
    }

    private boolean isForPersonalUsage(int usage) {
        return usage == 0;
    }

    private static boolean specialRegionCalculations(Client client, String municipality, String town) {
        return (municipality.equalsIgnoreCase(Constants.VARNA_MUNICIPALITY) && town.equalsIgnoreCase(Constants.VARNA_TOWN)) ||
                (municipality.equalsIgnoreCase(Constants.PLOVDIV_TOWN) && town.equalsIgnoreCase(Constants.PLOVDIV_TOWN)) ||
                (municipality.equalsIgnoreCase(Constants.SOFIA_TOWN) && !client.getCarAccidents().equals(Constants.CAR_ACCIDENT_CONFIRMATION));

    }

    private static boolean specialTownsBurgasSofiaStaraZagora(Client client) {
        return client.getTown().equalsIgnoreCase(Constants.BURGAS_TOWN) || client.getTown().equalsIgnoreCase(Constants.STARA_ZAGORA_TOWN)
                || client.getRegion().equalsIgnoreCase(Constants.SOFIA_TOWN1);
    }

    private static boolean specialTownsVarnaPlovdiv(Client client) {
        return client.getMunicipality().equalsIgnoreCase(Constants.PLOVDIV_TOWN)
                || client.getTown().equalsIgnoreCase(Constants.VARNA_TOWN);
    }


    private double under24YearsUsers(int userYears, int vehicleUsage) {
        double addictive = 0;
        if (isUserYearsLessThan24(userYears) && isTaxiUsage(vehicleUsage)) {
            addictive += 60.5;
        } else if (isUserYearsLessThan24(userYears) && isRental(vehicleUsage)) {
            addictive += 61.19;
        } else if (isUserYearsLessThan24(userYears) && (isUsingSpecialUsage(vehicleUsage))) {
            addictive += 61.20;
        }
        return addictive;
    }

    private static boolean capitolSpecialPremium(Client client) {
        return client.getRegion().equalsIgnoreCase(Constants.SOFIA_CAPITAL)
                && client.getMunicipality().equalsIgnoreCase(Constants.SOFIA_TOWN);
    }

    private static boolean specialTownATVCalculations(Client client) {
        return client.getRegion().equalsIgnoreCase(Constants.SOFIA_CAPITAL)
                || client.getMunicipality().equalsIgnoreCase(Constants.PLOVDIV_TOWN)
                || client.getTown().equalsIgnoreCase(Constants.VARNA_TOWN);
    }

    private double under24YearsUserCalculations(int userYears, boolean specialUsage) {
        double addictive = 0;
       addictive+= baseUsageCalculation(isUserYearsLessThan24(userYears) && !specialUsage, 25.5);
        return addictive;
    }
    private boolean isRental(int usage) {
        return usage == 5;
    }


    private static boolean isSpecialUsage(int usage) {
        return usage == 3 || usage == 6 || usage == 7 || usage == 8;
    }
    private boolean isTaxiUsage(int usage) {
        return usage == 2;
    }
    private double truckLoadCalc(Client client, int load, int usage, int useYears, String carAccidents, boolean isSpecialUsage) {

        double addictive = 0;
        double add1 = 0;  double add2 = 0;  double add3 = 0;  double add4 = 0; double add5 = 0;
        switch (load) {

            case Constants.UP_TO_TON_AND_A_HALF :
                add1 = 358.88; add2 = 661.62; add3 = 272.39; add4 = 229.14; add5 = 54.06;
                addictive += truckSofiaTownCalculations(load, client, usage, carAccidents, isSpecialUsage);
                break;
            case Constants.UP_T0_THREE_TONS:
                add1 = 407.84;  add2 = 753.42;  add3 = 309.11;  add4 = 259.74;  add5 = 61.71;
                addictive += truckSofiaTownCalculations(load,client, usage, carAccidents, isSpecialUsage);
                break;
            case Constants.UP_TO_FIVE_TONS:
                add1 = 489.44; add2 = 906.42; add3 = 370.31; add4 = 310.74; add5 = 74.46;
                addictive += truckSofiaTownCalculations(load,client, usage, carAccidents, isSpecialUsage);
                break;
            case Constants.UP_TO_TEN_TONS:
                add1 = 1563.3; add2 = 2919.9; add3 = 1175.7; add4 = 981.9; add5 = 242.25;
                break;
            case Constants.UP_TO_TWENTY_TONS:
                add1 = 2183.46; add2 = 4082.7; add3 = 1640.82; add4 = 1369.5; add5 = 339.15;
                break;
            case Constants.OVER_TWENTY_TONS:
                add1 = 2493.54; add2 = 4664.1; add3 = 1873.38; add4 = 1563.3; add5 = 387.6;
                break;
        }
        addictive += baseCalculation(isSpecialUsage, add1, add2, add3, add4, isTaxiUsage(usage), isRental(usage));

        if (vehicleAccidentConfirmation(carAccidents, isSpecialUsage)) {
            addictive += add5;
        }
        addictive += userUnder24YearsTruckCalculations(useYears, isSpecialUsage);
        return addictive;
    }

    private double baseCalculation(boolean isSpecialUsage, double add1, double add2, double add3, double add4,
                                   boolean taxiUsage, boolean rental) {
        double addictive = 0;
        if (taxiUsage) {
            addictive += add1;
        } else if (isSpecialUsage) {
            addictive += add2;
        } else if (rental) {
            addictive += add3;
        } else {
            addictive += add4;
        }
        return addictive;
    }

    private double truckSofiaTownCalculations(int load, Client client, int usage, String carAccidents, boolean specialUsage) {
        double add1; double add2; double add3; double add4; double add5;
        double addictive = 0;

        switch (load){
            case Constants.UP_TO_TON_AND_A_HALF:
                add1 = 8.16; add2 = 15.3; add3 = 6.12; add4 = 6.12; add5 = 0;
                break;
            default:
                add1 = 16.32; add2 = 30.6; add3 = 12.24; add4 = 10.2; add5 = 3.1;
                break;
        }

        if (client.getMunicipality().equalsIgnoreCase(Constants.SOFIA_TOWN)) {
            addictive += baseCalculation(specialUsage, add1, add2, add3, add4, isTaxiUsage(usage), isRental(usage));
            if (vehicleAccidentConfirmation(carAccidents, specialUsage)) {
                addictive += add5;
            }
        }
        return addictive;
    }
    private double overSevenHundredFiftyCc(Client client, int engineVolume,
                                           int yearsOfTheClient, int usage, int durationOfTheInsurance, String municipality, String town) {
        double addictive = 0;

        if (isTaxiUsage(usage)) {
            addictive += baseDurationAndSpecialRegionCalc(client, durationOfTheInsurance, municipality, town, 7.68);
            addictive += 118.32;
            addictive += overSevenHundredFiftyCcDurationCalc(client, durationOfTheInsurance,
                    municipality, town, 1, 10.2, 39.42);
            if (isTaxiUsage(durationOfTheInsurance)) {
                if (specialRegionCalculations(client, municipality, town)) {
                    addictive -= 12.24;
                }
                addictive += 68.39;
            }
            addictive += overSevenHundredFiftyCcDurationCalc(client, durationOfTheInsurance,
                    municipality, town, 3, 16.32, 126.32);
        }
        addictive += noTaxiUsageBikeCalc(client, engineVolume, yearsOfTheClient, usage, durationOfTheInsurance, isSpecialUsage(usage),
                municipality, town, 25.66, 35.72, 64.68, 122.62, 324.8, 5.81, 7.12,
                37.21, 9.16, 66.18, 12.23, 123.11, 63.59, 4.08, 30.56, 59.52, 117.46);
        return addictive;
    }

    private double upToSevenHundredFiftyCc(Client client, int engineVolume, int yearsOfTheClient, int usage, int durationOfTheInsurance,
                                           boolean specialUsage, String municipality, String town) {
        double addictive = 0;
        if (isTaxiUsage(usage)) {
            addictive += baseDurationAndSpecialRegionCalc(client, durationOfTheInsurance, municipality, town, 7.74);

            addictive += insuranceDurationAndSpecialRegions(client, durationOfTheInsurance, municipality, town,
                    10.16, 32.94, 12.24, 56.85, 16.32, 104.58, 99.26);
        }
        addictive += noTaxiUsageBikeCalc(client, engineVolume, yearsOfTheClient, usage,
                durationOfTheInsurance, specialUsage, municipality, town,
                21.93, 33.08, 56.94, 104.68, 266.24, 5.87, 6.12, 33.22, 8.11,
                57.09, 12.24, 104.83, 51.28, 4.04, 28.32, 44.22, 91.96);
        return addictive;
    }

    private double noTaxiUsageBikeCalc(Client client, int engineVolume, int yearsOfTheClient, int usage,
                                       int durationOfTheInsurance, boolean specialUsage, String municipality, String town,
                                       double... args) {
        double addictive = 0;
        double v = args[0]; double v2 = args[1]; double v3 = args[2];
        double v4 = args[3]; double v5 = args[4]; double v6 = args[5];
        double v7 = args[6]; double v8 = args[7]; double v9 = args[8];
        double v10 = args[9]; double v11 = args[10]; double v12 = args[11];
        double v13 = args[12]; double v14= args[13]; double v15 = args[14];
        double v16 = args[15]; double v17 = args[16];

        if (specialUsage) {
            addictive += baseDurationAndSpecialRegionCalc(client, durationOfTheInsurance, municipality, town, v);

            addictive += insuranceDurationAndSpecialRegions(client, durationOfTheInsurance, municipality, town,
                    24.48, v2, 26.52, v3, 30.6, v4, v5);
        } else if (isRental(usage)) {
            addictive += baseDurationAndSpecialRegionCalc(client, durationOfTheInsurance, municipality, town, v6);

            addictive +=  insuranceDurationAndSpecialRegions(client, durationOfTheInsurance, municipality, town,
                    v7, v8, v9, v10, v11, v12, v13);
        } else {
            addictive += insuranceDurationAndSpecialRegions(client, durationOfTheInsurance, municipality, town,
                    v14, v15, 6.12, v16, 10.2, v17, 40.28);
        }
        addictive += userUnderTwentyFourBikeCalc(engineVolume, yearsOfTheClient, usage, durationOfTheInsurance,
                isUserYearsLessThan24(yearsOfTheClient), isTaxiUsage(usage), isRental(usage));

        addictive += underTwentyFourWithAccident(engineVolume, client, yearsOfTheClient, usage, durationOfTheInsurance);
        return addictive;
    }

    private double underTwentyFourWithAccident(int engineVolume, Client client,
                                               int yearsOfTheClient, int usage, int durationOfTheInsurance) {

        double addictive = 0;
        double add1 = 0; double add2 = 0; double add3 = 0; double add4 = 0; double add5 = 0; double add6 = 0; double add7 = 0;
        switch (engineVolume){
            case 4:
                add1 = 27.89; add2 = 24.73; add3 = 25.01; add4 = 24.73; add5 = 26.74; add6 = 16.12; add7 = 9.98;
                break;
            case 5:
                add1 = 29.24; add2 = 30.44; add3 = 30.01; add4 = 29.73; add5 = 30.74; add6 = 15.89; add7 = 17.98;
                break;
            case 6:
                add1 = 34.24; add2 = 35.54; add3 = 35.01; add4 = 34.73; add5 = 35.74; add6 = 10.26; add7 = 26.98;
                break;
        }

        if (client.getCarAccidents().equals(Constants.CAR_ACCIDENT_CONFIRMATION)) {
            if (isUserYearsLessThan24(yearsOfTheClient) && isTaxiUsage(usage)) {
                addictive += add1;
            } else if (yearsOfTheClient > 24 && isTaxiUsage(usage)) {
                addictive += add2;
            } else if (isUserYearsLessThan24(yearsOfTheClient) && isRental(usage)) {
                addictive += add3;
            } else if (yearsOfTheClient > 24 && isRental(usage)) {
                addictive += add4;
            } else if (isUserYearsLessThan24(yearsOfTheClient) && (isUsingSpecialUsage(usage))) {
                addictive += add5;
            } else if (yearsOfTheClient > 24 && (isUsingSpecialUsage(usage))) {
                if (durationOfTheInsurance == 1 || isTaxiUsage(durationOfTheInsurance) || durationOfTheInsurance == 3) {
                    addictive += add6;
                }
                addictive += add7;
            }
        }

        return addictive;
    }
    private double atvCalculations(Client client, int vehicleUsage, int userYears, String carAccidents, boolean specialUsage) {
        double addictive = 0;
        addictive += baseCalculation(specialUsage,244.64, 447.42, 186.71, 157.74,
                isTaxiUsage(vehicleUsage), isRental(vehicleUsage));
        addictive += under24YearsUserCalculations(userYears, specialUsage);

        addictive += baseUsageCalculation(vehicleAccidentConfirmation(carAccidents, specialUsage), 36.21);

        if (specialTownATVCalculations(client) && !carAccidents.equalsIgnoreCase(Constants.CAR_ACCIDENT_CONFIRMATION)) {
            addictive +=  rentalAndSpecialUsageCalc(vehicleUsage, specialUsage, 16.32, isRental(vehicleUsage),
                    12.24, 30.6, 10.1);
        } else if (specialTownATVCalculations(client) && carAccidents.equalsIgnoreCase(Constants.CAR_ACCIDENT_CONFIRMATION)) {
            addictive+= rentalAndSpecialUsageCalc(vehicleUsage, specialUsage, 18.87, isRental(vehicleUsage),
                    14.79, 30.6, 12.75);
        }
        return addictive;
    }

    private double overSevenHundredFiftyCcDurationCalc(Client client, int durationOfTheInsurance,
                                                       String municipality, String town, int i, double add, double add2) {
        double addictive = 0;
        if (durationOfTheInsurance == i) {
            if (specialRegionCalculations(client, municipality, town)) {
                addictive -= add;
            }
            addictive += add2;
        }
        return addictive;
    }

    private double baseDurationAndSpecialRegionCalc(Client client,
                                                    int durationOfTheInsurance, String municipality, String town, double v) {
        double addictive = 0;
        if (thirtyDaysInsurance(durationOfTheInsurance)) {
            if (specialRegionCalculations(client, municipality, town)) {
                addictive -= v;
            }
        }
        return addictive;
    }

    private double userUnderTwentyFourBikeCalc(int volume, int yearsOfTheClient,
                                               int usage, int durationOfTheInsurance, boolean...args ) {

        boolean userYearsLessThan24 = args[0]; boolean taxiUsage = args[1]; boolean rental = args[2];
        double add1 = 0; double add2 = 0; double add3= 0; double add4= 0;
        double addictive = 0;
        switch (volume){
            case 4 :
                add1 = 26.23; add2 = 26.34; add3 = 14.36; add4 = 12.2;
                break;
            case 5:
                add1 = 29.41; add2 = 26.34; add3 = 12.34; add4 = 13.2;
                break;
            case 6:
                add1 = 29.41; add2 = 23.34; add3 = 8.3; add4 = 17.2;
                break;

        }

        if (userYearsLessThan24 && taxiUsage) {
            addictive += add1;
        } else if (isUserYearsLessThan24(yearsOfTheClient) && rental) {
            addictive += add2;
        } else if (userYearsLessThan24 && (isUsingSpecialUsage(usage))) {
            if (durationOfTheInsurance == 1 || isTaxiUsage(durationOfTheInsurance) || durationOfTheInsurance == 3) {
                addictive += add3;
            }
            addictive += add4;
        }
        return addictive;
    }
    private double agricultureCalculations(Client client, int vehicleUsage, int userYears,
                                           String carAccidents, boolean specialUsage) {
        double addictive = 0;
        addictive += baseCalculation(specialUsage, 163.04, 294.42, 125.51, 106.74,
                vehicleUsage == Constants.TAXI, vehicleUsage == Constants.RENT);

        addictive += taxiAndSpecialUsageCalc(isUserYearsLessThan24(userYears) && !specialUsage,
                vehicleAccidentConfirmation(carAccidents, specialUsage), 23.46, 25.5);

        if (client.getMunicipality().equalsIgnoreCase(Constants.SOFIA_TOWN)) {
            addictive += baseCalculation(specialUsage, 16.32, 30.60, 12.24, 10.2, isTaxiUsage(vehicleUsage), vehicleUsage == Constants.RENT);
            addictive += baseUsageCalculation(vehicleAccidentConfirmation(carAccidents, specialUsage), 3.41);
        }
        if (specialTownsVarnaPlovdiv(client)) {
            addictive += baseCalculation(specialUsage,  8.16, 15.3, 6.12, 5.1, vehicleUsage == Constants.TAXI, vehicleUsage == Constants.RENT);
        }
        return addictive;
    }

    private double upToFourHundredNinetyCc(int volume, Client client, int yearsOfTheClient, int usage, int durationOfTheInsurance, boolean specialUsage, String municipality, String town) {
        double addictive = 0;

        if (isTaxiUsage(usage)) {
            addictive += isTaxiBikeCalc(client, durationOfTheInsurance, municipality, town);
        } else if (specialUsage) {

            if (specialRegionCalculations(client, municipality, town)) {
                addictive -= 11.11;
            }
            addictive += bikeUsageCalc(durationOfTheInsurance, 29.11, 49.91, 91.52, 233.49);

        } else if (isRental(usage)) {
            addictive += insuranceDurationAndSpecialRegions(client, durationOfTheInsurance, municipality, town,
                    3.14, 29.12, 4.33, 50.1, 6.12, 91.47, 46.28);
        } else {
            addictive += insuranceDurationAndSpecialRegions(client, durationOfTheInsurance, municipality, town,
                    4.33, 14.12, 3.12, 35.1, 5.09, 76.65, 40.28);
        }
        addictive += userUnderTwentyFourBikeCalc(volume,yearsOfTheClient, usage,
                durationOfTheInsurance, isUserYearsLessThan24(yearsOfTheClient), isTaxiUsage(usage), isRental(usage));
        addictive += underTwentyFourWithAccident(volume,client, yearsOfTheClient, usage, durationOfTheInsurance);
        return addictive;
    }

    private double isTaxiBikeCalc(Client client, int durationOfTheInsurance, String municipality, String town) {
        return insuranceDurationAndSpecialRegions(client, durationOfTheInsurance, municipality, town,
                5.26, 30.0, 7.22, 51.75, 8.2, 92.3, 87.1);

    }
    private boolean thirtyDaysInsurance(int durationOfTheInsurance) {
        return durationOfTheInsurance == 0;
    }
    private boolean isUptoFortyOrOver(int busSeats) {
        return busSeats == 1 || busSeats == 2;
    }

    private boolean isUpToTwentySeats(int busSeats) {
        return busSeats == 0;
    }

    private double upToFortySeats(int busSeats, String carAccidents, int userYears, int vehicleUsage, boolean specialUsage) {
        double add = 0; double add2 = 0; double add3 = 0; double add4 = 0; double add5= 0; double add6 = 0;
        double addictive = 0;
        switch (busSeats){
            case 1:
                add = 908.44; add2 = 1698.12; add3 = 682.81; add4 = 570.0; add5 = 141.02; add6 = 6.96;
                break;
            case 2:
                add = 1246.48; add2 = 2334.5; add3 = 936.45; add4 = 780.0; add5 = 194.31; add6 = 10.14;
                break;
        }
        addictive += baseCalculation(specialUsage, add, add2, add3, add4,
                isTaxiUsage(vehicleUsage), isRental(vehicleUsage));
        //......||......
        addictive += under24YearsUsers(userYears, vehicleUsage);

        addictive += baseUsageCalculation(vehicleAccidentConfirmation(carAccidents, specialUsage), add5);
        addictive += add6;
        return addictive;
    }

    private double upToTwentySeats(Client client, String carAccidents, int userYears, int vehicleUsage, boolean specialUsage) {
        double addictive = 0;
        if (isTaxiUsage(vehicleUsage)) {
            addictive += baseUsageCalculation(capitolSpecialPremium(client), 18.89);
            addictive += 600.7;
        } else if (specialUsage) {
            addictive += 1116.94;
        } else if (isRental(vehicleUsage)) {
            addictive += baseUsageCalculation(capitolSpecialPremium(client), 14.68);
            addictive += 452.32;
        } else {
            addictive += baseUsageCalculation(capitolSpecialPremium(client), 12.24);
            addictive += 378.46;
        }
        addictive += under24YearsUsers(userYears, vehicleUsage);

        addictive += taxiAndSpecialUsageCalc(capitolSpecialPremium(client) &&
                        carAccidents.equals(Constants.CAR_ACCIDENT_CONFIRMATION),
                vehicleAccidentConfirmation(carAccidents, specialUsage), 92.31, 3.06);

        addictive += 3.68;
        return addictive;
    }

    private double upToThreeHundredFiftyCalc(Client client, int yearsOfTheClient, int usage, int durationOfTheInsurance, boolean specialUsage) {
        double addictive = 0;
        addictive += baseCalculation(specialUsage, bikeUsageCalc(durationOfTheInsurance,
                26.5, 46.43, 86.2, 85.1), bikeUsageCalc(durationOfTheInsurance, 28.1, 47.65, 87.3, 222.45), bikeUsageCalc(durationOfTheInsurance, 27.72, 47.49, 87.4, 44.28), bikeUsageCalc(durationOfTheInsurance, 12.2, 32.2, 71.6, 40.28), isTaxiUsage(usage), isRental(usage));
        //under 24 years without accident
        if (isUserYearsLessThan24(yearsOfTheClient) && isTaxiUsage(usage)) {
            addictive += 24.23;
        } else if (isUserYearsLessThan24(yearsOfTheClient) && isRental(usage)) {
            addictive += 26.34;
        } else if (isUserYearsLessThan24(yearsOfTheClient) && isUsingSpecialUsage(usage)) {
            if (durationOfTheInsurance == 1 || isTaxiUsage(durationOfTheInsurance) || durationOfTheInsurance == 3) {
                addictive += 15.3;
            }
            addictive += 10.2;
        }
        if (client.getCarAccidents().equals(Constants.CAR_ACCIDENT_CONFIRMATION)) {
            if (isUserYearsLessThan24(yearsOfTheClient) && isTaxiUsage(usage)) {
                addictive += 24.89;
            } else if (yearsOfTheClient > 24 && isTaxiUsage(usage)) {
                addictive += 24.73;
            } else if (isUserYearsLessThan24(yearsOfTheClient) && isRental(usage)) {
                addictive += 25.01;
            } else if (yearsOfTheClient > 24 && isRental(usage)) {
                addictive += 24.73;
            } else if (isUserYearsLessThan24(yearsOfTheClient) && (isUsingSpecialUsage(usage))) {
                if (isTaxiUsage(durationOfTheInsurance)) {
                    addictive += 2.12;
                }
                if (durationOfTheInsurance == 3) {
                    addictive += 15.2;
                }
                addictive += 24.74;
            } else if (yearsOfTheClient > 24 && (isUsingSpecialUsage(usage))) {
                addictive += bikeUsageCalc(durationOfTheInsurance, 15.1, 16.46, 14.7, 9.98);
            }
        }
        return addictive;
    }
    private double cargoCalculations(int vehicleUsage, int userYears, String carAccidents, boolean specialUsage) {
        double addictive = 0;
        addictive +=baseCalculation(specialUsage,166.31, 300.54, 127.96, 108.78,
                vehicleUsage == Constants.TAXI, vehicleUsage == Constants.RENT);

        addictive += under24YearsUserCalculations(userYears, specialUsage);
        if (carAccidents.equalsIgnoreCase(Constants.CAR_ACCIDENT_CONFIRMATION) && !specialUsage) {

            addictive += 23.97;
        }
        return addictive;
    }
    private double rentalAndSpecialUsageCalc(int vehicleUsage, boolean specialUsage,
                                             double v, boolean rental, double... args) {
        double addictive = 0;
        double v2 = args[0]; double v3 = args[1]; double v4 = args[2];
        if (isTaxiUsage(vehicleUsage)) {
            addictive -= v;
        } else if (rental) {
            addictive -= v2;
        } else if (specialUsage) {
            addictive -= v3;
        } else {
            addictive -= v4;
        }
        return addictive;
    }

    private boolean isUpToThreeHundredFiftyCc(int engineVolume) {
        return engineVolume == 0 || engineVolume == 1 || isTaxiUsage(engineVolume) || engineVolume == 3;
    }

    private boolean isUsingSpecialUsage(int usage) {
        return usage == 0 || usage == 1 || usage == 4 || usage == 9
                || usage == 10 || usage == 11 || usage == 12 || usage == 13;
    }

    private double bikeUsageCalc(int durationOfTheInsurance, double... args) {
        double v = args[0]; double v2 = args[1]; double v3 = args[2]; double v4 = args[3];
        double addictive = 0;
        if (durationOfTheInsurance == 1) {
            addictive += v;
        }
        if (isTaxiUsage(durationOfTheInsurance)) {
            addictive += v2;
        }
        if (durationOfTheInsurance == 3) {
            addictive += v3;
        }
        addictive += v4;
        return addictive;
    }
    private double carCalculations(Client client, int carYear, int usage, String carAccidents, boolean specialUsage) {
        double addictive = 0;
        if (isForPersonalUsage(usage)) {
            if (carYear > 2003) {
                addictive += 4.86;
            }
            addictive += carSpecialMunicCalc(client, carAccidents, 11.87, 14.89, 4.1, 57.8, 253.1);//57.8, 253.1
        } else if (isTaxiUsage(usage)) {
            addictive += carSpecialMunicCalc(client, carAccidents, 22.01, 27.62, 7.34, 70.83, 432.45);
        } else if (specialUsage) {
            if (client.getMunicipality().equalsIgnoreCase(Constants.SOFIA_TOWN)) {
                addictive += 41.28;
            }
            if (specialTownsBurgasSofiaStaraZagora(client)) {
                addictive -= 51.78;
            }
            if (specialTownsVarnaPlovdiv(client)) {
                addictive += 13.77;
            }
            addictive += 802.93;
        } else if (isRental(usage)) {
            addictive += carSpecialMunicCalc(client, carAccidents, 16.26, 21.1, 5.26, 65.59, 329,12);
        } else {
            addictive += carSpecialMunicCalc(client, carAccidents, 13.76, 17.26, 4.59, 65.84, 276.35);//
        }
        if (client.getMunicipality().equalsIgnoreCase(Constants.SOFIA_TOWN)
                && carAccidents.equalsIgnoreCase(Constants.CAR_ACCIDENT_CONFIRMATION)
                && !specialUsage) {
            addictive += 3.5;
        }

        if (specialTownsBurgasSofiaStaraZagora(client) && !specialUsage && carAccidents.equals(Constants.CAR_ACCIDENT_CONFIRMATION)) {
            addictive -= 4.02;
        }
        if (isUserYearsLessThan24(client.getYearsOfTheClient()) && !specialUsage) {
            addictive += 79.56;
        }
        return addictive;
    }
    private double insuranceDurationAndSpecialRegions(Client client, int durationOfTheInsurance,
                                                      String municipality, String town, double...args ) {
        double v = args[0]; double v2 = args[1]; double v3 = args[2]; double v4 = args[3]; double v5 = args[4];
        double v6 = args[5]; double v7 = args[6];
        double addictive = 0;

        if (durationOfTheInsurance == 1) {
            if (specialRegionCalculations(client, municipality, town)) {
                addictive -= v;
            }
            addictive += v2;
        }
        if (isTaxiUsage(durationOfTheInsurance)) {
            if (specialRegionCalculations(client, municipality, town)) {
                addictive -= v3;
            }
            addictive += v4;
        }
        if (durationOfTheInsurance == 3) {
            if (specialRegionCalculations(client, municipality, town)) {
                addictive -= v5;
            }
            addictive += v6;
        }
        addictive += v7;
        return addictive;
    }
    private double upToOneHundredEightyAndOneYear(int termsOfInsurance,
                                                  String carAccidents, int userYears, int vehicleUsage, boolean specialUsage) {
        double addictive = 0;
        double add = 0; double add2 = 0; double add3 = 0; double add4 = 0;
        switch (termsOfInsurance){
            case 2:
                add = 76.55; add2 = 150.8; add3 = 55.33; add4 = 44.72;
                break;
            case 3:
                add = 97.76; add2 = 172.02; add3 = 76.55; add4 = 65.94;
                break;
        }
        if (isTaxiUsage(vehicleUsage)) {
            addictive += taxiAndSpecialUsageCalc(carAccidents.equals(Constants.CAR_ACCIDENT_CONFIRMATION), isUserYearsLessThan24(userYears), 25.5, 13.26);
            addictive += add;
        } else if (specialUsage) {
            addictive += add2;
        } else if (isRental(vehicleUsage)) {
            addictive += taxiAndSpecialUsageCalc(carAccidents.equals(Constants.CAR_ACCIDENT_CONFIRMATION), isUserYearsLessThan24(userYears), 25.5, 13.26);
            addictive += add3;
        } else {
            addictive += taxiAndSpecialUsageCalc(carAccidents.equals(Constants.CAR_ACCIDENT_CONFIRMATION), isUserYearsLessThan24(userYears), 26.12, 13.26);
            addictive += add4;
        }
        return addictive;
    }

    private double upToNinetyDays(String carAccidents, int userYears, int vehicleUsage, boolean specialUsage) {
        double addictive = 0;
        if (isTaxiUsage(vehicleUsage)) {
            addictive += taxiAndSpecialUsageCalc(carAccidents.equals(Constants.CAR_ACCIDENT_CONFIRMATION),
                    isUserYearsLessThan24(userYears), 25.5, 13.26);
            addictive += 65.94;
        } else if (specialUsage) {
            addictive += 140.2;
        } else if (isRental(vehicleUsage)) {
            addictive += taxiAndSpecialUsageCalc(carAccidents.equals(Constants.CAR_ACCIDENT_CONFIRMATION),
                    isUserYearsLessThan24(userYears), 25.5, 13.26);
            premium += 44.72;
        } else {
            addictive += taxiAndSpecialUsageCalc(carAccidents.equals(Constants.CAR_ACCIDENT_CONFIRMATION)
                    && isUserYearsLessThan24(userYears), isUserYearsLessThan24(userYears), 16.12, 9.38);
            addictive += baseUsageCalculation(carAccidents.equals(Constants.CAR_ACCIDENT_CONFIRMATION), 3.88);
            addictive += 43.5;
        }
        return addictive;
    }

    private double upToThirtyDays(String carAccidents, int userYears, int vehicleUsage, boolean specialUsage) {
        double addictive = 0;
        if (isTaxiUsage(vehicleUsage)) {
            addictive +=  taxiAndSpecialUsageCalc(carAccidents.equals(Constants.CAR_ACCIDENT_CONFIRMATION),
                    isUserYearsLessThan24(userYears), 25.5, 13.26);
            addictive += 52.68;
        } else if (specialUsage) {
            addictive += 126.94;
        } else if (isRental(vehicleUsage)) {
            addictive += taxiAndSpecialUsageCalc(carAccidents.equals(Constants.CAR_ACCIDENT_CONFIRMATION),
                    isUserYearsLessThan24(userYears), 13.46, 1.4);
            if (carAccidents.equals(Constants.CAR_ACCIDENT_CONFIRMATION) && isUserYearsLessThan24(userYears)) {
                addictive += 11.86;
            }
            addictive += 43.5;
        } else {
            addictive += taxiAndSpecialUsageCalc(carAccidents.equals(Constants.CAR_ACCIDENT_CONFIRMATION)
                    && isUserYearsLessThan24(userYears), isUserYearsLessThan24(userYears), 2.86, 13.26);
            addictive += 43.5;
        }
        return addictive;
    }

    private static boolean isUserYearsLessThan24(int userYears) {
        return userYears <= 24;
    }
    private double luggageTrailersCalc(Client client, int vehicleUsage, int userYears, String carAccidents, boolean specialUsage) {
        double addictive = 0;
        addictive += baseCalculation(specialUsage, 130.4, 233.22, 101.03, 86.34,
                isTaxiUsage(vehicleUsage), isRental(vehicleUsage));

        addictive += under24YearsUserCalculations(userYears, specialUsage);

        addictive += baseUsageCalculation(vehicleAccidentConfirmation(carAccidents, specialUsage), 18.4);

        if (client.getRegion().equalsIgnoreCase(Constants.SOFIA_CAPITAL)
                && !carAccidents.equalsIgnoreCase(Constants.CAR_ACCIDENT_CONFIRMATION)) {
            addictive += baseCalculation(isRental(vehicleUsage), 8.13, 6.12, 15.30, 5.1,
                    isTaxiUsage(vehicleUsage), specialUsage);

        } else if (client.getRegion().equalsIgnoreCase(Constants.SOFIA_CAPITAL)
                && carAccidents.equalsIgnoreCase(Constants.CAR_ACCIDENT_CONFIRMATION)) {
            addictive+= baseCalculation(specialUsage, 9.4, 15.30, 7.35, 6.34,
                    isTaxiUsage(vehicleUsage), isRental(vehicleUsage));
        }
        return addictive;
    }
    private double saddleTractorsCalc(int vehicleUsage, int userYears, String carAccidents, boolean specialUsage) {
        double addictive = 0;
        addictive += baseCalculation(specialUsage,5417.69, 10146.89, 4066.49, 3390.90,
                isTaxiUsage(vehicleUsage), isRental(vehicleUsage));

        addictive+= taxiAndSpecialUsageCalc(vehicleAccidentConfirmation(carAccidents, specialUsage),
                isUserYearsLessThan24(userYears) && !specialUsage, 40.8, 844.49);
        return addictive;
    }
    private double trolleybusCalc(Client client, int vehicleUsage, int userYears, String carAccidents, boolean specialUsage) {
        double addictive = 0;
        addictive += baseCalculation(specialUsage,603.68, 1120.62, 455.99, 382.14,
                isTaxiUsage(vehicleUsage), isRental(vehicleUsage));
        addictive += taxiAndSpecialUsageCalc(isUserYearsLessThan24(userYears) && !specialUsage,
                vehicleAccidentConfirmation(carAccidents, specialUsage), 92.31, 51.0);

        if (client.getMunicipality().equalsIgnoreCase(Constants.SOFIA_TOWN)) {
            if (isTaxiUsage(vehicleUsage)) {
                addictive += taxiAndSpecialUsageCalc(isUserYearsLessThan24(userYears),
                        carAccidents.equals(Constants.CAR_ACCIDENT_CONFIRMATION), 39.77, 27.02);
                addictive += 54.58;
            } else if (specialUsage) {
                addictive += 153.0;
            } else if (isRental(vehicleUsage)) {
                addictive += baseUsageCalculation(carAccidents.equals(Constants.CAR_ACCIDENT_CONFIRMATION), 12.75);
                addictive += 61.2;
            } else {
                addictive += baseUsageCalculation(carAccidents.equals(Constants.CAR_ACCIDENT_CONFIRMATION), 12.75);
                addictive += 51.0;
            }
        }
        if (specialTownsVarnaPlovdiv(client)) {
            addictive += baseCalculation(specialUsage, 16.32, 30.6, 12.24, 10.0,
                    isTaxiUsage(vehicleUsage), isRental(vehicleUsage));
            addictive += baseUsageCalculation(vehicleAccidentConfirmation(carAccidents, specialUsage), 3.1);
        }
        return addictive;
    }
}
