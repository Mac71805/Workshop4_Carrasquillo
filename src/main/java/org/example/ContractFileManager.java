package org.example;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

    public class ContractFileManager {

        public void saveContract(Contract contract) {

            try {

                BufferedWriter bufferedWriter = new BufferedWriter(
                        new FileWriter("src/main/resources/contracts.csv",
                                true));

                Vehicle vehicle = contract.getVehicleSold();


                if (contract instanceof SalesContract) {

                    SalesContract salesContract =
                            (SalesContract) contract;

                    double vehiclePrice = vehicle.getPrice();

                    double salesTax = vehiclePrice * 0.05;

                    double recordingFee = 100;

                    double processingFee;

                    if (vehiclePrice < 10000) {

                        processingFee = 295;

                    } else {

                        processingFee = 495;
                    }

                    String financed;

                    if (salesContract.isFinance()) {

                        financed = "YES";

                    } else {

                        financed = "NO";
                    }

                    String line =
                            "SALE|" +
                                    contract.getDate() + "|" +
                                    contract.getCustomerName() + "|" +
                                    contract.getCustomerEmail() + "|" +

                                    vehicle.getVin() + "|" +
                                    vehicle.getYear() + "|" +
                                    vehicle.getMake() + "|" +
                                    vehicle.getModel() + "|" +
                                    vehicle.getVehicleType() + "|" +
                                    vehicle.getColor() + "|" +
                                    vehicle.getOdometer() + "|" +
                                    vehicle.getPrice() + "|" +

                                    salesTax + "|" +
                                    recordingFee + "|" +
                                    processingFee + "|" +

                                    contract.getTotalPrice() + "|" +
                                    financed + "|" +
                                    contract.getMonthlyPayment();

                    bufferedWriter.write(line);

                    bufferedWriter.newLine();
                }


                else if (contract instanceof LeaseContract) {

                    double vehiclePrice = vehicle.getPrice();

                    double endingValue = vehiclePrice * 0.50;

                    double leaseFee = vehiclePrice * 0.07;

                    String line =
                            "LEASE|" +
                                    contract.getDate() + "|" +
                                    contract.getCustomerName() + "|" +
                                    contract.getCustomerEmail() + "|" +

                                    vehicle.getVin() + "|" +
                                    vehicle.getYear() + "|" +
                                    vehicle.getMake() + "|" +
                                    vehicle.getModel() + "|" +
                                    vehicle.getVehicleType() + "|" +
                                    vehicle.getColor() + "|" +
                                    vehicle.getOdometer() + "|" +
                                    vehicle.getPrice() + "|" +

                                    endingValue + "|" +
                                    leaseFee + "|" +

                                    contract.getTotalPrice() + "|" +
                                    contract.getMonthlyPayment();

                    bufferedWriter.write(line);

                    bufferedWriter.newLine();
                }

                bufferedWriter.close();

            } catch (IOException ex) {

                System.out.println("Error saving contract.");

                ex.printStackTrace();
            }
        }
    }
