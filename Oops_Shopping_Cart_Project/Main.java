public class Main {
    public static void main(String[] args) {

        System.out.println("╔══════════════════════════════════════════════════╗");
        System.out.println("     🛍️  Online Shopping Cart System — Java OOP     ");
        System.out.println("╚══════════════════════════════════════════════════╝");

        // ── 1. Create Users (ENCAPSULATION) ──────────────────────────────
        User user1 = new User(101, "Arjun Kumar", "arjun@email.com");
        User user2 = new User(102, "Priya Shah",  "priya@email.com");
        System.out.println("\n👤 Users Created:");
        System.out.println("  " + user1);
        System.out.println("  " + user2);

        // ── 2. Product Catalog (INHERITANCE + POLYMORPHISM) ───────────────
        ProductCatalog catalog = new ProductCatalog();
        catalog.displayAll();

        // ── 3. Filter by Category (POLYMORPHISM via streams) ─────────────
        System.out.println("🔍 Browsing by Category:");
        catalog.displayByCategory("Electronics");
        catalog.displayByCategory("Courses");

        // ── 4. Arjun's Cart ───────────────────────────────────────────────
        System.out.println("🛒 Arjun adds items to cart:");
        ShoppingCart cart1 = new ShoppingCart(user1);
        cart1.addProduct(catalog.getById(1), 1);  // Wireless Headphones (Physical)
        cart1.addProduct(catalog.getById(6), 1);  // Java Course (Digital)
        cart1.addProduct(catalog.getById(7), 2);  // OOP eBook x2 (Digital)
        cart1.addProduct(catalog.getById(1), 1);  // Add headphones again → qty update

        // Apply coupon discount (POLYMORPHISM: Discountable interface)
        CouponDiscount coupon1 = new CouponDiscount("SAVE15", 15);
        cart1.applyDiscount(coupon1);
        cart1.displayCart();

        // ── 5. Priya's Cart ───────────────────────────────────────────────
        System.out.println("🛒 Priya adds items to cart:");
        ShoppingCart cart2 = new ShoppingCart(user2);
        cart2.addProduct(catalog.getById(2), 1);  // Keyboard (Physical)
        cart2.addProduct(catalog.getById(4), 2);  // Clean Code x2 (Physical)
        cart2.addProduct(catalog.getById(8), 1);  // VS Code Theme (Digital)

        // Try adding out-of-stock quantity
        cart2.addProduct(catalog.getById(2), 100); // Should show stock warning

        // Remove an item
        System.out.println("\n  Priya removes the VS Code Theme:");
        cart2.removeProduct(8);

        // Apply different coupon
        CouponDiscount coupon2 = new CouponDiscount("TECH10", 10);
        cart2.applyDiscount(coupon2);
        cart2.displayCart();

        // ── 6. Search Feature ─────────────────────────────────────────────
        System.out.println("🔎 Search results for 'book':");
        catalog.search("book").forEach(System.out::println);

        // ── 7. OOP Concepts Summary ───────────────────────────────────────
        System.out.println("\n╔══════════════════════════════════════════════════╗");
        System.out.println("          📚 OOP Concepts Demonstrated             ");
        System.out.println("╠══════════════════════════════════════════════════╣");
        System.out.println("  ✅ Encapsulation  — Private fields in Product,   ");
        System.out.println("                      User, CartItem               ");
        System.out.println("  ✅ Inheritance    — PhysicalProduct &             ");
        System.out.println("                      DigitalProduct extend Product ");
        System.out.println("  ✅ Polymorphism   — getDiscountedPrice() behaves  ");
        System.out.println("                      differently per product type  ");
        System.out.println("  ✅ Abstraction    — Abstract Product class &      ");
        System.out.println("                      Discountable interface        ");
        System.out.println("╚══════════════════════════════════════════════════╝");
    }
}
