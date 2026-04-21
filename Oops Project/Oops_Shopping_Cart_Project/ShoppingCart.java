import java.util.*;

public class ShoppingCart {
    private User user;
    private List<CartItem> items;
    private Discountable discount; // POLYMORPHISM: any Discountable type works

    public ShoppingCart(User user) {
        this.user = user;
        this.items = new ArrayList<>();
        this.discount = null;
    }

    // Add product to cart
    public void addProduct(Product product, int qty) {
        if (!product.isAvailable(qty)) {
            System.out.println("  ✗ Sorry! Insufficient stock for: " + product.getName());
            return;
        }
        // If already in cart, update quantity
        for (CartItem item : items) {
            if (item.getProduct().getId() == product.getId()) {
                item.setQuantity(item.getQuantity() + qty);
                System.out.println("  ✓ Updated quantity for: " + product.getName());
                return;
            }
        }
        items.add(new CartItem(product, qty));
        System.out.println("  ✓ Added to cart: " + product.getName());
    }

    // Remove product from cart
    public void removeProduct(int productId) {
        Iterator<CartItem> it = items.iterator();
        while (it.hasNext()) {
            CartItem item = it.next();
            if (item.getProduct().getId() == productId) {
                System.out.println("  ✓ Removed: " + item.getProduct().getName());
                it.remove();
                return;
            }
        }
        System.out.println("  ✗ Product not found in cart.");
    }

    // Apply a discount coupon
    public void applyDiscount(Discountable d) {
        this.discount = d;
        System.out.println("  ✓ Discount applied: " + d.getDiscountDescription());
    }

    // Calculate subtotal (before coupon)
    public double getSubtotal() {
        return items.stream().mapToDouble(CartItem::getSubtotal).sum();
    }

    // Calculate shipping (only for PhysicalProduct)
    public double getTotalShipping() {
        return items.stream()
                .filter(i -> i.getProduct() instanceof PhysicalProduct)
                .mapToDouble(i -> ((PhysicalProduct) i.getProduct()).getShippingCost() * i.getQuantity())
                .sum();
    }

    // Final total after coupon discount
    public double getFinalTotal() {
        double total = getSubtotal() + getTotalShipping();
        if (discount != null) {
            total = discount.applyDiscount(total);
        }
        return total;
    }

    // Display full cart summary
    public void displayCart() {
        System.out.println("\n╔══════════════════════════════════════════════════╗");
        System.out.println("        🛒 Shopping Cart — " + user.getName());
        System.out.println("╠══════════════════════════════════════════════════╣");
        if (items.isEmpty()) {
            System.out.println("  Cart is empty.");
        } else {
            for (CartItem item : items) {
                System.out.println(item);
            }
            System.out.println("──────────────────────────────────────────────────");
            System.out.printf("  Subtotal (after product discounts): Rs.%.2f%n", getSubtotal());
            System.out.printf("  Shipping charges:                   Rs.%.2f%n", getTotalShipping());
            if (discount != null) {
                System.out.println("  Coupon: " + discount.getDiscountDescription());
            }
            System.out.printf("  ✅ FINAL TOTAL:                      Rs.%.2f%n", getFinalTotal());
        }
        System.out.println("╚══════════════════════════════════════════════════╝\n");
    }

    public List<CartItem> getItems() { return items; }
    public User getUser() { return user; }
}
