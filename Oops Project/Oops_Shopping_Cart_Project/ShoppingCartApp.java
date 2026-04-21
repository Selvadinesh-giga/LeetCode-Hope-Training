import java.util.*;

public class ShoppingCartApp {
    private Scanner scanner;
    private ProductCatalog catalog;
    private Map<Integer, User> users;
    private Map<Integer, ShoppingCart> carts;
    private int userIdCounter;
    private int cartIdCounter;

    public ShoppingCartApp() {
        this.scanner = new Scanner(System.in);
        this.catalog = new ProductCatalog();
        this.users = new HashMap<>();
        this.carts = new HashMap<>();
        this.userIdCounter = 1000;
        this.cartIdCounter = 1;
    }

    public static void main(String[] args) {
        ShoppingCartApp app = new ShoppingCartApp();
        app.run();
    }

    public void run() {
        printHeader();
        boolean running = true;

        while (running) {
            printMainMenu();
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    manageProducts();
                    break;
                case "2":
                    manageUsers();
                    break;
                case "3":
                    manageCarts();
                    break;
                case "4":
                    searchProducts();
                    break;
                case "5":
                    viewAllProducts();
                    break;
                case "6":
                    System.out.println("\n👋 Thank you for using Online Shopping Cart System!");
                    running = false;
                    break;
                default:
                    System.out.println("❌ Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }

    private void printHeader() {
        System.out.println("\n╔════════════════════════════════════════════════════╗");
        System.out.println("║   🛍️  ONLINE SHOPPING CART SYSTEM - JAVA OOP       ║");
        System.out.println("╚════════════════════════════════════════════════════╝");
    }

    private void printMainMenu() {
        System.out.println("\n┌────────────────────────────────────────────────────┐");
        System.out.println("│           MAIN MENU                                 │");
        System.out.println("├────────────────────────────────────────────────────┤");
        System.out.println("│ 1. Manage Products (Add/View)                      │");
        System.out.println("│ 2. Manage Users (Create/View)                      │");
        System.out.println("│ 3. Manage Shopping Carts                           │");
        System.out.println("│ 4. Search Products                                 │");
        System.out.println("│ 5. View All Products                               │");
        System.out.println("│ 6. Exit                                            │");
        System.out.println("└────────────────────────────────────────────────────┘");
        System.out.print("Select option: ");
    }

    // ======================== PRODUCT MANAGEMENT ========================
    private void manageProducts() {
        boolean managing = true;
        while (managing) {
            System.out.println("\n┌─ PRODUCT MANAGEMENT ─────────────────────────────┐");
            System.out.println("│ 1. Add Physical Product                          │");
            System.out.println("│ 2. Add Digital Product                           │");
            System.out.println("│ 3. View All Products                             │");
            System.out.println("│ 4. Back to Main Menu                             │");
            System.out.println("└──────────────────────────────────────────────────┘");
            System.out.print("Select option: ");

            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    addPhysicalProduct();
                    break;
                case "2":
                    addDigitalProduct();
                    break;
                case "3":
                    viewAllProducts();
                    break;
                case "4":
                    managing = false;
                    break;
                default:
                    System.out.println("❌ Invalid choice.");
            }
        }
    }

    private void addPhysicalProduct() {
        System.out.println("\n📦 ADD PHYSICAL PRODUCT");
        System.out.print("Product Name: ");
        String name = scanner.nextLine().trim();
        if (name.isEmpty()) {
            System.out.println("❌ Name cannot be empty.");
            return;
        }

        System.out.print("Price (Rs.): ");
        double price = getDoubleInput();
        if (price <= 0) {
            System.out.println("❌ Price must be positive.");
            return;
        }

        System.out.print("Stock Quantity: ");
        int stock = getIntInput();
        if (stock < 0) {
            System.out.println("❌ Stock cannot be negative.");
            return;
        }

        System.out.print("Category (e.g., Electronics, Books): ");
        String category = scanner.nextLine().trim();
        if (category.isEmpty()) {
            System.out.println("❌ Category cannot be empty.");
            return;
        }

        System.out.print("Shipping Weight (kg): ");
        double weight = getDoubleInput();
        if (weight <= 0) {
            System.out.println("❌ Weight must be positive.");
            return;
        }

        catalog.addProduct(new PhysicalProduct(name, price, stock, category, weight));
        System.out.println("✅ Physical product added successfully!");
    }

    private void addDigitalProduct() {
        System.out.println("\n💾 ADD DIGITAL PRODUCT");
        System.out.print("Product Name: ");
        String name = scanner.nextLine().trim();
        if (name.isEmpty()) {
            System.out.println("❌ Name cannot be empty.");
            return;
        }

        System.out.print("Price (Rs.): ");
        double price = getDoubleInput();
        if (price <= 0) {
            System.out.println("❌ Price must be positive.");
            return;
        }

        System.out.print("Stock Quantity: ");
        int stock = getIntInput();
        if (stock < 0) {
            System.out.println("❌ Stock cannot be negative.");
            return;
        }

        System.out.print("Category (e.g., Courses, eBooks, Software): ");
        String category = scanner.nextLine().trim();
        if (category.isEmpty()) {
            System.out.println("❌ Category cannot be empty.");
            return;
        }

        System.out.print("Download URL: ");
        String url = scanner.nextLine().trim();
        if (url.isEmpty()) {
            System.out.println("❌ URL cannot be empty.");
            return;
        }

        catalog.addProduct(new DigitalProduct(name, price, stock, category, url));
        System.out.println("✅ Digital product added successfully!");
    }

    private void viewAllProducts() {
        System.out.println("\n📋 ALL PRODUCTS");
        System.out.println("═".repeat(80));
        catalog.displayAll();
        System.out.println("═".repeat(80));
    }

    private void searchProducts() {
        System.out.print("\n🔎 Enter search keyword: ");
        String keyword = scanner.nextLine().trim();
        if (keyword.isEmpty()) {
            System.out.println("❌ Search keyword cannot be empty.");
            return;
        }

        List<Product> results = catalog.search(keyword);
        if (results.isEmpty()) {
            System.out.println("❌ No products found matching '" + keyword + "'");
        } else {
            System.out.println("\n🔍 Search Results for '" + keyword + "':");
            System.out.println("═".repeat(80));
            results.forEach(System.out::println);
            System.out.println("═".repeat(80));
        }
    }

    // ======================== USER MANAGEMENT ========================
    private void manageUsers() {
        boolean managing = true;
        while (managing) {
            System.out.println("\n┌─ USER MANAGEMENT ────────────────────────────────┐");
            System.out.println("│ 1. Create New User                               │");
            System.out.println("│ 2. View All Users                                │");
            System.out.println("│ 3. Back to Main Menu                             │");
            System.out.println("└──────────────────────────────────────────────────┘");
            System.out.print("Select option: ");

            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    createUser();
                    break;
                case "2":
                    viewUsers();
                    break;
                case "3":
                    managing = false;
                    break;
                default:
                    System.out.println("❌ Invalid choice.");
            }
        }
    }

    private void createUser() {
        System.out.println("\n👤 CREATE NEW USER");
        System.out.print("Full Name: ");
        String name = scanner.nextLine().trim();
        if (name.isEmpty()) {
            System.out.println("❌ Name cannot be empty.");
            return;
        }

        System.out.print("Email: ");
        String email = scanner.nextLine().trim();
        if (!email.contains("@")) {
            System.out.println("❌ Invalid email format.");
            return;
        }

        User user = new User(userIdCounter++, name, email);
        users.put(user.getUserId(), user);
        System.out.println("✅ User created successfully! ID: " + user.getUserId());
        System.out.println("   " + user);
    }

    private void viewUsers() {
        if (users.isEmpty()) {
            System.out.println("\n❌ No users created yet.");
            return;
        }

        System.out.println("\n👥 ALL USERS");
        System.out.println("═".repeat(80));
        users.values().forEach(user -> System.out.println("  " + user));
        System.out.println("═".repeat(80));
    }

    // ======================== CART MANAGEMENT ========================
    private void manageCarts() {
        if (users.isEmpty()) {
            System.out.println("\n❌ No users available. Please create users first.");
            return;
        }

        boolean managing = true;
        while (managing) {
            System.out.println("\n┌─ CART MANAGEMENT ────────────────────────────────┐");
            System.out.println("│ 1. Create New Cart                               │");
            System.out.println("│ 2. View Existing Cart                            │");
            System.out.println("│ 3. Add Item to Cart                              │");
            System.out.println("│ 4. Remove Item from Cart                         │");
            System.out.println("│ 5. Apply Discount Coupon                         │");
            System.out.println("│ 6. Back to Main Menu                             │");
            System.out.println("└──────────────────────────────────────────────────┘");
            System.out.print("Select option: ");

            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    createCart();
                    break;
                case "2":
                    viewCart();
                    break;
                case "3":
                    addItemToCart();
                    break;
                case "4":
                    removeItemFromCart();
                    break;
                case "5":
                    applyDiscount();
                    break;
                case "6":
                    managing = false;
                    break;
                default:
                    System.out.println("❌ Invalid choice.");
            }
        }
    }

    private void createCart() {
        System.out.println("\n🛒 CREATE NEW CART");
        displayUsers();

        System.out.print("Enter User ID: ");
        int userId = getIntInput();

        User user = users.get(userId);
        if (user == null) {
            System.out.println("❌ User not found.");
            return;
        }

        ShoppingCart cart = new ShoppingCart(user);
        int cartId = cartIdCounter++;
        carts.put(cartId, cart);
        System.out.println("✅ Cart created successfully! Cart ID: " + cartId);
    }

    private void viewCart() {
        if (carts.isEmpty()) {
            System.out.println("\n❌ No carts available.");
            return;
        }

        System.out.print("\nEnter Cart ID: ");
        int cartId = getIntInput();

        ShoppingCart cart = carts.get(cartId);
        if (cart == null) {
            System.out.println("❌ Cart not found.");
            return;
        }

        System.out.println();
        cart.displayCart();
    }

    private void addItemToCart() {
        if (carts.isEmpty()) {
            System.out.println("\n❌ No carts available.");
            return;
        }

        System.out.print("\nEnter Cart ID: ");
        int cartId = getIntInput();

        ShoppingCart cart = carts.get(cartId);
        if (cart == null) {
            System.out.println("❌ Cart not found.");
            return;
        }

        viewAllProducts();

        System.out.print("\nEnter Product ID: ");
        int productId = getIntInput();

        Product product = catalog.getById(productId);
        if (product == null) {
            System.out.println("❌ Product not found.");
            return;
        }

        System.out.print("Quantity: ");
        int quantity = getIntInput();
        if (quantity <= 0) {
            System.out.println("❌ Quantity must be positive.");
            return;
        }

        cart.addProduct(product, quantity);
    }

    private void removeItemFromCart() {
        if (carts.isEmpty()) {
            System.out.println("\n❌ No carts available.");
            return;
        }

        System.out.print("\nEnter Cart ID: ");
        int cartId = getIntInput();

        ShoppingCart cart = carts.get(cartId);
        if (cart == null) {
            System.out.println("❌ Cart not found.");
            return;
        }

        System.out.print("Enter Product ID to remove: ");
        int productId = getIntInput();

        cart.removeProduct(productId);
    }

    private void applyDiscount() {
        if (carts.isEmpty()) {
            System.out.println("\n❌ No carts available.");
            return;
        }

        System.out.print("\nEnter Cart ID: ");
        int cartId = getIntInput();

        ShoppingCart cart = carts.get(cartId);
        if (cart == null) {
            System.out.println("❌ Cart not found.");
            return;
        }

        System.out.print("Enter Coupon Code: ");
        String couponCode = scanner.nextLine().trim();
        if (couponCode.isEmpty()) {
            System.out.println("❌ Coupon code cannot be empty.");
            return;
        }

        System.out.print("Discount Percentage: ");
        int discount = getIntInput();
        if (discount < 0 || discount > 100) {
            System.out.println("❌ Discount must be between 0 and 100.");
            return;
        }

        CouponDiscount coupon = new CouponDiscount(couponCode, discount);
        cart.applyDiscount(coupon);
        System.out.println("✅ Coupon applied successfully!");
    }

    // ======================== HELPER METHODS ========================
    private void displayUsers() {
        System.out.println("\nAvailable Users:");
        System.out.println("─".repeat(80));
        if (users.isEmpty()) {
            System.out.println("No users available.");
        } else {
            users.values().forEach(user -> 
                System.out.println("  ID: " + user.getUserId() + " | " + user.getName() + " (" + user.getEmail() + ")")
            );
        }
        System.out.println("─".repeat(80));
    }

    private int getIntInput() {
        try {
            return Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("❌ Invalid input. Please enter a valid number.");
            return -1;
        }
    }

    private double getDoubleInput() {
        try {
            return Double.parseDouble(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("❌ Invalid input. Please enter a valid number.");
            return -1;
        }
    }
}
