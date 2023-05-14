package constraints.subset;

public class Vehicle {

    private Garage garage;

    private String name;
    private int passengerNumbers;

    public Vehicle(String name, int passengerNumbers) {
        setName(name);
        setPassengerNumbers(passengerNumbers);
    }

    public Garage getGarage() {
        return garage;
    }

    public void setGarage(Garage garage) {
        if (garage != null && this.garage == garage) {
            return;
        }
        if (this.garage == null && garage == null) {
            return;
        }
        if (this.garage != null && garage == null) {
            if (this.garage.getAllVehicles().contains(this)) {
                this.garage.removeVehicle(this);
            }
            this.garage = null;
        }
        if (this.garage == null && garage != null) {
            this.garage = garage;
            garage.addVehicle(this);
        }
        if (this.garage != null && garage != null) {
            if (this.garage.getAllVehicles().contains(this)) {
                this.garage.removeVehicle(this);
            }
            this.garage = garage;
            garage.addVehicle(this);
        }
    }

    public void removeFromGarage() {
        if (this.garage == null) {
            throw new IllegalArgumentException("Vehicle is not in the garage");
        }
        if (!this.garage.getAllVehicles().contains(this)) {
            throw new IllegalArgumentException("Vehicle is not in the garage");
        }
        if (!this.garage.getAvailableVehicles().contains(this)) {
            throw new IllegalArgumentException("Vehicle was not yet returned");
        }
        Garage oldGarage = this.garage;
        this.garage = null;
        oldGarage.removeVehicle(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("name cannot be empty");
        }
        this.name = name;
    }

    public int getPassengerNumbers() {
        return passengerNumbers;
    }

    public void setPassengerNumbers(int passengerNumbers) {
        if (passengerNumbers < 1) {
            throw new IllegalArgumentException("Value cannot be less or equals to zero");
        }
        this.passengerNumbers = passengerNumbers;
    }
}
