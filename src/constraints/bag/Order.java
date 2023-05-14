package constraints.bag;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Order {

    private Customer customer;
    private Item item;

    private int quantity;

    public Order(Customer customer, Item item, int quantity) {
        setCustomer(customer);
        setItem(item);
        setQuantity(quantity);
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        if (customer == null) {
            throw new IllegalArgumentException("Customer cannot be a null value");
        }
        this.customer = customer;
        customer.addOrder(this);
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("Item cannot be a null value");
        }
        this.item = item;
        item.addOrder(this);
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        if (quantity < 1) {
            throw new IllegalArgumentException("Quantity cannot be less or equals to zero");
        }
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Order)) {
            return false;
        }
        Order other = (Order) o;
        return Objects.equals(item, other.item) && Objects.equals(customer, other.customer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customer, item);
    }

    @Override
    public String toString() {
        return "Order{" +
                "customer=" + customer +
                ", item=" + item +
                ", quantity=" + quantity +
                '}';
    }

}
