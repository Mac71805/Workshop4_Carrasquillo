package org.example;

import java.math.BigDecimal;
import java.math.RoundingMode;

    public class LeaseContract extends Contract {

        public LeaseContract(String date, String customerName, String customerEmail,
                             Vehicle vehicleSold) {

            super(date, customerName, customerEmail, vehicleSold);
        }

        @Override
        public BigDecimal getTotalPrice() {

            BigDecimal price =
                    BigDecimal.valueOf(getVehicleSold().getPrice());

            BigDecimal endingValue =
                    price.multiply(BigDecimal.valueOf(0.50));

            BigDecimal leaseFee =
                    price.multiply(BigDecimal.valueOf(0.07));

            return endingValue.add(leaseFee);
        }

        @Override
        public BigDecimal getMonthlyPayment() {

            return getTotalPrice().divide(
                    BigDecimal.valueOf(36),
                    2,
                    RoundingMode.HALF_UP
            );
        }
    }
