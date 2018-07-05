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
        if (load == 0) {
            premium = (1500 * 0.05) + 76;
        } else if (load == 1) {
            premium = (1500 * 0.05) + 116.6;
        } else if (load == 2) {
            premium = (3000 * 0.05) + 96.23;
        } else if (load == 3) {
            premium = (3500 * 0.05) + 625.43;
        } else if (load == 4) {
            premium = (5000 * 0.20) + 120.4;
        } else {
            premium = (5000 * 0.20) + 305.34;
        }

        boolean specialUsage = (usage == 3 || usage == 6 || usage == 7 || usage == 8);
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
                if (usage == 5 && client.getCarAccidents().equals(Constants.CAR_ACCIDENT_CONFIRMATION) && client.getYearsOfTheClient() > 24) {
                    premium += 19.98;
                }
                break;
            case 3:
                if (usage == 5) {
                    premium += 111.25;
                }
                if (usage == 2) {
                    premium += 352;
                }
                if (specialUsage) {
                    premium += 1250.23;
                }
                break;
            case 4:
                if (usage == 2) {
                    premium += 571;
                }
                if (usage == 5) {
                    premium += 190.26;
                }
                if (specialUsage) {
                    premium += 1925.81;
                }
                break;
            case 5:
                if (usage == 2) {
                    premium += 657.31;
                }
                if (usage == 5) {
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
                    premium += 600.7;
                } else if (specialUsage) {
                    premium += 1116.94;
                } else if (vehicleUsage == 5) {
                    premium += 452.32;
                } else {
                    premium += 378.46;
                }

                //under 24 years without accident
                if (userYears <= 24 && vehicleUsage == 2) {
                    premium += 60.5;
                } else if (userYears <= 24 && vehicleUsage == 5) {
                    premium += 61.19;
                } else if (userYears <= 24 && (vehicleUsage == 0 || vehicleUsage == 1 || vehicleUsage == 4 || vehicleUsage == 9
                        || vehicleUsage == 10 || vehicleUsage == 11 || vehicleUsage == 12 || vehicleUsage == 13)) {
                    premium += 61.20;
                }

                if (carAccidents.equals(Constants.CAR_ACCIDENT_CONFIRMATION) && !specialUsage) {
                    premium += 92.31;
                }

                premium += 3.68;
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
                        if ((municipality.equalsIgnoreCase(Constants.VARNA_MUNICIPALITY) && town.equalsIgnoreCase(Constants.VARNA_TOWN)) ||
                                (municipality.equalsIgnoreCase(Constants.PLOVDIV_MUNICIPALITY) && town.equalsIgnoreCase(Constants.PLOVDIV_TOWN)) ||
                                (municipality.equalsIgnoreCase(Constants.SOFIA_CAPITAL) && town.equalsIgnoreCase(Constants.SOFIA_TOWN))
                                        && !client.getCarAccidents().equals(Constants.CAR_ACCIDENT_CONFIRMATION)) {
                            premium -= 5.26;
                        }
                        premium += 30;
                    }
                    if (durationOfTheInsurance == 2) {
                        if ((municipality.equalsIgnoreCase(Constants.VARNA_MUNICIPALITY) && town.equalsIgnoreCase(Constants.VARNA_TOWN)) ||
                                (municipality.equalsIgnoreCase(Constants.PLOVDIV_MUNICIPALITY) && town.equalsIgnoreCase(Constants.PLOVDIV_TOWN)) ||
                                (municipality.equalsIgnoreCase(Constants.SOFIA_CAPITAL) && town.equalsIgnoreCase(Constants.SOFIA_TOWN))
                                        && !client.getCarAccidents().equals(Constants.CAR_ACCIDENT_CONFIRMATION)) {
                            premium -= 7.22;
                        }
                        premium += 51.75;
                    }
                    if (durationOfTheInsurance == 3) {
                        if ((municipality.equalsIgnoreCase(Constants.VARNA_MUNICIPALITY) && town.equalsIgnoreCase(Constants.VARNA_TOWN)) ||
                                (municipality.equalsIgnoreCase(Constants.PLOVDIV_MUNICIPALITY) && town.equalsIgnoreCase(Constants.PLOVDIV_TOWN)) ||
                                (municipality.equalsIgnoreCase(Constants.SOFIA_CAPITAL) && town.equalsIgnoreCase(Constants.SOFIA_TOWN))
                                        && !client.getCarAccidents().equals(Constants.CAR_ACCIDENT_CONFIRMATION)) {
                            premium -= 8.2;
                        }
                        premium += 92.3;
                    }
                    premium += 87.1;
                } else if (specialUsage) {
                    if ((municipality.equalsIgnoreCase(Constants.VARNA_MUNICIPALITY) && town.equalsIgnoreCase(Constants.VARNA_TOWN)) ||
                            (municipality.equalsIgnoreCase(Constants.PLOVDIV_MUNICIPALITY) && town.equalsIgnoreCase(Constants.PLOVDIV_TOWN)) ||
                            (municipality.equalsIgnoreCase(Constants.SOFIA_CAPITAL) && town.equalsIgnoreCase(Constants.SOFIA_TOWN))
                                    && !client.getCarAccidents().equals(Constants.CAR_ACCIDENT_CONFIRMATION)) {
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
                        if ((municipality.equalsIgnoreCase(Constants.VARNA_MUNICIPALITY) && town.equalsIgnoreCase(Constants.VARNA_TOWN)) ||
                                (municipality.equalsIgnoreCase(Constants.PLOVDIV_MUNICIPALITY) && town.equalsIgnoreCase(Constants.PLOVDIV_TOWN)) ||
                                (municipality.equalsIgnoreCase(Constants.SOFIA_CAPITAL) && town.equalsIgnoreCase(Constants.SOFIA_TOWN))
                                        && !client.getCarAccidents().equals(Constants.CAR_ACCIDENT_CONFIRMATION)) {
                            premium -= 3.14;
                        }
                        premium += 29.12;
                    }
                    if (durationOfTheInsurance == 2) {
                        if ((municipality.equalsIgnoreCase(Constants.VARNA_MUNICIPALITY) && town.equalsIgnoreCase(Constants.VARNA_TOWN)) ||
                                (municipality.equalsIgnoreCase(Constants.PLOVDIV_MUNICIPALITY) && town.equalsIgnoreCase(Constants.PLOVDIV_TOWN)) ||
                                (municipality.equalsIgnoreCase(Constants.SOFIA_CAPITAL) && town.equalsIgnoreCase(Constants.SOFIA_TOWN))
                                        && !client.getCarAccidents().equals(Constants.CAR_ACCIDENT_CONFIRMATION)) {
                            premium -= 4.33;
                        }
                        premium += 50.1;
                    }
                    if (durationOfTheInsurance == 3) {
                        if ((municipality.equalsIgnoreCase(Constants.VARNA_MUNICIPALITY) && town.equalsIgnoreCase(Constants.VARNA_TOWN)) ||
                                (municipality.equalsIgnoreCase(Constants.PLOVDIV_MUNICIPALITY) && town.equalsIgnoreCase(Constants.PLOVDIV_TOWN)) ||
                                (municipality.equalsIgnoreCase(Constants.SOFIA_CAPITAL) && town.equalsIgnoreCase(Constants.SOFIA_TOWN))
                                        && !client.getCarAccidents().equals(Constants.CAR_ACCIDENT_CONFIRMATION)) {
                            premium -= 6.12;
                        }
                        premium += 91.47;
                    }
                    premium += 46.28;
                } else {
                    if (durationOfTheInsurance == 1) {
                        if ((municipality.equalsIgnoreCase(Constants.VARNA_MUNICIPALITY) && town.equalsIgnoreCase(Constants.VARNA_TOWN)) ||
                                (municipality.equalsIgnoreCase(Constants.PLOVDIV_MUNICIPALITY) && town.equalsIgnoreCase(Constants.PLOVDIV_TOWN)) ||
                                (municipality.equalsIgnoreCase(Constants.SOFIA_CAPITAL) && town.equalsIgnoreCase(Constants.SOFIA_TOWN))
                                        && !client.getCarAccidents().equals(Constants.CAR_ACCIDENT_CONFIRMATION)) {
                            premium -= 4.33;
                        }
                        premium += 14.12;
                    }
                    if (durationOfTheInsurance == 2) {
                        if ((municipality.equalsIgnoreCase(Constants.VARNA_MUNICIPALITY) && town.equalsIgnoreCase(Constants.VARNA_TOWN)) ||
                                (municipality.equalsIgnoreCase(Constants.PLOVDIV_MUNICIPALITY) && town.equalsIgnoreCase(Constants.PLOVDIV_TOWN)) ||
                                (municipality.equalsIgnoreCase(Constants.SOFIA_CAPITAL) && town.equalsIgnoreCase(Constants.SOFIA_TOWN))
                                        && !client.getCarAccidents().equals(Constants.CAR_ACCIDENT_CONFIRMATION)) {
                            premium -= 3.12;
                        }
                        premium += 35.1;
                    }
                    if (durationOfTheInsurance == 3) {
                        if ((municipality.equalsIgnoreCase(Constants.VARNA_MUNICIPALITY) && town.equalsIgnoreCase(Constants.VARNA_TOWN)) ||
                                (municipality.equalsIgnoreCase(Constants.PLOVDIV_MUNICIPALITY) && town.equalsIgnoreCase(Constants.PLOVDIV_TOWN)) ||
                                (municipality.equalsIgnoreCase(Constants.SOFIA_CAPITAL) && town.equalsIgnoreCase(Constants.SOFIA_TOWN))
                                        && !client.getCarAccidents().equals(Constants.CAR_ACCIDENT_CONFIRMATION)) {
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
                        if ((municipality.equalsIgnoreCase(Constants.VARNA_MUNICIPALITY) && town.equalsIgnoreCase(Constants.VARNA_TOWN)) ||
                                (municipality.equalsIgnoreCase(Constants.PLOVDIV_MUNICIPALITY) && town.equalsIgnoreCase(Constants.PLOVDIV_TOWN)) ||
                                (municipality.equalsIgnoreCase(Constants.SOFIA_CAPITAL) && town.equalsIgnoreCase(Constants.SOFIA_TOWN))
                                        && !client.getCarAccidents().equals(Constants.CAR_ACCIDENT_CONFIRMATION)) {
                            premium -= 7.74;
                        }
                    }
                    if (durationOfTheInsurance == 1) {
                        if ((municipality.equalsIgnoreCase(Constants.VARNA_MUNICIPALITY) && town.equalsIgnoreCase(Constants.VARNA_TOWN)) ||
                                (municipality.equalsIgnoreCase(Constants.PLOVDIV_MUNICIPALITY) && town.equalsIgnoreCase(Constants.PLOVDIV_TOWN)) ||
                                (municipality.equalsIgnoreCase(Constants.SOFIA_CAPITAL) && town.equalsIgnoreCase(Constants.SOFIA_TOWN))
                                        && !client.getCarAccidents().equals(Constants.CAR_ACCIDENT_CONFIRMATION)) {
                            premium -= 10.16;
                        }
                        premium += 32.94;
                    }
                    if (durationOfTheInsurance == 2) {
                        if ((municipality.equalsIgnoreCase(Constants.VARNA_MUNICIPALITY) && town.equalsIgnoreCase(Constants.VARNA_TOWN)) ||
                                (municipality.equalsIgnoreCase(Constants.PLOVDIV_MUNICIPALITY) && town.equalsIgnoreCase(Constants.PLOVDIV_TOWN)) ||
                                (municipality.equalsIgnoreCase(Constants.SOFIA_CAPITAL) && town.equalsIgnoreCase(Constants.SOFIA_TOWN))
                                        && !client.getCarAccidents().equals(Constants.CAR_ACCIDENT_CONFIRMATION)) {
                            premium -= 12.24;
                        }
                        premium += 56.85;
                    }
                    if (durationOfTheInsurance == 3) {
                        if ((municipality.equalsIgnoreCase(Constants.VARNA_MUNICIPALITY) && town.equalsIgnoreCase(Constants.VARNA_TOWN)) ||
                                (municipality.equalsIgnoreCase(Constants.PLOVDIV_MUNICIPALITY) && town.equalsIgnoreCase(Constants.PLOVDIV_TOWN)) ||
                                (municipality.equalsIgnoreCase(Constants.SOFIA_CAPITAL) && town.equalsIgnoreCase(Constants.SOFIA_TOWN))
                                        && !client.getCarAccidents().equals(Constants.CAR_ACCIDENT_CONFIRMATION)) {
                            premium -= 16.32;
                        }
                        premium += 104.58;
                    }
                    premium += 99.26;
                } else if (specialUsage) {
                    if (durationOfTheInsurance == 0) {
                        if ((municipality.equalsIgnoreCase(Constants.VARNA_MUNICIPALITY) && town.equalsIgnoreCase(Constants.VARNA_TOWN)) ||
                                (municipality.equalsIgnoreCase(Constants.PLOVDIV_MUNICIPALITY) && town.equalsIgnoreCase(Constants.PLOVDIV_TOWN)) ||
                                (municipality.equalsIgnoreCase(Constants.SOFIA_CAPITAL) && town.equalsIgnoreCase(Constants.SOFIA_TOWN))
                                        && !client.getCarAccidents().equals(Constants.CAR_ACCIDENT_CONFIRMATION)) {
                            premium -= 21.93;
                        }
                    }
                    if (durationOfTheInsurance == 1) {
                        if ((municipality.equalsIgnoreCase(Constants.VARNA_MUNICIPALITY) && town.equalsIgnoreCase(Constants.VARNA_TOWN)) ||
                                (municipality.equalsIgnoreCase(Constants.PLOVDIV_MUNICIPALITY) && town.equalsIgnoreCase(Constants.PLOVDIV_TOWN)) ||
                                (municipality.equalsIgnoreCase(Constants.SOFIA_CAPITAL) && town.equalsIgnoreCase(Constants.SOFIA_TOWN))
                                        && !client.getCarAccidents().equals(Constants.CAR_ACCIDENT_CONFIRMATION)) {
                            premium -= 24.48;
                        }
                        premium += 33.08;
                    }
                    if (durationOfTheInsurance == 2) {
                        if ((municipality.equalsIgnoreCase(Constants.VARNA_MUNICIPALITY) && town.equalsIgnoreCase(Constants.VARNA_TOWN)) ||
                                (municipality.equalsIgnoreCase(Constants.PLOVDIV_MUNICIPALITY) && town.equalsIgnoreCase(Constants.PLOVDIV_TOWN)) ||
                                (municipality.equalsIgnoreCase(Constants.SOFIA_CAPITAL) && town.equalsIgnoreCase(Constants.SOFIA_TOWN))
                                        && !client.getCarAccidents().equals(Constants.CAR_ACCIDENT_CONFIRMATION)) {
                            premium -= 26.52;
                        }
                        premium += 56.94;
                    }
                    if (durationOfTheInsurance == 3) {
                        if ((municipality.equalsIgnoreCase(Constants.VARNA_MUNICIPALITY) && town.equalsIgnoreCase(Constants.VARNA_TOWN)) ||
                                (municipality.equalsIgnoreCase(Constants.PLOVDIV_MUNICIPALITY) && town.equalsIgnoreCase(Constants.PLOVDIV_TOWN)) ||
                                (municipality.equalsIgnoreCase(Constants.SOFIA_CAPITAL) && town.equalsIgnoreCase(Constants.SOFIA_TOWN))
                                        && !client.getCarAccidents().equals(Constants.CAR_ACCIDENT_CONFIRMATION)) {
                            premium -= 30.6;
                        }
                        premium += 104.68;
                    }
                    premium += 266.24;
                } else if (usage == 5) {
                    if (durationOfTheInsurance == 0) {
                        if ((municipality.equalsIgnoreCase(Constants.VARNA_MUNICIPALITY) && town.equalsIgnoreCase(Constants.VARNA_TOWN)) ||
                                (municipality.equalsIgnoreCase(Constants.PLOVDIV_MUNICIPALITY) && town.equalsIgnoreCase(Constants.PLOVDIV_TOWN)) ||
                                (municipality.equalsIgnoreCase(Constants.SOFIA_CAPITAL) && town.equalsIgnoreCase(Constants.SOFIA_TOWN))
                                        && !client.getCarAccidents().equals(Constants.CAR_ACCIDENT_CONFIRMATION)) {
                            premium -= 5.87;
                        }
                    }
                    if (durationOfTheInsurance == 1) {
                        if ((municipality.equalsIgnoreCase(Constants.VARNA_MUNICIPALITY) && town.equalsIgnoreCase(Constants.VARNA_TOWN)) ||
                                (municipality.equalsIgnoreCase(Constants.PLOVDIV_MUNICIPALITY) && town.equalsIgnoreCase(Constants.PLOVDIV_TOWN)) ||
                                (municipality.equalsIgnoreCase(Constants.SOFIA_CAPITAL) && town.equalsIgnoreCase(Constants.SOFIA_TOWN))
                                        && !client.getCarAccidents().equals(Constants.CAR_ACCIDENT_CONFIRMATION)) {
                            premium -= 6.12;
                        }
                        premium += 33.22;
                    }
                    if (durationOfTheInsurance == 2) {
                        if ((municipality.equalsIgnoreCase(Constants.VARNA_MUNICIPALITY) && town.equalsIgnoreCase(Constants.VARNA_TOWN)) ||
                                (municipality.equalsIgnoreCase(Constants.PLOVDIV_MUNICIPALITY) && town.equalsIgnoreCase(Constants.PLOVDIV_TOWN)) ||
                                (municipality.equalsIgnoreCase(Constants.SOFIA_CAPITAL) && town.equalsIgnoreCase(Constants.SOFIA_TOWN))
                                        && !client.getCarAccidents().equals(Constants.CAR_ACCIDENT_CONFIRMATION)) {
                            premium -= 8.11;
                        }
                        premium += 57.09;
                    }
                    if (durationOfTheInsurance == 3) {
                        if ((municipality.equalsIgnoreCase(Constants.VARNA_MUNICIPALITY) && town.equalsIgnoreCase(Constants.VARNA_TOWN)) ||
                                (municipality.equalsIgnoreCase(Constants.PLOVDIV_MUNICIPALITY) && town.equalsIgnoreCase(Constants.PLOVDIV_TOWN)) ||
                                (municipality.equalsIgnoreCase(Constants.SOFIA_CAPITAL) && town.equalsIgnoreCase(Constants.SOFIA_TOWN))
                                        && !client.getCarAccidents().equals(Constants.CAR_ACCIDENT_CONFIRMATION)) {
                            premium -= 12.24;
                        }
                        premium += 104.83;
                    }
                    premium += 51.28;
                } else {
                    if (durationOfTheInsurance == 1) {
                        if ((municipality.equalsIgnoreCase(Constants.VARNA_MUNICIPALITY) && town.equalsIgnoreCase(Constants.VARNA_TOWN)) ||
                                (municipality.equalsIgnoreCase(Constants.PLOVDIV_MUNICIPALITY) && town.equalsIgnoreCase(Constants.PLOVDIV_TOWN)) ||
                                (municipality.equalsIgnoreCase(Constants.SOFIA_CAPITAL) && town.equalsIgnoreCase(Constants.SOFIA_TOWN))
                                        && !client.getCarAccidents().equals(Constants.CAR_ACCIDENT_CONFIRMATION)) {
                            premium -= 4.04;
                        }
                        premium += 20.32;
                    }
                    if (durationOfTheInsurance == 2) {
                        if ((municipality.equalsIgnoreCase(Constants.VARNA_MUNICIPALITY) && town.equalsIgnoreCase(Constants.VARNA_TOWN)) ||
                                (municipality.equalsIgnoreCase(Constants.PLOVDIV_MUNICIPALITY) && town.equalsIgnoreCase(Constants.PLOVDIV_TOWN)) ||
                                (municipality.equalsIgnoreCase(Constants.SOFIA_CAPITAL) && town.equalsIgnoreCase(Constants.SOFIA_TOWN))
                                        && !client.getCarAccidents().equals(Constants.CAR_ACCIDENT_CONFIRMATION)) {
                            premium -= 6.12;
                        }
                        premium += 44.22;
                    }
                    if (durationOfTheInsurance == 3) {
                        if ((municipality.equalsIgnoreCase(Constants.VARNA_MUNICIPALITY) && town.equalsIgnoreCase(Constants.VARNA_TOWN)) ||
                                (municipality.equalsIgnoreCase(Constants.PLOVDIV_MUNICIPALITY) && town.equalsIgnoreCase(Constants.PLOVDIV_TOWN)) ||
                                (municipality.equalsIgnoreCase(Constants.SOFIA_CAPITAL) && town.equalsIgnoreCase(Constants.SOFIA_TOWN))
                                        && !client.getCarAccidents().equals(Constants.CAR_ACCIDENT_CONFIRMATION)) {
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
                        if ((municipality.equalsIgnoreCase(Constants.VARNA_MUNICIPALITY) && town.equalsIgnoreCase(Constants.VARNA_TOWN)) ||
                                (municipality.equalsIgnoreCase(Constants.PLOVDIV_MUNICIPALITY) && town.equalsIgnoreCase(Constants.PLOVDIV_TOWN)) ||
                                (municipality.equalsIgnoreCase(Constants.SOFIA_CAPITAL) && town.equalsIgnoreCase(Constants.SOFIA_TOWN))
                                        && !client.getCarAccidents().equals(Constants.CAR_ACCIDENT_CONFIRMATION)) {
                            premium -= 7.68;
                        }
                    }
                    premium += 118.32;
                    if (durationOfTheInsurance == 1) {
                        if ((municipality.equalsIgnoreCase(Constants.VARNA_MUNICIPALITY) && town.equalsIgnoreCase(Constants.VARNA_TOWN)) ||
                                (municipality.equalsIgnoreCase(Constants.PLOVDIV_MUNICIPALITY) && town.equalsIgnoreCase(Constants.PLOVDIV_TOWN)) ||
                                (municipality.equalsIgnoreCase(Constants.SOFIA_CAPITAL) && town.equalsIgnoreCase(Constants.SOFIA_TOWN))
                                        && !client.getCarAccidents().equals(Constants.CAR_ACCIDENT_CONFIRMATION)) {
                            premium -= 10.2;
                        }
                        premium += 39.42;
                    }
                    if (durationOfTheInsurance == 2) {
                        if ((municipality.equalsIgnoreCase(Constants.VARNA_MUNICIPALITY) && town.equalsIgnoreCase(Constants.VARNA_TOWN)) ||
                                (municipality.equalsIgnoreCase(Constants.PLOVDIV_MUNICIPALITY) && town.equalsIgnoreCase(Constants.PLOVDIV_TOWN)) ||
                                (municipality.equalsIgnoreCase(Constants.SOFIA_CAPITAL) && town.equalsIgnoreCase(Constants.SOFIA_TOWN))
                                        && !client.getCarAccidents().equals(Constants.CAR_ACCIDENT_CONFIRMATION)) {
                            premium -= 12.24;
                        }
                        premium += 68.39;
                    }
                    if (durationOfTheInsurance == 3) {
                        if ((municipality.equalsIgnoreCase(Constants.VARNA_MUNICIPALITY) && town.equalsIgnoreCase(Constants.VARNA_TOWN)) ||
                                (municipality.equalsIgnoreCase(Constants.PLOVDIV_MUNICIPALITY) && town.equalsIgnoreCase(Constants.PLOVDIV_TOWN)) ||
                                (municipality.equalsIgnoreCase(Constants.SOFIA_CAPITAL) && town.equalsIgnoreCase(Constants.SOFIA_TOWN))
                                        && !client.getCarAccidents().equals(Constants.CAR_ACCIDENT_CONFIRMATION)) {
                            premium -= 16.32;
                        }
                        premium += 126.32;
                    }
                } else if (usage == 3 || usage == 6 || usage == 7 || usage == 8) {
                    if (durationOfTheInsurance == 0) {
                        if ((municipality.equalsIgnoreCase(Constants.VARNA_MUNICIPALITY) && town.equalsIgnoreCase(Constants.VARNA_TOWN)) ||
                                (municipality.equalsIgnoreCase(Constants.PLOVDIV_MUNICIPALITY) && town.equalsIgnoreCase(Constants.PLOVDIV_TOWN)) ||
                                (municipality.equalsIgnoreCase(Constants.SOFIA_CAPITAL) && town.equalsIgnoreCase(Constants.SOFIA_TOWN))
                                        && !client.getCarAccidents().equals(Constants.CAR_ACCIDENT_CONFIRMATION)) {
                            premium -= 25.66;
                        }
                    }
                    if (durationOfTheInsurance == 1) {
                        if ((municipality.equalsIgnoreCase(Constants.VARNA_MUNICIPALITY) && town.equalsIgnoreCase(Constants.VARNA_TOWN)) ||
                                (municipality.equalsIgnoreCase(Constants.PLOVDIV_MUNICIPALITY) && town.equalsIgnoreCase(Constants.PLOVDIV_TOWN)) ||
                                (municipality.equalsIgnoreCase(Constants.SOFIA_CAPITAL) && town.equalsIgnoreCase(Constants.SOFIA_TOWN))
                                        && !client.getCarAccidents().equals(Constants.CAR_ACCIDENT_CONFIRMATION)) {
                            premium -= 24.48;
                        }
                        premium += 35.72;
                    }
                    if (durationOfTheInsurance == 2) {
                        if ((municipality.equalsIgnoreCase(Constants.VARNA_MUNICIPALITY) && town.equalsIgnoreCase(Constants.VARNA_TOWN)) ||
                                (municipality.equalsIgnoreCase(Constants.PLOVDIV_MUNICIPALITY) && town.equalsIgnoreCase(Constants.PLOVDIV_TOWN)) ||
                                (municipality.equalsIgnoreCase(Constants.SOFIA_CAPITAL) && town.equalsIgnoreCase(Constants.SOFIA_TOWN))
                                        && !client.getCarAccidents().equals(Constants.CAR_ACCIDENT_CONFIRMATION)) {
                            premium -= 26.52;
                        }
                        premium += 64.68;
                    }
                    if (durationOfTheInsurance == 3) {
                        if ((municipality.equalsIgnoreCase(Constants.VARNA_MUNICIPALITY) && town.equalsIgnoreCase(Constants.VARNA_TOWN)) ||
                                (municipality.equalsIgnoreCase(Constants.PLOVDIV_MUNICIPALITY) && town.equalsIgnoreCase(Constants.PLOVDIV_TOWN)) ||
                                (municipality.equalsIgnoreCase(Constants.SOFIA_CAPITAL) && town.equalsIgnoreCase(Constants.SOFIA_TOWN))
                                        && !client.getCarAccidents().equals(Constants.CAR_ACCIDENT_CONFIRMATION)) {
                            premium -= 30.6;
                        }
                        premium += 122.62;
                    }
                    premium += 324.8;
                } else if (usage == 5) {
                    if (durationOfTheInsurance == 0) {
                        if ((municipality.equalsIgnoreCase(Constants.VARNA_MUNICIPALITY) && town.equalsIgnoreCase(Constants.VARNA_TOWN)) ||
                                (municipality.equalsIgnoreCase(Constants.PLOVDIV_MUNICIPALITY) && town.equalsIgnoreCase(Constants.PLOVDIV_TOWN)) ||
                                (municipality.equalsIgnoreCase(Constants.SOFIA_CAPITAL) && town.equalsIgnoreCase(Constants.SOFIA_TOWN))
                                        && !client.getCarAccidents().equals(Constants.CAR_ACCIDENT_CONFIRMATION)) {
                            premium -= 5.81;
                        }
                    }
                    if (durationOfTheInsurance == 1) {
                        if ((municipality.equalsIgnoreCase(Constants.VARNA_MUNICIPALITY) && town.equalsIgnoreCase(Constants.VARNA_TOWN)) ||
                                (municipality.equalsIgnoreCase(Constants.PLOVDIV_MUNICIPALITY) && town.equalsIgnoreCase(Constants.PLOVDIV_TOWN)) ||
                                (municipality.equalsIgnoreCase(Constants.SOFIA_CAPITAL) && town.equalsIgnoreCase(Constants.SOFIA_TOWN))
                                        && !client.getCarAccidents().equals(Constants.CAR_ACCIDENT_CONFIRMATION)) {
                            premium -= 7.12;
                        }
                        premium += 37.21;
                    }
                    if (durationOfTheInsurance == 2) {
                        if ((municipality.equalsIgnoreCase(Constants.VARNA_MUNICIPALITY) && town.equalsIgnoreCase(Constants.VARNA_TOWN)) ||
                                (municipality.equalsIgnoreCase(Constants.PLOVDIV_MUNICIPALITY) && town.equalsIgnoreCase(Constants.PLOVDIV_TOWN)) ||
                                (municipality.equalsIgnoreCase(Constants.SOFIA_CAPITAL) && town.equalsIgnoreCase(Constants.SOFIA_TOWN))
                                        && !client.getCarAccidents().equals(Constants.CAR_ACCIDENT_CONFIRMATION)) {
                            premium -= 9.16;
                        }
                        premium += 66.18;
                    }
                    if (durationOfTheInsurance == 3) {
                        if ((municipality.equalsIgnoreCase(Constants.VARNA_MUNICIPALITY) && town.equalsIgnoreCase(Constants.VARNA_TOWN)) ||
                                (municipality.equalsIgnoreCase(Constants.PLOVDIV_MUNICIPALITY) && town.equalsIgnoreCase(Constants.PLOVDIV_TOWN)) ||
                                (municipality.equalsIgnoreCase(Constants.SOFIA_CAPITAL) && town.equalsIgnoreCase(Constants.SOFIA_TOWN))
                                        && !client.getCarAccidents().equals(Constants.CAR_ACCIDENT_CONFIRMATION)) {
                            premium -= 12.23;
                        }
                        premium += 123.11;
                    }
                    premium += 63.59;
                } else {
                    if (durationOfTheInsurance == 1) {
                        if ((municipality.equalsIgnoreCase(Constants.VARNA_MUNICIPALITY) && town.equalsIgnoreCase(Constants.VARNA_TOWN)) ||
                                (municipality.equalsIgnoreCase(Constants.PLOVDIV_MUNICIPALITY) && town.equalsIgnoreCase(Constants.PLOVDIV_TOWN)) ||
                                (municipality.equalsIgnoreCase(Constants.SOFIA_CAPITAL) && town.equalsIgnoreCase(Constants.SOFIA_TOWN))
                                        && !client.getCarAccidents().equals(Constants.CAR_ACCIDENT_CONFIRMATION)) {
                            premium -= 4.08;
                        }
                        premium += 30.56;
                    }
                    if (durationOfTheInsurance == 2) {
                        if ((municipality.equalsIgnoreCase(Constants.VARNA_MUNICIPALITY) && town.equalsIgnoreCase(Constants.VARNA_TOWN)) ||
                                (municipality.equalsIgnoreCase(Constants.PLOVDIV_MUNICIPALITY) && town.equalsIgnoreCase(Constants.PLOVDIV_TOWN)) ||
                                (municipality.equalsIgnoreCase(Constants.SOFIA_CAPITAL) && town.equalsIgnoreCase(Constants.SOFIA_TOWN))
                                        && !client.getCarAccidents().equals(Constants.CAR_ACCIDENT_CONFIRMATION)) {
                            premium -= 6.12;
                        }
                        premium += 59.52;
                    }
                    if (durationOfTheInsurance == 3) {
                        if ((municipality.equalsIgnoreCase(Constants.VARNA_MUNICIPALITY) && town.equalsIgnoreCase(Constants.VARNA_TOWN)) ||
                                (municipality.equalsIgnoreCase(Constants.PLOVDIV_MUNICIPALITY) && town.equalsIgnoreCase(Constants.PLOVDIV_TOWN)) ||
                                (municipality.equalsIgnoreCase(Constants.SOFIA_CAPITAL) && town.equalsIgnoreCase(Constants.SOFIA_TOWN))
                                        && !client.getCarAccidents().equals(Constants.CAR_ACCIDENT_CONFIRMATION)) {
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
                            if ((municipality.equalsIgnoreCase(Constants.VARNA_MUNICIPALITY) && town.equalsIgnoreCase(Constants.VARNA_TOWN)) ||
                                    (municipality.equalsIgnoreCase(Constants.PLOVDIV_MUNICIPALITY) && town.equalsIgnoreCase(Constants.PLOVDIV_TOWN)) ||
                                    (municipality.equalsIgnoreCase(Constants.SOFIA_CAPITAL) && town.equalsIgnoreCase(Constants.SOFIA_TOWN))
                                            && !client.getCarAccidents().equals(Constants.CAR_ACCIDENT_CONFIRMATION)) {
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
        if (carAccidents.equals("Да")) {
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
}
