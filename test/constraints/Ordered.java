package constraints;

import constraints.ordered.Item;
import constraints.ordered.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;

public class Ordered {

    private Product product;

    @BeforeEach
    public void load() {
        product = new Product("product");

        product.addItem(new Item("item1", 1.0, new Product("product")));
        product.addItem(new Item("item2", 3.0 ,new Product("product")));
        product.addItem(new Item("item3", 8.0, new Product("product")));
        product.addItem(new Item("item4", 1.5, new Product("product")));
        product.addItem(new Item("item5", 1.9, new Product("product")));
        product.addItem(new Item("item6", 10.8, new Product("product")));
    }


    @Test
    public void test() {
        try {
            boolean firstLoop = true;
            double compare = 0;
            int counter = 0;
            for (Item i : product.getItems()) {
                if (firstLoop) {
                    compare = i.getPrice();
                    firstLoop = false;
                    counter++;
                    System.out.print("| ");
                    continue;
                }
                if (compare > i.getPrice()) {
                    throw new IllegalArgumentException("Set is not properly sorted");
                }
                compare = i.getPrice();
                counter++;
                System.out.print(i.getPrice() + " | ");
                if (counter == product.getItems().size()) {
                    System.out.println("\nSet is properly sorted");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }

}
