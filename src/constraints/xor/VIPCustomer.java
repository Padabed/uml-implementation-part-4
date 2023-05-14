package constraints.xor;

public class VIPCustomer {

    private double discount;

    public VIPCustomer(double discount) {
        setDiscount(discount);
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        if (discount < 1) {
            throw new IllegalArgumentException("discount cannot be less that 1%");
        }
        this.discount = discount;
    }
}
