// INHERITANCE: PhysicalProduct extends Product
public class PhysicalProduct extends Product {
    private double shippingWeight; // in kg
    private static final double DISCOUNT_RATE = 0.05; // 5% discount

    public PhysicalProduct(int id, String name, double price, int stock, String category, double shippingWeight) {
        super(id, name, price, stock, category);
        this.shippingWeight = shippingWeight;
    }

    // Constructor without ID (for user input)
    public PhysicalProduct(String name, double price, int stock, String category, double shippingWeight) {
        super(0, name, price, stock, category); // ID will be set by ProductCatalog
        this.shippingWeight = shippingWeight;
    }

    public double getShippingWeight() { return shippingWeight; }

    public double getShippingCost() {
        return shippingWeight * 20; // Rs.20 per kg
    }

    // POLYMORPHISM: Own implementation of discount
    @Override
    public double getDiscountedPrice() {
        return getPrice() * (1 - DISCOUNT_RATE);
    }

    @Override
    public String getProductType() { return "Physical"; }

    @Override
    public String toString() {
        return super.toString() + String.format(" | Shipping: Rs.%.2f", getShippingCost());
    }
}
