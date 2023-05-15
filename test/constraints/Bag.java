package constraints;

import constraints.bag.Customer;
import constraints.bag.Item;
import constraints.bag.Order;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.fail;

public class Bag {

    private Customer customer;
    private Item item;
    private Order order;
    private Order order1;

    @BeforeEach
    public void load() {
        customer = new Customer("Null", "Moon");
        item = new Item("Tank");
    }

    @Test
    public void test() {
        try {

            order = new Order(customer, item, 10);
            order1 = new Order(customer, item, 5);

            if (!order.equals(order1)) fail();

        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }

}
