

import org.example.SalesContract;
import org.example.Vehicle;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;


class SalesContractTest {

    @Test
    public void testGetTotalPriceUnder10000() {

        Vehicle vehicle =
                new Vehicle(
                        101,
                        2020,
                        "Honda",
                        "Civic",
                        "Sedan",
                        "Black",
                        50000,
                        8000
                );

        SalesContract contract =
                new SalesContract(
                        "20260517",
                        "John Doe",
                        "john@email.com",
                        vehicle,
                        true
                );

        BigDecimal expected =
                BigDecimal.valueOf(8795.00);

        assertEquals(
                0,
                expected.compareTo(contract.getTotalPrice())
        );
    }

    @Test
    public void testMonthlyPaymentNoFinance() {

        Vehicle vehicle =
                new Vehicle(
                        101,
                        2020,
                        "Honda",
                        "Civic",
                        "Sedan",
                        "Black",
                        50000,
                        8000
                );

        SalesContract contract =
                new SalesContract(
                        "20260517",
                        "John Doe",
                        "john@email.com",
                        vehicle,
                        false
                );

        assertEquals(
                BigDecimal.ZERO,
                contract.getMonthlyPayment()
        );
    }
}