package constraints.xor;

public class Customer {

    private String name;
    private Motorcycle rentedMotorcycle;
    private Car rentedCar;


    public Customer(String name) {
        setName(name);
    }

    public Car getRentedCar() {
        // can return a null value
        return rentedCar;
    }

    public void rentCar(Car car) {
        if (car == null) {
            throw new IllegalArgumentException("Car cannot be a null value");
        }
        if (rentedMotorcycle != null) {
            throw new IllegalArgumentException("Cannot rent a car while already having a rented motorcycle");
        }
        car.setCustomer(this);
        this.rentedCar = car;
    }

    public void returnCar() {
        if (rentedCar == null) {
            return;
        }
        rentedCar.setCustomer(null);
        rentedCar = null;
    }

    public Motorcycle getRentedMotorcycle() {
        // can return a null value
        return rentedMotorcycle;
    }

    public void rentMotorcycle(Motorcycle motorcycle) {
        if (motorcycle == null) {
            throw new IllegalArgumentException("Motorcycle cannot be a null value");
        }
        if (rentedCar != null) {
            throw new IllegalArgumentException("Customer has rented car");
        }
        if (this.rentedMotorcycle != null && this.rentedMotorcycle == motorcycle) {
            return;
        }
        this.rentedMotorcycle = motorcycle;
        motorcycle.setCustomer(this);
    }

    public void returnMotorcycle() {
        if (rentedMotorcycle == null) {
            return;
        }
        rentedMotorcycle.setCustomer(null);
        rentedMotorcycle = null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

}
