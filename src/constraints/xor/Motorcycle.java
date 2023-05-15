package constraints.xor;

public class Motorcycle {

    private int engineCapacity;
    private Customer customer;

    public Motorcycle(int engineCapacity) {
        setEngineCapacity(engineCapacity);
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        if (this.customer != null && this.customer == customer) {
            return;
        }
        if (this.customer == null && customer == null) {
            return;
        }
        if (this.customer == null && customer != null) {
            this.customer = customer;
            customer.rentMotorcycle(this);
        }
        else if (this.customer != null && customer == null) {
            Customer c = this.customer;
            this.customer = null;
            c.returnMotorcycle();
        }
        else if (this.customer != null && customer != null) {
            Customer c = this.customer;
            this.customer = customer;
            customer.rentMotorcycle(this);
            c.returnMotorcycle();
        }
    }

    public void removeCustomer() {
        if (this.customer == null) {
            return;
        }
        if (this.customer != null && this.customer.getRentedMotorcycle() != this) {
            throw new IllegalArgumentException("Customer does not have this car");
        }
        Customer c = this.customer;
        this.customer = null;
        c.returnMotorcycle();
    }

    public int getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(int engineCapacity) {
        if (engineCapacity < 1) {
            throw new IllegalArgumentException("Value cannot be less or equals to zero");
        }
        this.engineCapacity = engineCapacity;
    }
}
