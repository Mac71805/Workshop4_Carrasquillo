package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DealershipFileManager {
    public Dealership getDealership() {

        Dealership dealership = null;

        try {

            BufferedReader bufferedReader =
                    new BufferedReader(
                            new FileReader("src/main/resources/inventory.csv"));

            // First line = dealership info
            String line = bufferedReader.readLine();

            String[] dealershipInfo = line.split("\\|");

            String name = dealershipInfo[0];
            String address = dealershipInfo[1];
            String phone = dealershipInfo[2];

            dealership = new Dealership(name, address, phone);

            // Read vehicles
            while ((line = bufferedReader.readLine()) != null) {

                String[] vehicleData = line.split("\\|");

                int vin = Integer.parseInt(vehicleData[0]);
                int year = Integer.parseInt(vehicleData[1]);
                String make = vehicleData[2];
                String model = vehicleData[3];
                String vehicleType = vehicleData[4];
                String color = vehicleData[5];
                int odometer = Integer.parseInt(vehicleData[6]);
                double price = Double.parseDouble(vehicleData[7]);

                Vehicle vehicle = new Vehicle(
                        vin,
                        year,
                        make,
                        model,
                        vehicleType,
                        color,
                        odometer,
                        price
                );

                dealership.addVehicle(vehicle);
            }

            bufferedReader.close();

        } catch (IOException ex) {
            System.out.println("Error reading file.");
            ex.printStackTrace();
        }

        return dealership;
    }

    public void saveDealership(Dealership dealership) {

    }
}
