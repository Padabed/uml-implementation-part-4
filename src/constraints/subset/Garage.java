package constraints.subset;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Garage {

    // available vehicles set is a subset of all vehicles
    private Set<Vehicle> allVehicles;
    private Set<Vehicle> availableVehicles;
    private String address;

    public Garage(String address) {
        setAddress(address);
        allVehicles = new HashSet<>();
        availableVehicles = new HashSet<>();
    }

    public void rentVehicle(Vehicle vehicle) {
        if (vehicle == null) {
            throw new IllegalArgumentException("Vehicle cannot be a null value");
        }
        if (!allVehicles.contains(vehicle)) {
            throw new IllegalArgumentException("Vehicle does not exists in the garage");
        }
        if (!availableVehicles.contains(vehicle)) {
            throw new IllegalArgumentException("Vehicle is not available");
        }
        availableVehicles.remove(vehicle);
    }

    public void returnVehicle(Vehicle vehicle) {
        if (vehicle == null) {
            throw new IllegalArgumentException("Vehicle cannot be a null value");
        }
        if (!allVehicles.contains(vehicle)) {
            throw new IllegalArgumentException("Vehicle is not from this garage");
        }
        if (availableVehicles.contains(vehicle)) {
            throw new IllegalArgumentException("Vehicle already in garage");
        }
        availableVehicles.add(vehicle);
    }

    public void addVehicle(Vehicle vehicle) {
        if (vehicle == null) {
            throw new IllegalArgumentException("Vehicle cannot be a null value");
        }
        if (allVehicles.contains(vehicle)) {
            throw new IllegalArgumentException("Vehicle already exists in the set");
        }
        if (vehicle.getGarage() != null && vehicle.getGarage() != this) {
            throw new IllegalArgumentException("Vehicle already has a garage");
        }
        vehicle.setGarage(this);
        allVehicles.add(vehicle);
        availableVehicles.add(vehicle);
    }

    public void removeVehicle(Vehicle vehicle) {
        if (vehicle == null) {
            throw new IllegalArgumentException("Vehicle cannot be a null value");
        }
        if (!allVehicles.contains(vehicle)) {
            throw new IllegalArgumentException("Vehicle does not exists in the garage");
        }
        if (!availableVehicles.contains(vehicle)) {
            throw new IllegalArgumentException("Vehicle was not yet returned");
        }
        allVehicles.remove(vehicle);
        availableVehicles.remove(vehicle);
        vehicle.setGarage(null);
    }

    public Set<Vehicle> getAllVehicles() {
        return Collections.unmodifiableSet(allVehicles);
    }

    public Set<Vehicle> getAvailableVehicles() {
        return Collections.unmodifiableSet(availableVehicles);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        if (address.isBlank()) {
            throw new IllegalArgumentException("Address cannot be blank");
        }
        this.address = address;
    }
}
