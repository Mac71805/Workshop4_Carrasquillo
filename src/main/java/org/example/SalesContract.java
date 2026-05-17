package org.example;

import java.math.BigDecimal;
import java.math.RoundingMode;

    public class SalesContract extends Contract {

        private boolean finance;

        public SalesContract(String date, String customerName, String customerEmail, Vehicle vehicleSold,
                             boolean finance) {

            super(date, customerName, customerEmail, vehicleSold);

            this.finance = finance;
        }

        public boolean isFinance() {
            return finance;
        }

        public void setFinance(boolean finance) {
            this.finance = finance;
        }

        @Override
        public BigDecimal getTotalPrice() {

            BigDecimal price =
                    BigDecimal.valueOf(getVehicleSold().getPrice());

            BigDecimal salesTax =
                    price.multiply(BigDecimal.valueOf(0.05));

            BigDecimal recordingFee =
                    BigDecimal.valueOf(100);

            BigDecimal processingFee;

            if (price.compareTo(BigDecimal.valueOf(10000)) < 0) {

                processingFee = BigDecimal.valueOf(295);

            } else {

                processingFee = BigDecimal.valueOf(495);
            }

            return price
                    .add(salesTax)
                    .add(recordingFee)
                    .add(processingFee);
        }

        @Override
        public BigDecimal getMonthlyPayment() {

            if (!finance) {
                return BigDecimal.ZERO;
            }

            BigDecimal totalPrice = getTotalPrice();

            int months;

            if (totalPrice.compareTo(BigDecimal.valueOf(10000)) >= 0) {

                months = 48;

            } else {

                months = 24;
            }

            return totalPrice.divide(
                    BigDecimal.valueOf(months),
                    2,
                    RoundingMode.HALF_UP
            );
        }
    }
