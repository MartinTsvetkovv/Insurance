package carInsurance;

import carInsurance.models.*;
import insuranceFx.Constants;

public class PremiumCalculations {



    private static double premium;


    private PremiumCalculations() {
        premium = 0.0;
    }

    public static double truckPremiumCalculations(Truck truck, Client client) {
        int usage = truck.getUsageOfTheVehicle();
        int load = truck.getLoadability();
        int useYears = client.getYearsOfTheClient();
        String carAccidents = client.getCarAccidents();
        boolean specialUsage = (usage == 3 || usage == 6 || usage == 7 || usage == 8);
        if (load == Constants.UP_TO_TON_AND_A_HALF) {
            premium = (1500 * 0.05) + 76;
        } else if (load == Constants.UP_T0_THREE_TONS) {
            premium = (1500 * 0.05) + 116.6;
        } else if (load == Constants.UP_TO_FIVE_TONS) {
            premium = (3000 * 0.05) + 96.23;
        } else if (load == Constants.UP_TO_TEN_TONS) {
            premium = (3500 * 0.05) + 625.43;
        } else if (load == Constants.UP_TO_TWENTY_TONNES) {
            premium = (5000 * 0.20) + 120.4;
        } else {
            premium = (5000 * 0.20) + 305.34;
        }

        if (load == 1 && useYears <= 24 && !carAccidents.equals(Constants.CAR_ACCIDENT_CONFIRMATION) && usage == 5) {
            premium -= 27.3;
        }
        if (load == 1 && specialUsage && !carAccidents.equals(Constants.CAR_ACCIDENT_CONFIRMATION)) {
            premium += 50.5;
        }

        switch (load) {
            case 2:
                if (specialUsage) {
                    premium += 150.23;
                }
                if (usage == Constants.RENT && client.getCarAccidents().equals(Constants.CAR_ACCIDENT_CONFIRMATION) && client.getYearsOfTheClient() > 24) {
                    premium += 19.98;
                }
                break;
            case 3:
                if (usage == Constants.RENT) {
                    premium += 111.25;
                }
                if (usage == Constants.TAXI) {

                    premium += 352;
                }
                if (specialUsage) {
                    premium += 1250.23;
                }
                break;
            case 4:
                if (usage == Constants.TAXI) {
                    premium += 571;
                }
                if (usage == Constants.RENT) {
                    premium += 190.26;
                }
                if (specialUsage) {
                    premium += 1925.81;
                }
                break;
            case 5:
                if (usage == Constants.TAXI) {
                    premium += 657.31;
                }
                if (usage == Constants.RENT) {
                    premium += 190.26;
                }
                if (specialUsage) {
                    premium += 2246.76;
                }
                break;
        }

        premium = getCalculateClientYears(client, truck, premium);
        premium = getAddressCalculations(client, premium);
        premium = getVehicleUsageCalculations(truck, premium);
        premium = getCarAccidentCalc(client, premium);
        return premium;
    }

    public static double campingTrailers(Car car, Client client) {
        premium = 0;
        int termOfTheInsurance = car.getEngineVolume();
        String carAccidents = client.getCarAccidents();
        int userYears = client.getYearsOfTheClient();
        int vehicleUsage = car.getUsageOfTheVehicle();
        boolean specialUsage = (vehicleUsage == 3 || vehicleUsage == 6 || vehicleUsage == 7 || vehicleUsage == 8);

        switch (termOfTheInsurance) {
            case 0:
                if (vehicleUsage == 2) {
                    if (userYears <= 24) {
                        premium += 25.5;
                    }
                    if (carAccidents.equals(Constants.CAR_ACCIDENT_CONFIRMATION)){
                        premium += 13.26;
                    }
                    premium += 52.68;
                } else if (specialUsage) {
                    premium += 126.94;
                } else if (vehicleUsage == 5) {
                    if (userYears <= 24){
                        premium += 13.46;
                    }
                    if (carAccidents.equals(Constants.CAR_ACCIDENT_CONFIRMATION)){
                        premium += 1.4;
                    }
                    if (carAccidents.equals(Constants.CAR_ACCIDENT_CONFIRMATION) && userYears <= 24){
                        premium += 11.86;
                    }
                    premium += 43.5;
                } else {
                    if (userYears <= 24) {
                        premium += 2.86;
                    }
                    if (carAccidents.equals(Constants.CAR_ACCIDENT_CONFIRMATION) && userYears <= 24){
                        premium += 13.26;
                    }
                    premium += 43.5;
                }
                break;
            case 1:
                if (vehicleUsage == 2) {
                    if (userYears <= 24) {
                        premium += 25.5;
                    }
                    if (carAccidents.equals(Constants.CAR_ACCIDENT_CONFIRMATION)){
                       premium += 13.26;
                    }
                    premium += 65.94;
                } else if (specialUsage) {
                    premium += 140.2;
                } else if (vehicleUsage == 5) {
                    if (userYears <= 24){
                        premium += 25.5;
                    }
                    if (carAccidents.equals(Constants.CAR_ACCIDENT_CONFIRMATION)){
                        premium += 13.26;
                    }
                    premium += 44.72;
                } else {
                    if (userYears <= 24) {
                        premium += 16.12;
                    }
                    if (carAccidents.equals(Constants.CAR_ACCIDENT_CONFIRMATION) && userYears <= 24){
                        premium += 9.38;
                    }
                    if (carAccidents.equals(Constants.CAR_ACCIDENT_CONFIRMATION)){
                        premium += 3.88;
                    }
                    premium += 43.5;
                }
                break;
            case 2:
                if (vehicleUsage == 2) {
                    if (userYears <= 24) {
                        premium += 25.5;
                    }
                    if (carAccidents.equals(Constants.CAR_ACCIDENT_CONFIRMATION)){
                        premium += 13.26;
                    }
                    premium += 76.55;
                } else if (specialUsage) {
                    premium += 150.8;
                } else if (vehicleUsage == 5) {
                    if (userYears <= 24){
                        premium += 25.5;
                    }
                    if (carAccidents.equals(Constants.CAR_ACCIDENT_CONFIRMATION)){
                        premium += 13.26;
                    }
                    premium += 55.33;
                } else {
                    if (userYears <= 24) {
                        premium += 26.12;
                    }
                    if (carAccidents.equals(Constants.CAR_ACCIDENT_CONFIRMATION)){
                        premium += 13.26;
                    }
                    premium += 44.72;
                }
                break;
            case 3:
                if (vehicleUsage == 2) {
                    if (userYears <= 24) {
                        premium += 25.5;
                    }
                    if (carAccidents.equals(Constants.CAR_ACCIDENT_CONFIRMATION)){
                        premium += 13.26;
                    }
                    premium += 97.76;
                } else if (specialUsage) {
                    premium += 172.02;
                } else if (vehicleUsage == 5) {
                    if (userYears <= 24){
                        premium += 25.5;
                    }
                    if (carAccidents.equals(Constants.CAR_ACCIDENT_CONFIRMATION)){
                        premium += 13.26;
                    }
                    premium += 76.55;
                } else {
                    if (userYears <= 24) {
                        premium += 26.12;
                    }
                    if (carAccidents.equals(Constants.CAR_ACCIDENT_CONFIRMATION)){
                        premium += 13.26;
                    }
                    premium += 65.94;
                }
                break;
        }
        return premium;
    }

    public static double luggageTrailers(Car car, Client client) {
        premium = 0;
        int vehicleUsage = car.getUsageOfTheVehicle();
        int userYears = client.getYearsOfTheClient();
        String carAccidents = client.getCarAccidents();
        boolean specialUsage = (vehicleUsage == 3 || vehicleUsage == 6 || vehicleUsage == 7 || vehicleUsage == 8);
        if (vehicleUsage == 2) {
            premium += 130.4;
        } else if (specialUsage) {
            premium += 233.22;
        } else if (vehicleUsage == 5) {
            premium += 101.03;
        } else {
            premium += 86.34;
        }

        under24YearsUserCalculations(userYears, specialUsage);

        if (carAccidents.equals(Constants.CAR_ACCIDENT_CONFIRMATION) && !specialUsage) {
            premium += 18.4;
        }

        if (client.getRegion().equalsIgnoreCase(Constants.SOFIA_CAPITAL) && !carAccidents.equalsIgnoreCase(Constants.CAR_ACCIDENT_CONFIRMATION)) {
            if (vehicleUsage == 2) {
                premium += 8.13;
            } else if (vehicleUsage == 5) {
                premium += 6.12;
            } else if (specialUsage) {
                premium += 15.30;
            } else {
                premium += 5.1;
            }

        } else if (client.getRegion().equalsIgnoreCase(Constants.SOFIA_CAPITAL) && carAccidents.equalsIgnoreCase(Constants.CAR_ACCIDENT_CONFIRMATION)) {
            if (vehicleUsage == 2) {
                premium += 9.4;
            } else if (specialUsage) {
                premium += 15.30;
            } else if (vehicleUsage == 5) {
                premium += 7.35;
            } else {
                premium += 6.34;
            }
        }

        return premium;
    }

    public static double trolleyBusesCalculations(Car car, Client client){
        premium = 0;
        int vehicleUsage = car.getUsageOfTheVehicle();
        int userYears = client.getYearsOfTheClient();
        String carAccidents = client.getCarAccidents();
        boolean specialUsage = (vehicleUsage == 3 || vehicleUsage == 6 || vehicleUsage == 7 || vehicleUsage == 8);

        if (vehicleUsage == 2) {
            premium += 603.68;
        } else if (specialUsage) {
             premium += 1120.62;
        } else if (vehicleUsage == 5) {
            premium += 455.99;
        } else {
            premium += 382.14;
        }
        if (carAccidents.equals(Constants.CAR_ACCIDENT_CONFIRMATION) && !specialUsage){
            premium += 92.31;
        }
        if (userYears <= 24 && !specialUsage){
            premium += 51.0;
        }

        if (client.getMunicipality().equalsIgnoreCase(Constants.SOFIA_TOWN)){
            if (vehicleUsage == 2) {
                if (carAccidents.equals(Constants.CAR_ACCIDENT_CONFIRMATION)){
                    premium += 39.77;
                }
                if (userYears <= 24){
                    premium += 27.02;
                }
                premium += 54.58;
            } else if (specialUsage) {
                premium += 153.0;
            } else if (vehicleUsage == 5) {
                if (carAccidents.equals(Constants.CAR_ACCIDENT_CONFIRMATION)){
                    premium += 12.75;
                }
                premium += 61.2;
            } else {
                if (carAccidents.equals(Constants.CAR_ACCIDENT_CONFIRMATION)){
                    premium += 12.75;
                }
                premium += 51.0;
            }
        }
        if (client.getMunicipality().equalsIgnoreCase(Constants.PLOVDIV_TOWN) || client.getTown().equalsIgnoreCase(Constants.VARNA_TOWN)){
            if (vehicleUsage == 2) {
                premium += 16.32;
            } else if (specialUsage) {
                premium += 30.6;
            } else if (vehicleUsage == 5) {

                premium += 12.24;
            } else {
                premium += 10.0;
            }
            if (carAccidents.equals(Constants.CAR_ACCIDENT_CONFIRMATION) && !specialUsage){
                premium += 3.1;
            }
        }
        return premium;
    }
    public static double constructionMachinery(Car car, Client client){
        premium = 0;
        int vehicleUsage = car.getUsageOfTheVehicle();
        int userYears = client.getYearsOfTheClient();
        boolean specialUsage = (vehicleUsage == 3 || vehicleUsage == 6 || vehicleUsage == 7 || vehicleUsage == 8);
        if (vehicleUsage == 2) {
            premium += 197.32;
        } else if (specialUsage) {
            premium += 358.68;
        } else if (vehicleUsage == 5) {
            premium += 151.21;
        } else {
            premium += 128.16;
        }

        if (client.getCarAccidents().equals(Constants.CAR_ACCIDENT_CONFIRMATION) && !specialUsage){
            premium += 28.82;
        }

        if (userYears <= 24 && !specialUsage){
            premium += 25.5;
        }
        return premium;
    }

    public static double agriculturalMachineryCalculations(Car car, Client client){
        premium = 0;
        int vehicleUsage = car.getUsageOfTheVehicle();
        int userYears = client.getYearsOfTheClient();
        String carAccidents = client.getCarAccidents();
        boolean specialUsage = (vehicleUsage == 3 || vehicleUsage == 6 || vehicleUsage == 7 || vehicleUsage == 8);
        if (vehicleUsage == 2) {
            premium += 163.04;
        } else if (specialUsage) {
            premium += 294.42;
        } else if (vehicleUsage == 5) {
            premium += 125.51;
        } else {
            premium += 106.74;
        }

        if (carAccidents.equals(Constants.CAR_ACCIDENT_CONFIRMATION) && !specialUsage){
            premium += 23.46;
        }
        if (userYears <= 24 && !specialUsage){
            premium += 25.5;
        }

        if (client.getMunicipality().equalsIgnoreCase(Constants.SOFIA_TOWN)){
            if (vehicleUsage == 2) {
                    premium += 16.32;
            } else if (specialUsage) {
                premium += 30.60;
            } else if (vehicleUsage == 5) {
                premium += 12.24;
            } else {
                premium += 10.2;
            }
            if (carAccidents.equals(Constants.CAR_ACCIDENT_CONFIRMATION) && !specialUsage){
                premium += 3.41;
            }
        }
        if (client.getMunicipality().equalsIgnoreCase(Constants.PLOVDIV_TOWN) || client.getTown().equalsIgnoreCase(Constants.VARNA_TOWN)){
            if (vehicleUsage == 2) {
                premium += 8.16;
            } else if (specialUsage) {
                premium += 15.3;
            } else if (vehicleUsage == 5) {
               premium += 6.12;
            } else {
                premium += 5.1;
            }
        }
        return premium;
    }

    public static double cargoTrailer(Car car, Client client) {
        premium = 0;
        int vehicleUsage = car.getUsageOfTheVehicle();
        int userYears = client.getYearsOfTheClient();
        String carAccidents = client.getCarAccidents();
        boolean specialUsage = (vehicleUsage == 3 || vehicleUsage == 6 || vehicleUsage == 7 || vehicleUsage == 8);

        if (vehicleUsage == 2) {
            premium += 166.31;
        } else if (specialUsage) {
            premium += 300.54;
        } else if (vehicleUsage == 5) {
            premium += 127.96;
        } else {
            premium += 108.78;
        }

        under24YearsUserCalculations(userYears, specialUsage);
        if (carAccidents.equalsIgnoreCase(Constants.CAR_ACCIDENT_CONFIRMATION) && !specialUsage) {

            premium += 23.97;
        }

        return premium;
    }

    public static double saddleTractors(Car car, Client client) {
        premium = 0;
        int vehicleUsage = car.getUsageOfTheVehicle();
        int userYears = client.getYearsOfTheClient();
        String carAccidents = client.getCarAccidents();
        boolean specialUsage = (vehicleUsage == 3 || vehicleUsage == 6 || vehicleUsage == 7 || vehicleUsage == 8);
        if (vehicleUsage == 2) {
            premium += 5417.69;
        } else if (specialUsage) {
            premium += 10146.89;
        } else if (vehicleUsage == 5) {
            premium += 4066.49;
        } else {
            premium += 3390.90;
        }

        if (userYears <= 24 && !specialUsage) {
            premium += 40.8;
        }

        if (carAccidents.equals(Constants.CAR_ACCIDENT_CONFIRMATION) && !specialUsage) {
            premium += 844.49;
        }

        return premium;
    }

    public static double calculationsATV(Car car, Client client) {
        premium = 0;
        int vehicleUsage = car.getUsageOfTheVehicle();
        int userYears = client.getYearsOfTheClient();
        String carAccidents = client.getCarAccidents();
        boolean specialUsage = (vehicleUsage == 3 || vehicleUsage == 6 || vehicleUsage == 7 || vehicleUsage == 8);

        if (vehicleUsage == 2) {
            premium += 244.64;
        } else if (specialUsage) {
            premium += 447.42;
        } else if (vehicleUsage == 5) {
            premium += 186.71;
        } else {
            premium += 157.74;
        }
        under24YearsUserCalculations(userYears, specialUsage);

        if (carAccidents.equals(Constants.CAR_ACCIDENT_CONFIRMATION) && !specialUsage) {
            premium += 36.21;
        }

        if (specialTownATVCalculations(client) && !carAccidents.equalsIgnoreCase(Constants.CAR_ACCIDENT_CONFIRMATION)) {
            if (vehicleUsage == 2) {
                premium -= 16.32;
            } else if (vehicleUsage == 5) {
                premium -= 12.24;
            } else if (specialUsage) {
                premium -= 30.6;
            } else {
                premium -= 10.1;
            }

        } else if (specialTownATVCalculations(client) && carAccidents.equalsIgnoreCase(Constants.CAR_ACCIDENT_CONFIRMATION)) {
            if (vehicleUsage == 2) {
                premium -= 18.87;
            } else if (vehicleUsage == 5) {
                premium -= 14.79;
            } else if (specialUsage) {
                premium -= 30.6;
            } else {
                premium -= 12.75;
            }

        }

        return premium;
    }

    public static double busCalculations(Car car, Client client) {
        premium = 0;
        int busSeats = car.getEngineVolume();
        String carAccidents = client.getCarAccidents();
        int userYears = client.getYearsOfTheClient();
        int vehicleUsage = car.getUsageOfTheVehicle();
        boolean specialUsage = (vehicleUsage == 3 || vehicleUsage == 6 || vehicleUsage == 7 || vehicleUsage == 8);

        switch (busSeats) {
            case 0:
                if (vehicleUsage == 2) {
                    if (capitolSpecialPremium(client)) {
                        premium += 18.89;
                    }
                    premium += 600.7;
                } else if (specialUsage) {
                    premium += 1116.94;
                } else if (vehicleUsage == 5) {
                    if (capitolSpecialPremium(client)) {
                        premium += 14.68;
                    }
                    premium += 452.32;
                } else {
                    if (capitolSpecialPremium(client)) {
                        premium += 12.24;
                    }
                    premium += 378.46;
                }

                //under 24 years without accident
                under24YearsUsers(userYears, vehicleUsage);

                if (carAccidents.equals(Constants.CAR_ACCIDENT_CONFIRMATION) && !specialUsage) {
                    premium += 92.31;
                }

                if (capitolSpecialPremium(client) && carAccidents.equals(Constants.CAR_ACCIDENT_CONFIRMATION)) {
                    premium += 3.06;
                }

                premium += 3.68;
                break;
            case 1:
                if (vehicleUsage == 2) {
                    premium += 908.44;
                } else if (specialUsage) {
                    premium += 1698.12;
                } else if (vehicleUsage == 5) {
                    premium += 682.81;
                } else {
                    premium += 570.0;
                }
                //......||......
                under24YearsUsers(userYears, vehicleUsage);

                if (carAccidents.equals(Constants.CAR_ACCIDENT_CONFIRMATION) && !specialUsage) {
                    premium += 141.02;
                }
                premium += 6.96;
                break;

            case 2:
                if (vehicleUsage == 2) {
                    premium += 1246.48;
                } else if (specialUsage) {
                    premium += 2334.5;
                } else if (vehicleUsage == 5) {
                    premium += 936.45;
                } else {
                    premium += 780.0;
                }

                under24YearsUsers(userYears, vehicleUsage);

                if (carAccidents.equals(Constants.CAR_ACCIDENT_CONFIRMATION) && !specialUsage) {
                    premium += 194.31;
                }

                premium += 10.14;
                break;
        }


        return premium;
    }


    public static double bikeCalculations(Motorcycle motorcycle, Client client) {
        premium = 0;
        int engineVolume = motorcycle.getEngineVolume();
        int yearsOfTheClient = client.getYearsOfTheClient();
        int usage = motorcycle.getUsageOfTheVehicle();
        int durationOfTheInsurance = motorcycle.getDurationOfTheInsurance();
        boolean specialUsage = (usage == 3 || usage == 6 || usage == 7 || usage == 8);
        String municipality = client.getMunicipality();
        String town = client.getTown();
        switch (durationOfTheInsurance) {
            case 0:
                premium += 3.24;
                break;
        }
        if (engineVolume == 0 || engineVolume == 1 || engineVolume == 2 || engineVolume == 3) {
            if (usage == 2) {
                if (durationOfTheInsurance == 1) {
                    premium += 26.5;
                }
                if (durationOfTheInsurance == 2) {
                    premium += 46.43;
                }
                if (durationOfTheInsurance == 3) {
                    premium += 86.2;
                }
                premium += 85.1;
            } else if (specialUsage) {
                if (durationOfTheInsurance == 1) {
                    premium += 28.1;
                }
                if (durationOfTheInsurance == 2) {
                    premium += 47.65;
                }
                if (durationOfTheInsurance == 3) {
                    premium += 87.3;
                }
                premium += 222.45;
            } else if (usage == 5) {
                if (durationOfTheInsurance == 1) {
                    premium += 27.72;
                }
                if (durationOfTheInsurance == 2) {
                    premium += 47.49;
                }
                if (durationOfTheInsurance == 3) {
                    premium += 87.4;
                }
                premium += 44.28;
            } else {
                if (durationOfTheInsurance == 1) {
                    premium += 12.2;
                }
                if (durationOfTheInsurance == 2) {
                    premium += 32.2;
                }
                if (durationOfTheInsurance == 3) {
                    premium += 71.6;
                }
                premium += 40.28;
            }
            //under 24 years without accident
            if (yearsOfTheClient <= 24 && usage == 2) {
                premium += 24.23;
            } else if (yearsOfTheClient <= 24 && usage == 5) {
                premium += 26.34;
            } else if (yearsOfTheClient <= 24 && (usage == 0 || usage == 1 || usage == 4 || usage == 9
                    || usage == 10 || usage == 11 || usage == 12 || usage == 13)) {
                if (durationOfTheInsurance == 1) {
                    premium += 15.1;
                }
                if (durationOfTheInsurance == 2) {
                    premium += 15.1;
                }
                if (durationOfTheInsurance == 3) {
                    premium += 15.3;
                }
                premium += 10.2;
            }
            switch (client.getCarAccidents()) {
                case Constants.CAR_ACCIDENT_CONFIRMATION:
                    if (yearsOfTheClient <= 24 && usage == 2) {
                        premium += 24.89;
                    } else if (yearsOfTheClient > 24 && usage == 2) {
                        premium += 24.73;
                    } else if (yearsOfTheClient <= 24 && usage == 5) {
                        premium += 25.01;
                    } else if (yearsOfTheClient > 24 && usage == 5) {
                        premium += 24.73;
                    } else if (yearsOfTheClient <= 24 && (usage == 0 || usage == 1 || usage == 4 || usage == 9
                            || usage == 10 || usage == 11 || usage == 12 || usage == 13)) {
                        if (durationOfTheInsurance == 2) {
                            premium += 2.12;
                        }
                        if (durationOfTheInsurance == 3) {
                            premium += 15.2;
                        }
                        premium += 24.74;
                    } else if (yearsOfTheClient > 24 && (usage == 0 || usage == 1 || usage == 4 || usage == 9
                            || usage == 10 || usage == 11 || usage == 12 || usage == 13)) {
                        if (durationOfTheInsurance == 1) {
                            premium += 15.1;
                        }
                        if (durationOfTheInsurance == 2) {
                            premium += 16.46;
                        }
                        if (durationOfTheInsurance == 3) {
                            premium += 14.7;
                        }
                        premium += 9.98;
                    }
                    break;
            }
        }
        switch (engineVolume) {
            case 4:
                if (usage == 2) {
                    if (durationOfTheInsurance == 1) {
                        if (specialRegionCalculations(client, municipality, town)) {
                            premium -= 5.26;
                        }
                        premium += 30;
                    }
                    if (durationOfTheInsurance == 2) {
                        if (specialRegionCalculations(client, municipality, town)) {
                            premium -= 7.22;
                        }
                        premium += 51.75;
                    }
                    if (durationOfTheInsurance == 3) {
                        if (specialRegionCalculations(client, municipality, town)) {
                            premium -= 8.2;
                        }
                        premium += 92.3;
                    }
                    premium += 87.1;
                } else if (specialUsage) {
                    if (specialRegionCalculations(client, municipality, town)) {
                        premium -= 11.11;
                    }
                    if (durationOfTheInsurance == 1) {
                        premium += 29.11;
                    }
                    if (durationOfTheInsurance == 2) {
                        premium += 49.91;
                    }
                    if (durationOfTheInsurance == 3) {
                        premium += 91.52;
                    }
                    premium += 233.49;
                } else if (usage == 5) {
                    if (durationOfTheInsurance == 1) {
                        if (specialRegionCalculations(client, municipality, town)) {
                            premium -= 3.14;
                        }
                        premium += 29.12;
                    }
                    if (durationOfTheInsurance == 2) {
                        if (specialRegionCalculations(client, municipality, town)) {
                            premium -= 4.33;
                        }
                        premium += 50.1;
                    }
                    if (durationOfTheInsurance == 3) {
                        if (specialRegionCalculations(client, municipality, town)) {
                            premium -= 6.12;
                        }
                        premium += 91.47;
                    }
                    premium += 46.28;
                } else {
                    if (durationOfTheInsurance == 1) {
                        if (specialRegionCalculations(client, municipality, town)) {
                            premium -= 4.33;
                        }
                        premium += 14.12;
                    }
                    if (durationOfTheInsurance == 2) {
                        if (specialRegionCalculations(client, municipality, town)) {
                            premium -= 3.12;
                        }
                        premium += 35.1;
                    }
                    if (durationOfTheInsurance == 3) {
                        if (specialRegionCalculations(client, municipality, town)) {
                            premium -= 5.09;
                        }
                        premium += 76.65;
                    }

                    premium += 40.28;
                }
                if (yearsOfTheClient <= 24 && usage == 2) {
                    premium += 26.23;
                } else if (yearsOfTheClient <= 24 && usage == 5) {
                    premium += 26.34;
                } else if (yearsOfTheClient <= 24 && (usage == 0 || usage == 1 || usage == 4 || usage == 9
                        || usage == 10 || usage == 11 || usage == 12 || usage == 13)) {
                    if (durationOfTheInsurance == 1) {
                        premium += 14.36;
                    }
                    if (durationOfTheInsurance == 2) {
                        premium += 13.22;
                    }
                    if (durationOfTheInsurance == 3) {
                        premium += 13.34;
                    }
                    premium += 12.2;
                }
                switch (client.getCarAccidents()) {
                    case Constants.CAR_ACCIDENT_CONFIRMATION:
                        if (yearsOfTheClient <= 24 && usage == 2) {
                            premium += 27.89;
                        } else if (yearsOfTheClient > 24 && usage == 2) {
                            premium += 24.73;
                        } else if (yearsOfTheClient <= 24 && usage == 5) {
                            premium += 25.01;
                        } else if (yearsOfTheClient > 24 && usage == 5) {
                            premium += 24.73;
                        } else if (yearsOfTheClient <= 24 && (usage == 0 || usage == 1 || usage == 4 || usage == 9
                                || usage == 10 || usage == 11 || usage == 12 || usage == 13)) {
                            premium += 26.74;
                        } else if (yearsOfTheClient > 24 && (usage == 0 || usage == 1 || usage == 4 || usage == 9
                                || usage == 10 || usage == 11 || usage == 12 || usage == 13)) {
                            if (durationOfTheInsurance == 1 || durationOfTheInsurance == 2 || durationOfTheInsurance == 3) {
                                premium += 16.12;
                            }
                            premium += 9.98;
                        }
                        break;
                }
                break;

            case 5:
                if (usage == 2) {
                    if (durationOfTheInsurance == 0) {
                        if (specialRegionCalculations(client, municipality, town)) {
                            premium -= 7.74;
                        }
                    }
                    if (durationOfTheInsurance == 1) {
                        if (specialRegionCalculations(client, municipality, town)) {
                            premium -= 10.16;
                        }
                        premium += 32.94;
                    }
                    if (durationOfTheInsurance == 2) {
                        if (specialRegionCalculations(client, municipality, town)) {
                            premium -= 12.24;
                        }
                        premium += 56.85;
                    }
                    if (durationOfTheInsurance == 3) {
                        if (specialRegionCalculations(client, municipality, town)) {
                            premium -= 16.32;
                        }
                        premium += 104.58;
                    }
                    premium += 99.26;
                } else if (specialUsage) {
                    if (durationOfTheInsurance == 0) {
                        if (specialRegionCalculations(client, municipality, town)) {
                            premium -= 21.93;
                        }
                    }
                    if (durationOfTheInsurance == 1) {
                        if (specialRegionCalculations(client, municipality, town)) {
                            premium -= 24.48;
                        }
                        premium += 33.08;
                    }
                    if (durationOfTheInsurance == 2) {
                        if (specialRegionCalculations(client, municipality, town)) {
                            premium -= 26.52;
                        }
                        premium += 56.94;
                    }
                    if (durationOfTheInsurance == 3) {
                        if (specialRegionCalculations(client, municipality, town)) {
                            premium -= 30.6;
                        }
                        premium += 104.68;
                    }
                    premium += 266.24;
                } else if (usage == 5) {
                    if (durationOfTheInsurance == 0) {
                        if (specialRegionCalculations(client, municipality, town)) {
                            premium -= 5.87;
                        }
                    }
                    if (durationOfTheInsurance == 1) {
                        if (specialRegionCalculations(client, municipality, town)) {
                            premium -= 6.12;
                        }
                        premium += 33.22;
                    }
                    if (durationOfTheInsurance == 2) {
                        if (specialRegionCalculations(client, municipality, town)) {
                            premium -= 8.11;
                        }
                        premium += 57.09;
                    }
                    if (durationOfTheInsurance == 3) {
                        if (specialRegionCalculations(client, municipality, town)) {
                            premium -= 12.24;
                        }
                        premium += 104.83;
                    }
                    premium += 51.28;
                } else {
                    if (durationOfTheInsurance == 1) {
                        if (specialRegionCalculations(client, municipality, town)) {
                            premium -= 4.04;
                        }
                        premium += 20.32;
                    }
                    if (durationOfTheInsurance == 2) {
                        if (specialRegionCalculations(client, municipality, town)) {
                            premium -= 6.12;
                        }
                        premium += 44.22;
                    }
                    if (durationOfTheInsurance == 3) {
                        if (specialRegionCalculations(client, municipality, town)) {
                            premium -= 10.2;
                        }
                        premium += 91.96;
                    }
                    premium += 40.28;
                }

                if (yearsOfTheClient <= 24 && usage == 2) {
                    premium += 29.41;
                } else if (yearsOfTheClient <= 24 && usage == 5) {
                    premium += 26.34;
                } else if (yearsOfTheClient <= 24 && (usage == 0 || usage == 1 || usage == 4 || usage == 9
                        || usage == 10 || usage == 11 || usage == 12 || usage == 13)) {
                    if (durationOfTheInsurance == 1 || durationOfTheInsurance == 2 || durationOfTheInsurance == 3) {
                        premium += 12.34;
                    }
                    premium += 13.2;
                }
                switch (client.getCarAccidents()) {
                    case Constants.CAR_ACCIDENT_CONFIRMATION:

                        if (yearsOfTheClient <= 24 && usage == 2) {
                            premium += 29.24;
                        } else if (yearsOfTheClient > 24 && usage == 2) {
                            premium += 30.44;
                        } else if (yearsOfTheClient <= 24 && usage == 5) {
                            premium += 30.01;
                        } else if (yearsOfTheClient > 24 && usage == 5) {
                            premium += 29.73;
                        } else if (yearsOfTheClient <= 24 && (usage == 0 || usage == 1 || usage == 4 || usage == 9
                                || usage == 10 || usage == 11 || usage == 12 || usage == 13)) {
                            premium += 30.74;
                        } else if (yearsOfTheClient > 24 && (usage == 0 || usage == 1 || usage == 4 || usage == 9
                                || usage == 10 || usage == 11 || usage == 12 || usage == 13)) {
                            if (durationOfTheInsurance == 1 || durationOfTheInsurance == 2 || durationOfTheInsurance == 3) {
                                premium += 11.89;
                            }
                            premium += 17.98;
                        }
                        break;
                }
                break;

            case 6:
                if (usage == 2) {
                    if (durationOfTheInsurance == 0) {
                        if (specialRegionCalculations(client, municipality, town)) {
                            premium -= 7.68;
                        }
                    }
                    premium += 118.32;
                    if (durationOfTheInsurance == 1) {
                        if (specialRegionCalculations(client, municipality, town)) {
                            premium -= 10.2;
                        }
                        premium += 39.42;
                    }
                    if (durationOfTheInsurance == 2) {
                        if (specialRegionCalculations(client, municipality, town)) {
                            premium -= 12.24;
                        }
                        premium += 68.39;
                    }
                    if (durationOfTheInsurance == 3) {
                        if (specialRegionCalculations(client, municipality, town)) {
                            premium -= 16.32;
                        }
                        premium += 126.32;
                    }
                } else if (usage == 3 || usage == 6 || usage == 7 || usage == 8) {
                    if (durationOfTheInsurance == 0) {
                        if (specialRegionCalculations(client, municipality, town)) {
                            premium -= 25.66;
                        }
                    }
                    if (durationOfTheInsurance == 1) {
                        if (specialRegionCalculations(client, municipality, town)) {
                            premium -= 24.48;
                        }
                        premium += 35.72;
                    }
                    if (durationOfTheInsurance == 2) {
                        if (specialRegionCalculations(client, municipality, town)) {
                            premium -= 26.52;
                        }
                        premium += 64.68;
                    }
                    if (durationOfTheInsurance == 3) {
                        if (specialRegionCalculations(client, municipality, town)) {
                            premium -= 30.6;
                        }
                        premium += 122.62;
                    }
                    premium += 324.8;
                } else if (usage == 5) {
                    if (durationOfTheInsurance == 0) {
                        if (specialRegionCalculations(client, municipality, town)) {
                            premium -= 5.81;
                        }
                    }
                    if (durationOfTheInsurance == 1) {
                        if (specialRegionCalculations(client, municipality, town)) {
                            premium -= 7.12;
                        }
                        premium += 37.21;
                    }
                    if (durationOfTheInsurance == 2) {
                        if (specialRegionCalculations(client, municipality, town)) {
                            premium -= 9.16;
                        }
                        premium += 66.18;
                    }
                    if (durationOfTheInsurance == 3) {
                        if (specialRegionCalculations(client, municipality, town)) {
                            premium -= 12.23;
                        }
                        premium += 123.11;
                    }
                    premium += 63.59;
                } else {
                    if (durationOfTheInsurance == 1) {
                        if (specialRegionCalculations(client, municipality, town)) {
                            premium -= 4.08;
                        }
                        premium += 30.56;
                    }
                    if (durationOfTheInsurance == 2) {
                        if (specialRegionCalculations(client, municipality, town)) {
                            premium -= 6.12;
                        }
                        premium += 59.52;
                    }
                    if (durationOfTheInsurance == 3) {
                        if (specialRegionCalculations(client, municipality, town)) {
                            premium -= 10.2;
                        }
                        premium += 117.46;
                    }

                    premium += 40.28;
                }
                if (yearsOfTheClient <= 24 && usage == 2) {
                    premium += 29.41;
                } else if (yearsOfTheClient <= 24 && usage == 5) {
                    premium += 23.34;
                } else if (yearsOfTheClient <= 24 && (usage == 0 || usage == 1 || usage == 4 || usage == 9
                        || usage == 10 || usage == 11 || usage == 12 || usage == 13)) {
                    if (durationOfTheInsurance == 1 || durationOfTheInsurance == 2 || durationOfTheInsurance == 3) {
                        premium += 8.3;
                    }

                    premium += 17.2;
                }
                switch (client.getCarAccidents()) {
                    case Constants.CAR_ACCIDENT_CONFIRMATION:
                        if (yearsOfTheClient <= 24 && usage == 2) {
                            premium += 34.24;
                        } else if (yearsOfTheClient > 24 && usage == 2) {
                            premium += 35.54;
                        } else if (yearsOfTheClient <= 24 && usage == 5) {
                            premium += 35.01;
                        } else if (yearsOfTheClient > 24 && usage == 5) {
                            premium += 34.73;
                        } else if (yearsOfTheClient <= 24 && (usage == 0 || usage == 1 || usage == 4 || usage == 9
                                || usage == 10 || usage == 11 || usage == 12 || usage == 13)) {
                            premium += 35.74;
                        } else if (yearsOfTheClient > 24 && (usage == 0 || usage == 1 || usage == 4 || usage == 9
                                || usage == 10 || usage == 11 || usage == 12 || usage == 13)) {
                            if (specialRegionCalculations(client, municipality, town)) {
                                premium -= 3.58;
                            }
                            if (durationOfTheInsurance == 1 || durationOfTheInsurance == 2 || durationOfTheInsurance == 3) {

                                premium += 10.26;
                            }
                            premium += 26.98;
                        }
                        break;
                }
                break;
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
        } else if (car.getEngineVolume() == 5) {
            premium = (1100 * 0.11) + 30.52;
        } else if (car.getEngineVolume() == 6) {
            premium = (1100 * 0.11) + 61.65;
        } else if (car.getEngineVolume() == 7) {
            premium = (1100 * 0.11) + 68;
        } else {
            premium = (1100 * 0.11) + 89.22;
        }
        if (client.getCarAccidents().equals(Constants.CAR_ACCIDENT_CONFIRMATION) && car.getEngineVolume() == 4) {
            premium += 10.12;
        }

        premium = getCalculateClientYears(client, car, premium);
        premium = getAddressCalculations(client, premium);
        premium = getVehicleUsageCalculations(car, premium);
        premium = getCarYearsCalculations(car, premium);
        premium = getCarAccidentCalc(client, premium);

        return premium;
    }

    public static double electricCarCalculations(Car car, Client client) {

        premium = 0;

        premium = getCalculateClientYears(client, car, premium);
        premium = getAddressCalculations(client, premium);
        premium = getVehicleUsageCalculations(car, premium);
        premium = getCarAccidentCalc(client, premium);

        premium += 150.25;

        return premium;
    }

    private static double getCarYearsCalculations(Vehicle vehicle, double premium) {
        if (vehicle.getYear() <= 2004) {
            premium += 7.36;
        } else {
            premium += 11.28;
        }
        return premium;
    }

    private static boolean specialRegionCalculations(Client client, String municipality, String town) {
        return (municipality.equalsIgnoreCase(Constants.VARNA_MUNICIPALITY) && town.equalsIgnoreCase(Constants.VARNA_TOWN)) ||
                (municipality.equalsIgnoreCase(Constants.PLOVDIV_TOWN) && town.equalsIgnoreCase(Constants.PLOVDIV_TOWN)) ||
                (municipality.equalsIgnoreCase(Constants.SOFIA_CAPITAL) && town.equalsIgnoreCase(Constants.SOFIA_TOWN))
                        && !client.getCarAccidents().equals(Constants.CAR_ACCIDENT_CONFIRMATION);
    }


    private static double getAddressCalculations(Client client, double premium) {
        switch (client.getRegion().toLowerCase()) {
            case "софия":
                premium += 8.25;
                break;
            default:
                premium += 22.47;
                break;
        }
        if ((client.getMunicipality().equalsIgnoreCase("бургас") && client.getTown().equalsIgnoreCase("бургас")
                || (client.getMunicipality().equalsIgnoreCase("стара загора") && client.getTown().equalsIgnoreCase("стара загора")))) {
            premium -= 15.25;
        }

        if ((client.getMunicipality().equalsIgnoreCase("варна") && client.getTown().equalsIgnoreCase("варна")) ||
                (client.getMunicipality().equalsIgnoreCase("пловдив") && client.getTown().equalsIgnoreCase("пловдив"))) {
            premium += 3.26;
        }
        if (client.getRegion().equalsIgnoreCase("софия (столица)") && client.getMunicipality().equalsIgnoreCase("столична")) {
            premium += 11.24;
        }
        return premium;
    }

    private static double getCarAccidentCalc(Client client, double premium) {
        String carAccidents = client.getCarAccidents();
        if (carAccidents.equals(Constants.CAR_ACCIDENT_CONFIRMATION)) {
            premium += 49.12;
        }
        return premium;
    }

    private static double getVehicleUsageCalculations(Vehicle vehicle, double premium) {
        int usage = vehicle.getUsageOfTheVehicle();

        if (usage == 0) {
            premium += 25;
        } else if (usage == 2) {
            premium += 179.24;
        } else if (usage == 3 || usage == 6 || usage == 7 || usage == 8) {
            premium += 400.93;
        } else if (usage == 5) {
            premium += 92.59;
        } else {
            premium += 48.59;
        }
        return premium;
    }

    private static double getCalculateClientYears(Client client, Vehicle vehicle, double premium) {
        int usageOfTheVehicle = vehicle.getUsageOfTheVehicle();

        if (client.getYearsOfTheClient() <= 24 || (usageOfTheVehicle == 3 || usageOfTheVehicle == 6 ||
                usageOfTheVehicle == 7 || usageOfTheVehicle == 8)) {
            premium += 90.98;
        } else {
            premium += 11.45;
        }

        return premium;
    }

    private static void under24YearsUsers(int userYears, int vehicleUsage) {
        if (userYears <= 24 && vehicleUsage == 2) {
            premium += 60.5;
        } else if (userYears <= 24 && vehicleUsage == 5) {
            premium += 61.19;
        } else if (userYears <= 24 && (vehicleUsage == 0 || vehicleUsage == 1 || vehicleUsage == 4 || vehicleUsage == 9
                || vehicleUsage == 10 || vehicleUsage == 11 || vehicleUsage == 12 || vehicleUsage == 13)) {
            premium += 61.20;
        }
    }

    private static boolean capitolSpecialPremium(Client client) {
        return client.getRegion().equalsIgnoreCase(Constants.SOFIA_CAPITAL) && client.getMunicipality().equalsIgnoreCase(Constants.SOFIA_TOWN);
    }

    private static boolean specialTownATVCalculations(Client client) {
        return client.getRegion().equalsIgnoreCase(Constants.SOFIA_CAPITAL)
                || client.getMunicipality().equalsIgnoreCase(Constants.PLOVDIV_TOWN)
                || client.getTown().equalsIgnoreCase(Constants.VARNA_TOWN);
    }
    private static void under24YearsUserCalculations(int userYears, boolean specialUsage) {
        if (userYears <= 24 && !specialUsage) {
            premium += 25.5;
        }
    }


}
