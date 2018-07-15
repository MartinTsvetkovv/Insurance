package carInsurance;

import carInsurance.models.*;
import insuranceFx.Constants;

public class PremiumCalculations {


    private static double premium;


    private PremiumCalculations() {
        premium = 0.0;
    }

    public static double truckPremiumCalculations(Truck truck, Client client) {
        premium = 0;
        int usage = truck.getUsageOfTheVehicle();
        int load = truck.getLoadAbility();
        int useYears = client.getYearsOfTheClient();
        String carAccidents = client.getCarAccidents();
        boolean specialUsage = (usage == 3 || usage == 6 || usage == 7 || usage == 8);

        switch (load) {
            case Constants.UP_TO_TON_AND_A_HALF:
                if (usage == 2) {
                    premium += 358.88;
                } else if (specialUsage) {
                    premium += 661.62;
                } else if (usage == 5) {
                    premium += 272.39;
                } else {
                    premium += 229.14;
                }

                if (vehicleAccidentConfirmation(carAccidents, specialUsage)) {
                    premium += 54.06;
                }
                userUnder24YearsTruckCalculations(useYears, specialUsage);

                if (client.getMunicipality().equalsIgnoreCase(Constants.SOFIA_TOWN)) {
                    if (usage == 2) {
                        premium += 8.16;
                    } else if (specialUsage) {
                        premium += 15.3;
                    } else if (usage == 5) {
                        premium += 6.12;
                    } else {
                        premium += 6.12;
                    }
                }
                break;

            case Constants.UP_T0_THREE_TONS:
                if (usage == 2) {
                    premium += 407.84;
                } else if (specialUsage) {
                    premium += 753.42;
                } else if (usage == 5) {
                    premium += 309.11;
                } else {
                    premium += 259.74;
                }

                if (vehicleAccidentConfirmation(carAccidents, specialUsage)) {
                    premium += 61.71;
                }
                userUnder24YearsTruckCalculations(useYears, specialUsage);

                truckSofiaTownCalculations(client, usage, carAccidents, specialUsage);
                break;
            case Constants.UP_TO_FIVE_TONS:
                if (usage == 2) {
                    premium += 489.44;
                } else if (specialUsage) {
                    premium += 906.42;
                } else if (usage == 5) {
                    premium += 370.31;
                } else {
                    premium += 310.74;
                }

                if (vehicleAccidentConfirmation(carAccidents, specialUsage)) {
                    premium += 74.46;
                }

                userUnder24YearsTruckCalculations(useYears, specialUsage);

                truckSofiaTownCalculations(client, usage, carAccidents, specialUsage);
                break;

            case Constants.UP_TO_TEN_TONS:
                if (usage == 2) {
                    premium += 1563.3;
                } else if (specialUsage) {
                    premium += 2919.9;
                } else if (usage == 5) {
                    premium += 1175.7;
                } else {
                    premium += 981.9;
                }

                if (vehicleAccidentConfirmation(carAccidents, specialUsage)) {
                    premium += 242.25;
                }

                userUnder24YearsTruckCalculations(useYears, specialUsage);
                break;
            case Constants.UP_TO_TWENTY_TONS:
                if (usage == 2) {
                    premium += 2183.46;
                } else if (specialUsage) {
                    premium += 4082.7;
                } else if (usage == 5) {
                    premium += 1640.82;
                } else {
                    premium += 1369.5;
                }
                if (vehicleAccidentConfirmation(carAccidents, specialUsage)) {
                    premium += 339.15;
                }
                userUnder24YearsTruckCalculations(useYears, specialUsage);
                break;
            case Constants.OVER_TWENTY_TONS:
                if (usage == 2) {
                    premium += 2493.54;
                } else if (specialUsage) {
                    premium += 4664.1;
                } else if (usage == 5) {
                    premium += 1873.38;
                } else {
                    premium += 1563.3;
                }
                if (vehicleAccidentConfirmation(carAccidents, specialUsage)) {
                    premium += 387.6;
                }
                userUnder24YearsTruckCalculations(useYears, specialUsage);
                break;

        }


        return premium;
    }

    private static void truckSofiaTownCalculations(Client client, int usage, String carAccidents, boolean specialUsage) {
        if (client.getMunicipality().equalsIgnoreCase(Constants.SOFIA_TOWN)) {
            if (usage == 2) {
                premium += 16.32;
            } else if (specialUsage) {
                premium += 30.6;
            } else if (usage == 5) {
                premium += 12.24;
            } else {
                premium += 10.2;
            }
            if (vehicleAccidentConfirmation(carAccidents, specialUsage)) {
                premium += 3.1;
            }
        }
    }

    public static double campingTrailers(CampingTrailers campingTrailers, Client client) {
        premium = 0;
        int termOfTheInsurance = campingTrailers.getEngineVolume();
        String carAccidents = client.getCarAccidents();
        int userYears = client.getYearsOfTheClient();
        int vehicleUsage = campingTrailers.getUsageOfTheVehicle();
        boolean specialUsage = (vehicleUsage == 3 || vehicleUsage == 6 || vehicleUsage == 7 || vehicleUsage == 8);

        switch (termOfTheInsurance) {
            case 0:
                if (vehicleUsage == 2) {
                    if (userYears <= 24) {
                        premium += 25.5;
                    }
                    if (carAccidents.equals(Constants.CAR_ACCIDENT_CONFIRMATION)) {
                        premium += 13.26;
                    }
                    premium += 52.68;
                } else if (specialUsage) {
                    premium += 126.94;
                } else if (vehicleUsage == 5) {
                    if (userYears <= 24) {
                        premium += 13.46;
                    }
                    if (carAccidents.equals(Constants.CAR_ACCIDENT_CONFIRMATION)) {
                        premium += 1.4;
                    }
                    if (carAccidents.equals(Constants.CAR_ACCIDENT_CONFIRMATION) && userYears <= 24) {
                        premium += 11.86;
                    }
                    premium += 43.5;
                } else {
                    if (userYears <= 24) {
                        premium += 2.86;
                    }
                    if (carAccidents.equals(Constants.CAR_ACCIDENT_CONFIRMATION) && userYears <= 24) {
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
                    if (carAccidents.equals(Constants.CAR_ACCIDENT_CONFIRMATION)) {
                        premium += 13.26;
                    }
                    premium += 65.94;
                } else if (specialUsage) {
                    premium += 140.2;
                } else if (vehicleUsage == 5) {
                    if (userYears <= 24) {
                        premium += 25.5;
                    }
                    if (carAccidents.equals(Constants.CAR_ACCIDENT_CONFIRMATION)) {
                        premium += 13.26;
                    }
                    premium += 44.72;
                } else {
                    if (userYears <= 24) {
                        premium += 16.12;
                    }
                    if (carAccidents.equals(Constants.CAR_ACCIDENT_CONFIRMATION) && userYears <= 24) {
                        premium += 9.38;
                    }
                    if (carAccidents.equals(Constants.CAR_ACCIDENT_CONFIRMATION)) {
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
                    if (carAccidents.equals(Constants.CAR_ACCIDENT_CONFIRMATION)) {
                        premium += 13.26;
                    }
                    premium += 76.55;
                } else if (specialUsage) {
                    premium += 150.8;
                } else if (vehicleUsage == 5) {
                    if (userYears <= 24) {
                        premium += 25.5;
                    }
                    if (carAccidents.equals(Constants.CAR_ACCIDENT_CONFIRMATION)) {
                        premium += 13.26;
                    }
                    premium += 55.33;
                } else {
                    if (userYears <= 24) {
                        premium += 26.12;
                    }
                    if (carAccidents.equals(Constants.CAR_ACCIDENT_CONFIRMATION)) {
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
                    if (carAccidents.equals(Constants.CAR_ACCIDENT_CONFIRMATION)) {
                        premium += 13.26;
                    }
                    premium += 97.76;
                } else if (specialUsage) {
                    premium += 172.02;
                } else if (vehicleUsage == 5) {
                    if (userYears <= 24) {
                        premium += 25.5;
                    }
                    if (carAccidents.equals(Constants.CAR_ACCIDENT_CONFIRMATION)) {
                        premium += 13.26;
                    }
                    premium += 76.55;
                } else {
                    if (userYears <= 24) {
                        premium += 26.12;
                    }
                    if (carAccidents.equals(Constants.CAR_ACCIDENT_CONFIRMATION)) {
                        premium += 13.26;
                    }
                    premium += 65.94;
                }
                break;
        }
        return premium;
    }

    public static double luggageTrailers(LuggageTrailer luggageTrailer, Client client) {
        premium = 0;
        int vehicleUsage = luggageTrailer.getUsageOfTheVehicle();
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

        if (vehicleAccidentConfirmation(carAccidents, specialUsage)) {
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

    public static double trolleyBusesCalculations(Trolleybus trolleybus, Client client) {
        premium = 0;
        int vehicleUsage = trolleybus.getUsageOfTheVehicle();
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
        if (vehicleAccidentConfirmation(carAccidents, specialUsage)) {
            premium += 92.31;
        }
        if (userYears <= 24 && !specialUsage) {
            premium += 51.0;
        }

        if (client.getMunicipality().equalsIgnoreCase(Constants.SOFIA_TOWN)) {
            if (vehicleUsage == 2) {
                if (carAccidents.equals(Constants.CAR_ACCIDENT_CONFIRMATION)) {
                    premium += 39.77;
                }
                if (userYears <= 24) {
                    premium += 27.02;
                }
                premium += 54.58;
            } else if (specialUsage) {
                premium += 153.0;
            } else if (vehicleUsage == 5) {
                if (carAccidents.equals(Constants.CAR_ACCIDENT_CONFIRMATION)) {
                    premium += 12.75;
                }
                premium += 61.2;
            } else {
                if (carAccidents.equals(Constants.CAR_ACCIDENT_CONFIRMATION)) {
                    premium += 12.75;
                }
                premium += 51.0;
            }
        }
        if (specialTownsVarnaPlovdiv(client)) {
            if (vehicleUsage == 2) {
                premium += 16.32;
            } else if (specialUsage) {
                premium += 30.6;
            } else if (vehicleUsage == 5) {

                premium += 12.24;
            } else {
                premium += 10.0;
            }
            if (vehicleAccidentConfirmation(carAccidents, specialUsage)) {
                premium += 3.1;
            }
        }
        return premium;
    }

    public static double constructionMachinery(ConstructionMachinery constructionMachinery, Client client) {
        premium = 0;
        int vehicleUsage = constructionMachinery.getUsageOfTheVehicle();
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

        if (vehicleAccidentConfirmation(client.getCarAccidents(), specialUsage)) {
            premium += 28.82;
        }

        if (userYears <= 24 && !specialUsage) {
            premium += 25.5;
        }
        return premium;
    }

    public static double agriculturalMachineryCalculations(AgriculturalMachinery machinery, Client client) {
        premium = 0;
        int vehicleUsage = machinery.getUsageOfTheVehicle();
        int userYears = client.getYearsOfTheClient();
        String carAccidents = client.getCarAccidents();
        boolean specialUsage = (vehicleUsage == 3 || vehicleUsage == 6 || vehicleUsage == 7 || vehicleUsage == 8);
        if (vehicleUsage == Constants.TAXI) {
            premium += 163.04;
        } else if (specialUsage) {
            premium += 294.42;
        } else if (vehicleUsage == Constants.RENT) {
            premium += 125.51;
        } else {
            premium += 106.74;
        }

        if (vehicleAccidentConfirmation(carAccidents, specialUsage)) {
            premium += 23.46;
        }
        if (userYears <= 24 && !specialUsage) {
            premium += 25.5;
        }

        if (client.getMunicipality().equalsIgnoreCase(Constants.SOFIA_TOWN)) {
            if (vehicleUsage == Constants.TAXI) {
                premium += 16.32;
            } else if (specialUsage) {
                premium += 30.60;
            } else if (vehicleUsage == Constants.RENT) {
                premium += 12.24;
            } else {
                premium += 10.2;
            }
            if (vehicleAccidentConfirmation(carAccidents, specialUsage)) {
                premium += 3.41;
            }
        }
        if (specialTownsVarnaPlovdiv(client)) {
            if (vehicleUsage == Constants.TAXI) {
                premium += 8.16;
            } else if (specialUsage) {
                premium += 15.3;
            } else if (vehicleUsage == Constants.RENT) {
                premium += 6.12;
            } else {
                premium += 5.1;
            }
        }
        return premium;
    }

    public static double cargoTrailer(CargoTrailer cargoTrailer, Client client) {
        premium = 0;
        int vehicleUsage = cargoTrailer.getUsageOfTheVehicle();
        int userYears = client.getYearsOfTheClient();
        String carAccidents = client.getCarAccidents();
        boolean specialUsage = (vehicleUsage == 3 || vehicleUsage == 6 || vehicleUsage == 7 || vehicleUsage == 8);

        if (vehicleUsage == Constants.TAXI) {
            premium += 166.31;
        } else if (specialUsage) {
            premium += 300.54;
        } else if (vehicleUsage == Constants.RENT) {
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

    public static double saddleTractors(SaddleTractor saddleTractor, Client client) {
        premium = 0;
        int vehicleUsage = saddleTractor.getUsageOfTheVehicle();
        int userYears = client.getYearsOfTheClient();
        String carAccidents = client.getCarAccidents();
        boolean specialUsage = (vehicleUsage == 3 || vehicleUsage == 6 || vehicleUsage == 7 || vehicleUsage == 8);
        if (vehicleUsage == Constants.TAXI) {
            premium += 5417.69;
        } else if (specialUsage) {
            premium += 10146.89;
        } else if (vehicleUsage == Constants.RENT) {
            premium += 4066.49;
        } else {
            premium += 3390.90;
        }

        if (userYears <= 24 && !specialUsage) {
            premium += 40.8;
        }

        if (vehicleAccidentConfirmation(carAccidents, specialUsage)) {
            premium += 844.49;
        }

        return premium;
    }

    public static double calculationsATV(ATV atv, Client client) {
        premium = 0;
        int vehicleUsage = atv.getUsageOfTheVehicle();
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

        if (vehicleAccidentConfirmation(carAccidents, specialUsage)) {
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

    public static double busCalculations(Bus bus, Client client) {
        premium = 0;
        int busSeats = bus.getEngineVolume();
        String carAccidents = client.getCarAccidents();
        int userYears = client.getYearsOfTheClient();
        int vehicleUsage = bus.getUsageOfTheVehicle();
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

                if (vehicleAccidentConfirmation(carAccidents, specialUsage)) {
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

                if (vehicleAccidentConfirmation(carAccidents, specialUsage)) {
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

                if (vehicleAccidentConfirmation(carAccidents, specialUsage)) {
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
                if (durationOfTheInsurance == 1 || durationOfTheInsurance == 2 || durationOfTheInsurance == 3) {
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
                    if (durationOfTheInsurance == 2 || durationOfTheInsurance == 3) {
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
        premium = 0;
        int engineVolume = car.getEngineVolume();
        int usage = car.getUsageOfTheVehicle();
        String carAccidents = client.getCarAccidents();
        int carYear = car.getYear();
        boolean specialUsage = (usage == 3 || usage == 6 || usage == 7 || usage == 8);

        if (engineVolume == 0 || engineVolume == 1) {
            carCalculations(client, carYear, usage, carAccidents, specialUsage);

        }
        switch (engineVolume) {
            case 2:
                carCalculations(client, carYear, usage, carAccidents, specialUsage);
                if (usage == 2 || usage == 5) {
                    premium += 2.1;
                }
                if (specialUsage) {
                    premium += 5.1;
                }
                if ((carYear > 2003 && !specialUsage) && (!specialTownsVarnaPlovdiv(client) && !specialTownsBurgasSofiaStaraZagora(client)
                        && !client.getMunicipality().equalsIgnoreCase(Constants.SOFIA_TOWN))) {
                    premium += 4.86;
                }
                premium += 2.1;
                break;
            case 3:
                carCalculations(client, carYear, usage, carAccidents, specialUsage);
                if (usage == 2) {
                    premium += 3.38;
                }
                if (specialUsage) {
                    premium += 10.0;
                }
                if (usage == 5) {
                    premium += 2.34;
                } else if (carAccidents.equals(Constants.CAR_ACCIDENT_CONFIRMATION) && specialTownsVarnaPlovdiv(client)) {
                    premium += 2.86;
                } else if (client.getMunicipality().equalsIgnoreCase(Constants.SOFIA_TOWN)) {
                    premium += 2.1;
                }
                premium += 3.96;
                break;
            case 4:
                carCalculations(client, carYear, usage, carAccidents, specialUsage);
                if (usage == 2) {
                    premium += 5.06;
                } else if (usage == 5) {
                    premium += 2.3;
                } else if (specialUsage) {
                    premium += 14.68;
                }
                if (vehicleAccidentConfirmation(carAccidents, specialUsage)) {
                    premium += 2.20;
                }
                if (carAccidents.equals(Constants.CAR_ACCIDENT_CONFIRMATION) && specialTownsBurgasSofiaStaraZagora(client)) {
                    premium -= 3.1;
                }
                if (specialTownsVarnaPlovdiv(client) || client.getMunicipality().equalsIgnoreCase(Constants.SOFIA_TOWN)) {
                    premium += 4.95;
                }
                if ((specialTownsVarnaPlovdiv(client) && usage == 2)
                        || (client.getMunicipality().equalsIgnoreCase(Constants.SOFIA_TOWN) && usage == 2)) {
                    premium += 4.98;
                }
                if ((specialTownsVarnaPlovdiv(client) && specialUsage) ||
                        (client.getMunicipality().equalsIgnoreCase(Constants.SOFIA_TOWN) && specialUsage)) {
                    premium += 12.39;
                }
                if (specialTownsVarnaPlovdiv(client) && carAccidents.equals(Constants.CAR_ACCIDENT_CONFIRMATION)
                        && !specialUsage) {
                    premium += 4.86;
                }
                premium += 5.94;
                break;
            case 5:
                carCalculations(client, carYear, usage, carAccidents, specialUsage);
                if (usage == 0) {
                    premium += 14.86;
                } else if (usage == 2) {
                    premium += 23.84;
                } else if (specialUsage) {
                    premium += 44.7;
                } else if (usage == 5) {
                    premium += 17.63;
                } else {
                    premium += 14.9;
                }
                if (carAccidents.equalsIgnoreCase(Constants.CAR_ACCIDENT_CONFIRMATION) && !specialUsage) {
                    premium += 3.21;
                }
                if (specialTownsVarnaPlovdiv(client)) {
                    if (usage == 0) {
                        premium += 7.77;
                    } else if (usage == 2) {
                        premium += 14.66;
                    } else if (specialUsage) {
                        premium += 27.48;
                    } else if (usage == 5) {
                        premium += 11.24;
                    } else {
                        premium += 9.16;
                    }
                    if (vehicleAccidentConfirmation(carAccidents, specialUsage)) {
                        premium += 4.21;
                    }
                }

                if (client.getMunicipality().equalsIgnoreCase(Constants.SOFIA_TOWN)) {
                    if (usage == 0) {
                        premium += 10.89;
                    } else if (usage == 2) {
                        premium += 20.16;
                    } else if (specialUsage) {
                        premium += 37.79;
                    } else if (usage == 5) {
                        premium += 15.37;
                    } else {
                        premium += 12.6;
                    }
                    if (vehicleAccidentConfirmation(carAccidents, specialUsage)) {
                        premium += 4.21;
                    }
                }
                break;
            case 6:
                carCalculations(client, carYear, usage, carAccidents, specialUsage);
                if (usage == 0) {
                    premium += 48.5;
                } else if (usage == 2) {
                    premium += 89.86;
                } else if (specialUsage) {
                    premium += 168.48;
                } else if (usage == 5) {
                    premium += 67.14;
                } else {
                    premium += 56.16;
                }
                if (vehicleAccidentConfirmation(carAccidents, specialUsage)) {
                    premium += 14.0;
                }
                if (specialTownsBurgasSofiaStaraZagora(client)) {
                    carCalculationsBurgasSofiaSz(usage, specialUsage);
                }
                carCalculationsVarnaPlovdiv(client, usage, carAccidents, specialUsage);

                caCalculationsSofiaTown(client, carYear, usage, carAccidents, specialUsage);
                break;
            case 7:
                carCalculations(client, carYear, usage, carAccidents, specialUsage);

                if (usage == 0) {
                    premium += 49.48;
                } else if (usage == 2) {
                    premium += 91.97;
                } else if (specialUsage) {
                    premium += 171.94;
                } else if (usage == 5) {
                    premium += 68.53;
                } else {
                    premium += 57.32;
                }
                if (vehicleAccidentConfirmation(carAccidents, specialUsage)) {
                    premium += 14.32;
                }
                if (specialTownsBurgasSofiaStaraZagora(client)) {
                    carCalculationsBurgasSofiaSz(usage, specialUsage);
                }

                carCalculationsVarnaPlovdiv(client, usage, carAccidents, specialUsage);

                caCalculationsSofiaTown(client, carYear, usage, carAccidents, specialUsage);
                break;
            case 8:
                carCalculations(client, carYear, usage, carAccidents, specialUsage);

                if (usage == 0) {
                    if (carAccidents.equals(Constants.CAR_ACCIDENT_CONFIRMATION)) {
                        premium -= 2.14;
                    }
                    premium += 74.2;
                } else if (usage == 2) {
                    premium += 137.53;
                } else if (specialUsage) {
                    premium += 257.86;
                } else if (usage == 5) {
                    premium += 102.9;
                } else {
                    premium += 85.96;
                }
                if (vehicleAccidentConfirmation(carAccidents, specialUsage)) {
                    premium += 21.56;
                }

                if (specialTownsBurgasSofiaStaraZagora(client)) {
                    carCalculationsBurgasSofiaSz(usage, specialUsage);
                }
                if (specialTownsVarnaPlovdiv(client)) {
                    if (usage == 0) {
                        premium += 3.8;
                    } else if (usage == 2) {
                        premium += 7.3;
                    } else if (specialUsage) {
                        premium += 13.74;
                    } else if (usage == 5) {
                        premium += 5.74;
                    } else {
                        premium += 4.26;
                    }
                    if (vehicleAccidentConfirmation(carAccidents, specialUsage)) {
                        premium += 4.21;
                    }
                }
                if (client.getMunicipality().equalsIgnoreCase(Constants.SOFIA_TOWN)) {
                    if (usage == 0) {
                        if (carYear > 2003) {
                            premium += 3.1;
                        }
                        premium += 7.93;
                    } else if (usage == 2) {
                        premium += 14.69;
                    } else if (specialUsage) {
                        premium += 27.54;
                    } else if (usage == 5) {
                        premium += 11.27;
                    } else {
                        premium += 9.18;
                    }
                    if (vehicleAccidentConfirmation(carAccidents, specialUsage)) {
                        premium += 3.1;
                    }
                }
                break;

        }


        return premium;
    }

    private static void caCalculationsSofiaTown(Client client, int carYear, int usage, String carAccidents, boolean specialUsage) {
        if (client.getMunicipality().equalsIgnoreCase(Constants.SOFIA_TOWN)) {
            if (usage == 0) {
                if (carYear > 2003) {
                    premium += 2.1;
                }
                premium += 12.86;
            } else if (usage == 2) {
                premium += 25.66;
            } else if (specialUsage) {
                premium += 48.1;
            } else if (usage == 5) {
                premium += 19.5;
            } else {
                premium += 16.04;
            }
            if (vehicleAccidentConfirmation(carAccidents, specialUsage)) {
                premium += 4.21;
            }
        }
    }

    private static boolean vehicleAccidentConfirmation(String carAccidents, boolean specialUsage) {
        return carAccidents.equals(Constants.CAR_ACCIDENT_CONFIRMATION) && !specialUsage;
    }

    private static void userUnder24YearsTruckCalculations(int useYears, boolean specialUsage) {
        if (useYears <= 24 && !specialUsage) {
            premium += 61.2;
        }
    }

    private static void carCalculationsVarnaPlovdiv(Client client, int usage, String carAccidents, boolean specialUsage) {
        if (specialTownsVarnaPlovdiv(client)) {
            if (usage == 0) {
                premium += 8.75;
            } else if (usage == 2) {
                premium += 16.5;
            } else if (specialUsage) {
                premium += 30.94;
            } else if (usage == 5) {
                premium += 12.63;
            } else {
                premium += 10.32;
            }
            if (vehicleAccidentConfirmation(carAccidents, specialUsage)) {
                premium += 4.21;
            }
        }
    }

    private static void carCalculationsBurgasSofiaSz(int usage, boolean specialUsage) {
        if (usage == 0) {
            premium -= 3.69;
        } else if (usage == 2) {
            premium -= 6.62;
        } else if (specialUsage) {
            premium -= 12.42;
        } else if (usage == 5) {
            premium -= 4.6;
        } else {
            premium -= 4.14;
        }
    }

    private static void carCalculations(Client client, int carYear, int usage, String carAccidents, boolean specialUsage) {
        if (usage == 0) {
            if (carYear > 2003) {
                premium += 4.86;
            }
            if (client.getMunicipality().equalsIgnoreCase(Constants.SOFIA_TOWN)) {
                premium += 11.87;
            }
            if (specialTownsBurgasSofiaStaraZagora(client)) {
                premium -= 14.89;
            }

            if (specialTownsVarnaPlovdiv(client)) {
                premium += 4.1;
            }
            if (carAccidents.equals(Constants.CAR_ACCIDENT_CONFIRMATION)) {
                premium += 47.8;
            }
            premium += 204.1;
        } else if (usage == 2) {
            if (client.getMunicipality().equalsIgnoreCase(Constants.SOFIA_TOWN)) {
                premium += 22.01;
            }
            if (specialTownsBurgasSofiaStaraZagora(client)) {
                premium -= 27.62;
            }
            if (specialTownsVarnaPlovdiv(client)) {
                premium += 7.34;
            }
            if (carAccidents.equals(Constants.CAR_ACCIDENT_CONFIRMATION)) {
                premium += 53.83;
            }
            premium += 357.45;
        } else if (specialUsage) {
            if (client.getMunicipality().equalsIgnoreCase(Constants.SOFIA_TOWN)) {
                premium += 41.28;
            }
            if (specialTownsBurgasSofiaStaraZagora(client)) {
                premium -= 51.78;
            }
            if (specialTownsVarnaPlovdiv(client)) {
                premium += 13.77;
            }
            premium += 658.93;
        } else if (usage == 5) {
            if (client.getMunicipality().equalsIgnoreCase(Constants.SOFIA_TOWN)) {
                premium += 16.26;
            }
            if (specialTownsBurgasSofiaStaraZagora(client)) {
                premium -= 21.1;
            }
            if (specialTownsVarnaPlovdiv(client)) {
                premium += 5.26;
            }
            if (carAccidents.equals(Constants.CAR_ACCIDENT_CONFIRMATION)) {
                premium += 53.59;
            }
            premium += 271.56;
        } else {
            if (client.getMunicipality().equalsIgnoreCase(Constants.SOFIA_TOWN)) {
                premium += 13.76;
            }
            if (specialTownsBurgasSofiaStaraZagora(client)) {
                premium -= 17.26;
            }
            if (specialTownsVarnaPlovdiv(client)) {
                premium += 4.59;
            }
            if (carAccidents.equals(Constants.CAR_ACCIDENT_CONFIRMATION)) {
                premium += 53.84;
            }
            premium += 228.24;
        }
        if (client.getMunicipality().equalsIgnoreCase(Constants.SOFIA_TOWN)
                && carAccidents.equalsIgnoreCase(Constants.CAR_ACCIDENT_CONFIRMATION)
                && !specialUsage) {
            premium += 3.5;
        }

        if (specialTownsBurgasSofiaStaraZagora(client) && !specialUsage && carAccidents.equals(Constants.CAR_ACCIDENT_CONFIRMATION)) {
            premium -= 4.02;
        }

        if (client.getYearsOfTheClient() <= 24 && !specialUsage) {
            premium += 79.56;
        }
    }

    public static double electricCarCalculations(ElectricCar car, Client client) {
        premium = 0;
        int usage = car.getUsageOfTheVehicle();
        String carAccidents = client.getCarAccidents();
        int userYears = client.getYearsOfTheClient();
        boolean specialUsage = (usage == 3 || usage == 6 || usage == 7 || usage == 8);

        if (usage == 0) {
            if (carAccidents.equals(Constants.CAR_ACCIDENT_CONFIRMATION)) {
                premium -= 6.19;
            }
            premium += 208.06;
        } else if (usage == 2) {
            premium += 364.79;
        } else if (specialUsage) {
            premium += 672.7;
        } else if (usage == 5) {
            premium += 276.82;
        } else {
            premium += 232.83;
        }

        if (vehicleAccidentConfirmation(carAccidents, specialUsage)) {
            premium += 54.98;
        }
        if (userYears <= 24 && !specialUsage) {
            premium += 79.56;
        }

        if (specialTownsBurgasSofiaStaraZagora(client)) {
            if (usage == 0) {
                premium -= 16.21;
            } else if (usage == 2) {
                premium -= 30.06;
            } else if (specialUsage) {
                premium -= 56.37;
            } else if (usage == 5) {
                premium -= 22.55;
            } else {
                premium -= 18.79;
            }
        }

        if (specialTownsVarnaPlovdiv(client)) {
            if (usage == 0) {
                premium += 4.58;
            } else if (usage == 2) {
                premium += 7.33;
            } else if (specialUsage) {
                premium += 14.0;
            } else if (usage == 5) {
                premium += 5.49;
            } else {
                premium += 4.58;
            }
            if (vehicleAccidentConfirmation(carAccidents, specialUsage)) {
                premium += 1.67;
            }
        }
        if (client.getMunicipality().equalsIgnoreCase(Constants.SOFIA_TOWN)) {
            if (usage == 0) {
                premium += 12.86;
            } else if (usage == 2) {
                premium += 23.83;
            } else if (specialUsage) {
                premium += 44.67;
            } else if (usage == 5) {
                premium += 17.87;
            } else {
                premium += 14.89;
            }
            if (vehicleAccidentConfirmation(carAccidents, specialUsage)) {
                premium += 3.5;
            }
        }

        return premium;
    }

    private static boolean specialRegionCalculations(Client client, String municipality, String town) {
        return (municipality.equalsIgnoreCase(Constants.VARNA_MUNICIPALITY) && town.equalsIgnoreCase(Constants.VARNA_TOWN)) ||
                (municipality.equalsIgnoreCase(Constants.PLOVDIV_TOWN) && town.equalsIgnoreCase(Constants.PLOVDIV_TOWN)) ||
                (municipality.equalsIgnoreCase(Constants.SOFIA_CAPITAL) && town.equalsIgnoreCase(Constants.SOFIA_TOWN))
                        && !client.getCarAccidents().equals(Constants.CAR_ACCIDENT_CONFIRMATION);
    }

    private static boolean specialTownsBurgasSofiaStaraZagora(Client client) {
        return client.getTown().equalsIgnoreCase("бургас") || client.getTown().equalsIgnoreCase("стара загора")
                || client.getRegion().equalsIgnoreCase("софия");
    }

    private static boolean specialTownsVarnaPlovdiv(Client client) {
        return client.getMunicipality().equalsIgnoreCase(Constants.PLOVDIV_TOWN) || client.getTown().equalsIgnoreCase(Constants.VARNA_TOWN);
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
