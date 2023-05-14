package constraints.xor;

public class Customer {

    private String name;
    private RegularCustomer regularCustomer;
    private VIPCustomer vipCustomer;

    public Customer(String name) {
        setName(name);
    }

    public void setRegularCustomer(RegularCustomer regularCustomer) {
        if (regularCustomer == null) {
            throw new IllegalArgumentException("Null value cannot be set");
        }

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
