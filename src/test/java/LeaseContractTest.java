import org.example.LeaseContract;
import org.example.Vehicle;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;


class LeaseContractTest {

    @Test
    public void testGetTotalPrice() {

        Vehicle vehicle =
                new Vehicle(
                        222,
                        2024,
                        "Toyota",
                        "Camry",
                        "Sedan",
                        "White",
                        12000,
                        30000
                );

        LeaseContract contract =
                new LeaseContract(
                        "20260517",
                        "Jane Doe",
                        "jane@email.com",
                        vehicle
                );

        BigDecimal expected =
                BigDecimal.valueOf(17100.00);

        assertEquals(
                0,
                expected.compareTo(contract.getTotalPrice())
        );
    }

    @Test
    public void testMonthlyPayment() {

        Vehicle vehicle =
                new Vehicle(
                        222,
                        2024,
                        "Toyota",
                        "Camry",
                        "Sedan",
                        "White",
                        12000,
                        30000
                );

        LeaseContract contract =
                new LeaseContract(
                        "20260517",
                        "Jane Doe",
                        "jane@email.com",
                        vehicle
                );

        BigDecimal expected =
                BigDecimal.valueOf(475.00);

        assertEquals(
                0,
                expected.compareTo(contract.getMonthlyPayment())
        );
    }
}
