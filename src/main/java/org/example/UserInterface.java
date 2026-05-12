package org.example;

import java.util.List;
import java.util.Scanner;

public class UserInterface {
    private Dealership dealership;

    Scanner scanner = new Scanner(System.in);

    public UserInterface() {

    }

    public void display() {

        init();

        int command;

        do {

            System.out.println("\n===== DEALERSHIP MENU =====");
            System.out.println("1 - Find vehicles within price range");
            System.out.println("2 - Find vehicles by make/model");
            System.out.println("3 - Find vehicles by year range");
            System.out.println("4 - Find vehicles by color");
            System.out.println("5 - Find vehicles by mileage range");
            System.out.println("6 - Find vehicles by type");
            System.out.println("7 - List ALL vehicles");
            System.out.println("8 - Add vehicle");
            System.out.println("9 - Remove vehicle");
            System.out.println("99 - Quit");

            System.out.print("Enter command: ");
            command = scanner.nextInt();

            switch (command) {

                case 1:
                    processGetByPriceRequest();
                    break;

                case 2:
                    processGetByMakeModelRequest();
                    break;

                case 3:
                    processGetByYearRequest();
                    break;

                case 4:
                    processGetByColorRequest();
                    break;

                case 5:
                    processGetByMileageRequest();
                    break;

                case 6:
                    processGetByVehicleTypeRequest();
                    break;

                case 7:
                    processGetAllVehiclesRequest();
                    break;

                case 8:
                    processAddVehicleRequest();
                    break;

                case 9:
                    processRemoveVehicleRequest();
                    break;

                case 99:
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Invalid command.");

            }

        } while (command != 99);
    }

    private void init() {

        DealershipFileManager fileManager =
                new DealershipFileManager();

        dealership = fileManager.getDealership();
    }

    private void displayVehicles(List<Vehicle> vehicles) {

        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle);
        }
    }

    public void processGetAllVehiclesRequest() {

        List<Vehicle> vehicles =
                dealership.getAllVehicles();

        displayVehicles(vehicles);
    }

    public void processGetByPriceRequest() {

    }

    public void processGetByMakeModelRequest() {

    }

    public void processGetByYearRequest() {

    }

    public void processGetByColorRequest() {

    }

    public void processGetByMileageRequest() {

    }

    public void processGetByVehicleTypeRequest() {

    }

    public void processAddVehicleRequest() {

    }

    public void processRemoveVehicleRequest() {

    }
}
