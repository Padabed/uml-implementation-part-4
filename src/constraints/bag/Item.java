package constraints.bag;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Item {

    private String name;

    private List<Order> orders = new ArrayList<>();

    public Item(String name) {
        this.name = name;
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

    public List<Order> getOrders() {
        return Collections.unmodifiableList(orders);
    }

    public void addOrder(Order order) {
        if (order == null) {
            throw new IllegalArgumentException("Order cannot be a null value");
        }
        if (order.getItem() != this) {
            return;
        }
        this.orders.add(order);
    }
}
