package constraints.ordered;

public class Item {

    private String name;
    private double price;

    private Product product;

    public Item(String name, double price, Product product) {
        setName(name);
        setPrice(price);
        setProduct(product);
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        if (this.product != null && this.product == product) {
            return;
        }
        if (this.product == null && product == null) {
            return;
        }
        if (this.product == null && product != null) {
            this.product = product;
            product.addItem(this);
        }
        else if (this.product != null && product == null) {
            this.product.removeItem(this);
            this.product = null;
        }
        else if (this.product != null && product != null) {
            this.product.removeItem(this);
            this.product = product;
            product.addItem(this);
        }
    }

    public void removeProduct(Product product) {
        if (this.product == null) {
            return;
        }
        if (product == null) {
            return;
        }
        this.product = null;
        product.removeItem(this);
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price <= 0) {
            throw new IllegalArgumentException("Price cannot be less or equals to zero");
        }
        this.price = price;
    }
}
