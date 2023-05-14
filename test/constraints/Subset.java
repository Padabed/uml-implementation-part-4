package constraints;

import constraints.subset.Garage;
import constraints.subset.Vehicle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;

public class Subset {

    private Vehicle v1;
    private Vehicle v2;
    private Garage garage;

    @BeforeEach
    public void load() {
        try {
            garage = new Garage("alaska 10 street");
            v1 = new Vehicle("1", 4);
            v2 = new Vehicle("2", 4);
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    public void test() {
        try {

            v1.setGarage(garage);
            garage.addVehicle(v2);

            garage.removeVehicle(v1);
            garage.removeVehicle(v2);

            if (garage.getAllVehicles().contains(v1) || v1.getGarage() != null) {
                fail();
            }

            if (garage.getAllVehicles().contains(v2) || v2.getGarage() != null) {
                fail();
            }

            garage.addVehicle(v1);
            garage.addVehicle(v2);
            v1.setGarage(garage);
            v1.removeFromGarage();
            v1.setGarage(garage);
            garage.rentVehicle(v1);
            garage.returnVehicle(v1);

            v1.removeFromGarage();

            if (garage.getAllVehicles().contains(v1) || v1.getGarage() != null) {
                fail();
            }

            v1.setGarage(null);
            if (v1.getGarage() != null) {
                fail();
            }

        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }

}
