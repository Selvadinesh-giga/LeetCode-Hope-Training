// INHERITANCE: DigitalProduct extends Product
public class DigitalProduct extends Product {
    private String downloadUrl;
    private static final double DISCOUNT_RATE = 0.10; // 10% discount

    public DigitalProduct(int id, String name, double price, int stock, String category, String downloadUrl) {
        super(id, name, price, stock, category);
        this.downloadUrl = downloadUrl;
    }

    // Constructor without ID (for user input)
    public DigitalProduct(String name, double price, int stock, String category, String downloadUrl) {
        super(0, name, price, stock, category); // ID will be set by ProductCatalog
        this.downloadUrl = downloadUrl;
    }

    public String getDownloadUrl() { return downloadUrl; }

    // POLYMORPHISM: Digital products get higher discount, no shipping
    @Override
    public double getDiscountedPrice() {
        return getPrice() * (1 - DISCOUNT_RATE);
    }

    @Override
    public String getProductType() { return "Digital"; }

    @Override
    public String toString() {
        return super.toString() + " | No Shipping (Digital Download)";
    }
}
