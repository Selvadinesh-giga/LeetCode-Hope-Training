// ABSTRACTION: Abstract class hiding internal complexity
public abstract class Product {
    private int id;
    private String name;
    private double price;
    private int stock;
    private String category;

    public Product(int id, String name, double price, int stock, String category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.category = category;
    }

    // ABSTRACTION: Subclasses must define how discount is applied
    public abstract double getDiscountedPrice();

    public abstract String getProductType();

    // ENCAPSULATION: Controlled access via getters/setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public void setPrice(double price) {
        if (price < 0) throw new IllegalArgumentException("Price cannot be negative.");
        this.price = price;
    }
    public int getStock() { return stock; }
    public void setStock(int stock) { this.stock = stock; }
    public String getCategory() { return category; }

    public boolean isAvailable(int qty) {
        return stock >= qty;
    }

    @Override
    public String toString() {
        return String.format("[%s] %s (ID:%d) - Rs.%.2f | Stock: %d | Category: %s",
                getProductType(), name, id, getDiscountedPrice(), stock, category);
    }
}
