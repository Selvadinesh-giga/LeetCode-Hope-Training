// Represents a product and its quantity in the cart
public class CartItem {
    private Product product;
    private int quantity;

    public CartItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() { return product; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public double getSubtotal() {
        return product.getDiscountedPrice() * quantity;
    }

    @Override
    public String toString() {
        return String.format("  %-30s x%d  = Rs.%.2f",
                product.getName(), quantity, getSubtotal());
    }
}
