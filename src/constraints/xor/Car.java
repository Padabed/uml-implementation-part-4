package constraints.xor;

public class Car {

    private int passengersNums;
    private Customer customer;

    public Car(int passengersNums) {
        setPassengersNums(passengersNums);
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
            customer.rentCar(this);
        }
        else if (this.customer != null && customer == null) {
            Customer c = this.customer;
            this.customer = null;
            c.returnCar();
        }
        else if (this.customer != null && customer != null) {
            Customer c = this.customer;
            this.customer = customer;
            customer.rentCar(this);
            c.returnCar();
        }
    }

    public void removeCustomer() {
        if (this.customer == null) {
            return;
        }
        if (this.customer != null && this.customer.getRentedCar() != this) {
            throw new IllegalArgumentException("Customer does not have this car");
        }
        Customer c = this.customer;
        this.customer = null;
        c.returnCar();
    }

    public int getPassengersNums() {
        return passengersNums;
    }

    public void setPassengersNums(int passengersNums) {
        if (passengersNums < 1) {
            throw new IllegalArgumentException("Value cannot be les or equals to zero");
        }
        this.passengersNums = passengersNums;
    }
}
