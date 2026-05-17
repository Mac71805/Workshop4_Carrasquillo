
import org.example.ContractFileManager;
import org.example.SalesContract;
import org.example.Vehicle;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ContractFileManagerTest {

    @Test
    void testFileSave() {


        ContractFileManager manager =
                new ContractFileManager();


        Vehicle vehicle = new Vehicle(
                15,
                2021,
                "BMW",
                "M340i",
                "Sedan",
                "Blue",
                18000,
                47000
        );


        SalesContract contract =
                new SalesContract(
                        "20260515",
                        "Mike",
                        "mike@email.com",
                        vehicle,
                        false
                );


        assertDoesNotThrow(() ->
                manager.saveContract(contract));
    }
}
