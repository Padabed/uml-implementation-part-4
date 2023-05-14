package constraints.bag;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Customer {

    private String full_name;
    private String address;

    private List<Order> orders = new ArrayList<>();

    public Customer(String full_name, String address) {
        this.full_name = full_name;
        this.address = address;
    }

    public String getFullName() {
        return full_name;
    }

    public void setFullName(String full_name) {
        if (full_name == null || full_name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.full_name = full_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        if (address == null || address.isBlank()) {
            throw new IllegalArgumentException("Address cannot be empty");
        }
        this.address = address;
    }

    public List<Order> getOrders() {
        return Collections.unmodifiableList(orders);
    }

    public void addOrder(Order order) {
        if (order == null) {
            throw new IllegalArgumentException("Order cannot be a null value");
        }
        if (order.getCustomer() != this) {
            return;
        }
        this.orders.add(order);
    }

}
