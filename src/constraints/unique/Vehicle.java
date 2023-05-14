package constraints.unique;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Vehicle {

    private String plateNumber;
    private String insurance;
    private static Set<String> extent = new HashSet<>();

    public Vehicle(String plateNumber, String insurance) {
        setPlateNumber(plateNumber);
        setInsurance(insurance);
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        if (plateNumber == null || plateNumber.isBlank()) {
            throw new IllegalArgumentException("Plate number is required");
        }
        this.plateNumber = plateNumber;
    }

    public String getInsurance() {
        return insurance;
    }

    public void setInsurance(String insurance) {
        if (insurance == null || insurance.isBlank()) {
            throw new IllegalArgumentException("Insurance cannot be a null value");
        }
        if (extent.contains(insurance)) {
            throw new IllegalArgumentException("Same insurance already exists");
        }
        if (this.insurance != null) {
            extent.remove(this.insurance);
        }
        this.insurance = insurance;
        extent.add(insurance);
    }

    public static Set<String> getExtent() {
        return Collections.unmodifiableSet(extent);
    }

}
