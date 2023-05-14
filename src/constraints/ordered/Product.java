package constraints.ordered;

import java.util.*;

public class Product {

    private String name;

    private static Comparator<Item> comparator = Comparator.comparing(Item::getPrice);

    private Set<Item> items = new TreeSet<>(comparator);

    public Product(String name) {
        setName(name);
    }

    public Set<Item> getItems() {
        return Collections.unmodifiableSet(items);
    }

    public void addItem(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("Item cannot be a null value");
        }
        items.add(item);
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

