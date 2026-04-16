╔════════════════════════════════════════════════════════════════════════════════╗
║                                                                                ║
║                   ONLINE SHOPPING CART SYSTEM - PROJECT REPORT                 ║
║                                                                                ║
║                         Java OOP Concepts Implementation                       ║
║                                                                                ║
╚════════════════════════════════════════════════════════════════════════════════╝

═══════════════════════════════════════════════════════════════════════════════════
1. PROJECT OVERVIEW
═══════════════════════════════════════════════════════════════════════════════════

Project Name: Online Shopping Cart System
Language: Java
Purpose: Demonstrate Object-Oriented Programming (OOP) concepts through a practical
         e-commerce shopping cart application
Version: 1.0
Date: April 2026

DESCRIPTION:
This is an interactive command-line application that simulates a complete online
shopping system. Users can create accounts, browse products (physical and digital),
add items to shopping carts, apply discount coupons, and calculate final totals
with taxes and shipping costs.

═══════════════════════════════════════════════════════════════════════════════════
2. KEY FEATURES
═══════════════════════════════════════════════════════════════════════════════════

✓ User Management
  - Create new user accounts with ID, name, and email
  - View all registered users
  - Input validation for email format

✓ Product Management
  - Add Physical Products (with shipping costs)
  - Add Digital Products (downloadable, no shipping)
  - View all products with detailed information
  - Auto-generated Product IDs
  - Stock availability tracking

✓ Shopping Cart
  - Create multiple shopping carts per user
  - Add/remove products with quantity management
  - Automatic quantity update if product already in cart
  - Stock availability validation

✓ Discount System
  - Apply coupon-based discounts
  - Supports multiple discount types
  - Percentage-based discount calculation

✓ Search Functionality
  - Search products by name/keyword
  - Case-insensitive search

✓ Professional UI
  - Menu-driven interface
  - Input validation with error messages
  - Formatted output with ASCII borders
  - Color-coded feedback (✓ success, ✗ error)

═══════════════════════════════════════════════════════════════════════════════════
3. OOP CONCEPTS DEMONSTRATED
═══════════════════════════════════════════════════════════════════════════════════

A. ENCAPSULATION (Data Hiding)
   ──────────────────────────────
   Classes: Product, User, CartItem, ShoppingCart
   
   Implementation:
   - All fields are PRIVATE with controlled access via public getter/setter methods
   - Example: Product class has private fields (id, name, price, stock, category)
   - Getters/Setters provide validation before allowing changes
   - Price cannot be set to negative values
   
   Benefits:
   - Data security and integrity
   - Controlled access to internal state
   - Easy to modify internal implementation without affecting external code

─────────────────────────────────────────────────────────────────────────────────

B. INHERITANCE (Code Reuse)
   ──────────────────────────
   Base Class: Product (Abstract)
   Derived Classes: PhysicalProduct, DigitalProduct
   
   Implementation:
   - PhysicalProduct extends Product
     * Adds shippingWeight attribute
     * Implements getShippingCost() = weight * 20 Rs/kg
     * 5% discount rate
   
   - DigitalProduct extends Product
     * Adds downloadUrl attribute
     * No shipping costs
     * 10% discount rate
   
   Benefits:
   - Code reuse (common properties in base class)
   - Avoid duplication
   - Easier maintenance

─────────────────────────────────────────────────────────────────────────────────

C. POLYMORPHISM (Runtime Behavior)
   ────────────────────────────────
   Abstract Method: getDiscountedPrice()
   
   Implementation:
   - Product is abstract with abstract method getDiscountedPrice()
   - PhysicalProduct: price * (1 - 0.05) = 5% discount
   - DigitalProduct: price * (1 - 0.10) = 10% discount
   
   polymorphic behavior:
   - Discountable interface with applyDiscount() method
   - CouponDiscount class implements Discountable
   - ShoppingCart uses Discountable type (any implementation works)
   - Method overriding: getProductType(), toString()
   
   Benefits:
   - Same code works with different product types
   - Easy to add new product types without modifying existing code
   - Flexible discount system

─────────────────────────────────────────────────────────────────────────────────

D. ABSTRACTION (Interface/Contract)
   ────────────────────────────────
   Abstraction through:
   1. Abstract Class: Product
      - Hides complexity of individual product implementations
      - Defines contract for subclasses
      
   2. Interface: Discountable
      - Defines contract: applyDiscount(), getDiscountDescription()
      - CouponDiscount implements this interface
      - ShoppingCart depends on interface, not concrete class

   Benefits:
   - Simplifies code complexity
   - Loose coupling between classes
   - Easy to extend functionality

═══════════════════════════════════════════════════════════════════════════════════
4. CLASS ARCHITECTURE
═══════════════════════════════════════════════════════════════════════════════════

┌─────────────────────────────────────────────────────────────────────────────────┐
│                            CLASS RELATIONSHIP DIAGRAM                           │
└─────────────────────────────────────────────────────────────────────────────────┘

                          ┌─────────────────┐
                          │   ShoppingCartApp │  (Main Entry Point)
                          │ - Interactive UI │
                          │ - Manageusers    │
                          │ - Manage Carts   │
                          │ - Manage Products│
                          └────────┬─────────┘
                                   │
                    ┌──────────────┼──────────────┐
                    ▼              ▼              ▼
            ┌──────────────┐ ┌──────────┐ ┌─────────────┐
            │  ProductCatalog  │ │  User       │ │ ShoppingCart  │
            │ + List<Product>  │ │ + userId   │ │ + User        │
            │ + addProduct()   │ │ + name     │ │ + CartItems   │
            │ + search()       │ │ + email    │ │ + Discount    │
            └──────────────┘ └──────────┘ └─────────────┘
                    │                           │
                    ▼                           ▼
            ┌──────────────┐          ┌─────────────────┐
            │   Product        │          │   CartItem      │
            │  (Abstract)      │          │ + product       │
            │ + id, name       │          │ + quantity      │
            │ + price, stock   │          └─────────────────┘
            └────┬─────────────┘
                 │
        ┌────────┴─────────┐
        ▼                  ▼
    ┌──────────────┐  ┌──────────────┐
    │PhysicalProduct│  │DigitalProduct│
    │+ weight      │  │+ downloadUrl │
    │+ shipping()  │  │+ no shipping │
    └──────────────┘  └──────────────┘

                  ┌──────────────┐
                  │ Discountable  │ (Interface)
                  │+ applyDiscount()
                  └──────┬───────┘
                         │
                         ▼
                  ┌──────────────┐
                  │CouponDiscount│
                  │+ couponCode  │
                  │+ discount%   │
                  └──────────────┘

═══════════════════════════════════════════════════════════════════════════════════
5. CLASS DESCRIPTIONS
═══════════════════════════════════════════════════════════════════════════════════

FILE: Product.java
   Type: Abstract Class
   Purpose: Base class for all products
   Properties:
      - id: int
      - name: String
      - price: double
      - stock: int
      - category: String
   Methods:
      - abstract getDiscountedPrice(): double
      - abstract getProductType(): String
      - isAvailable(qty): boolean
      - getId(), getName(), getPrice(), getStock(), getCategory()
      - setPrice(), setStock(), setId()

──────────────────────────────────────────────────────────────────────────────────

FILE: PhysicalProduct.java
   Type: Concrete Class (extends Product)
   Purpose: Represents tangible products with shipping
   Additional Properties:
      - shippingWeight: double (in kg)
      - DISCOUNT_RATE: 5%
   Additional Methods:
      - getShippingWeight()
      - getShippingCost(): returns weight * 20
      - override getDiscountedPrice(): price * 0.95
      - override getProductType(): "Physical"

──────────────────────────────────────────────────────────────────────────────────

FILE: DigitalProduct.java
   Type: Concrete Class (extends Product)
   Purpose: Represents downloadable digital products
   Additional Properties:
      - downloadUrl: String
      - DISCOUNT_RATE: 10%
   Additional Methods:
      - getDownloadUrl()
      - override getDiscountedPrice(): price * 0.90
      - override getProductType(): "Digital"

──────────────────────────────────────────────────────────────────────────────────

FILE: User.java
   Type: Concrete Class
   Purpose: Represents system users
   Properties:
      - userId: int
      - name: String
      - email: String
   Methods:
      - getUserId(), getName(), getEmail()

──────────────────────────────────────────────────────────────────────────────────

FILE: CartItem.java
   Type: Concrete Class
   Purpose: Represents a product line item in a shopping cart
   Properties:
      - product: Product
      - quantity: int
   Methods:
      - getProduct(), getQuantity()
      - setQuantity()
      - getTotalPrice()

──────────────────────────────────────────────────────────────────────────────────

FILE: ShoppingCart.java
   Type: Concrete Class
   Purpose: Manages user's shopping cart
   Properties:
      - user: User
      - items: List<CartItem>
      - discount: Discountable
   Key Methods:
      - addProduct(Product, qty): adds or updates product
      - removeProduct(productId): removes item
      - applyDiscount(Discountable): applies discount coupon
      - displayCart(): shows formatted cart contents
      - calculateTotal(): computes final amount

──────────────────────────────────────────────────────────────────────────────────

FILE: Discountable.java
   Type: Interface
   Purpose: Contract for discount implementations
   Methods:
      - applyDiscount(originalPrice): double
      - getDiscountDescription(): String

──────────────────────────────────────────────────────────────────────────────────

FILE: CouponDiscount.java
   Type: Concrete Class (implements Discountable)
   Purpose: Represents percentage-based coupon discounts
   Properties:
      - couponCode: String
      - discountPercentage: int
   Methods:
      - override applyDiscount(price): returns price * (1 - percentage/100)
      - override getDiscountDescription()

──────────────────────────────────────────────────────────────────────────────────

FILE: ProductCatalog.java
   Type: Concrete Class
   Purpose: Manages product inventory
   Properties:
      - products: List<Product>
      - nextProductId: int
   Key Methods:
      - addProduct(Product): adds new product with auto ID
      - getById(id): retrieves product by ID
      - search(keyword): searches by name
      - displayAll(): shows all products
      - displayByCategory(category): filters by category

──────────────────────────────────────────────────────────────────────────────────

FILE: ShoppingCartApp.java
   Type: Concrete Class
   Purpose: Main application - Interactive menu interface
   Properties:
      - scanner: Scanner (for user input)
      - catalog: ProductCatalog
      - users: Map<Integer, User>
      - carts: Map<Integer, ShoppingCart>
      - userIdCounter, cartIdCounter
   Key Methods:
      - main(): entry point
      - run(): main application loop
      - manageProducts(), manageUsers(), manageCarts()
      - createUser(), createCart(), addItemToCart()
      - searchProducts(), viewAllProducts()
      - printHeader(), printMainMenu()

═══════════════════════════════════════════════════════════════════════════════════
6. FILE STRUCTURE
═══════════════════════════════════════════════════════════════════════════════════

files/
├── Product.java              - Abstract base class for all products
├── PhysicalProduct.java      - Concrete physical product class
├── DigitalProduct.java       - Concrete digital product class
├── User.java                 - User/customer class
├── CartItem.java             - Cart line item class
├── ShoppingCart.java         - Shopping cart container class
├── Discountable.java         - Discount interface
├── CouponDiscount.java       - Coupon discount implementation
├── ProductCatalog.java       - Product inventory management
├── ShoppingCartApp.java      - Main interactive application
├── Main.java                 - (Deprecated - hardcoded demo)
└── *.class files             - Compiled bytecode (generated after compilation)

═══════════════════════════════════════════════════════════════════════════════════
7. HOW TO USE
═══════════════════════════════════════════════════════════════════════════════════

COMPILATION:
   cd c:\Users\selva\NOTES\pro\files
   javac -encoding UTF-8 *.java

EXECUTION:
   cd c:\Users\selva\NOTES\pro\files
   java ShoppingCartApp

WORKFLOW:
   1. Start the application → Main Menu appears
   2. Manage Products (Option 1)
      - Add Physical Product: Enter name, price, quantity, category, weight
      - Add Digital Product: Enter name, price, quantity, category, download URL
      - View All Products: See entire catalog
      
   3. Manage Users (Option 2)
      - Create New User: Enter name and email
      - View All Users: See registered users
      
   4. Manage Shopping Carts (Option 3)
      - Create New Cart: Select user for whom to create cart
      - View Existing Cart: View cart contents and totals
      - Add Item to Cart: Select product and quantity
      - Remove Item from Cart: Remove specific product
      - Apply Discount Coupon: Add percentage discount
      
   5. Search Products (Option 4)
      - Search by keyword
      
   6. View All Products (Option 5)
      - Display complete catalog
      
   7. Exit (Option 6)

═══════════════════════════════════════════════════════════════════════════════════
8. SAMPLE OUTPUT
═══════════════════════════════════════════════════════════════════════════════════

╔════════════════════════════════════════════════════╗
║   🛍️  ONLINE SHOPPING CART SYSTEM - JAVA OOP       ║
╚════════════════════════════════════════════════════╝

┌────────────────────────────────────────────────────┐
│           MAIN MENU                                 │
├────────────────────────────────────────────────────┤
│ 1. Manage Products (Add/View)                      │
│ 2. Manage Users (Create/View)                      │
│ 3. Manage Shopping Carts                           │
│ 4. Search Products                                 │
│ 5. View All Products                               │
│ 6. Exit                                            │
└────────────────────────────────────────────────────┘

✅ Product added successfully!
✅ User created successfully! ID: 1000
✅ Coupon applied successfully!

═══════════════════════════════════════════════════════════════════════════════════
9. TECHNICAL DETAILS
═══════════════════════════════════════════════════════════════════════════════════

Language Version: Java (Any recent version)
Compilation: UTF-8 encoding for special characters
Dependencies: None (Pure Java, uses only java.util package)
Platform: Cross-platform (Windows, Linux, macOS)

Data Types Used:
- String: Names, emails, categories, URLs, coupon codes
- int: IDs, quantities, discount percentages, stock
- double: Prices, weights, shipping costs

Collections Used:
- ArrayList<Product>: Product inventory
- ArrayList<CartItem>: Cart items
- HashMap<Integer, User>: User mapping
- HashMap<Integer, ShoppingCart>: Cart mapping
- Iterator: For safe deletion during iteration

Input Validation:
- Name/email validation (non-empty, email format)
- Price validation (must be positive)
- Quantity validation (must be positive, check stock)
- Numeric input validation (try-catch for NumberFormatException)

═══════════════════════════════════════════════════════════════════════════════════
10. DESIGN PATTERNS USED
═══════════════════════════════════════════════════════════════════════════════════

1. Strategy Pattern
   - Discountable interface acts as strategy
   - Different discount types can be plugged in

2. Factory Pattern (Implicit)
   - ProductCatalog generates product IDs automatically
   - Central place for product creation

3. Separation of Concerns
   - ProductCatalog: manages inventory
   - ShoppingCart: manages user's cart
   - ShoppingCartApp: manages UI/user interaction
   - Each class has single responsibility

═══════════════════════════════════════════════════════════════════════════════════
11. FUTURE ENHANCEMENTS
═══════════════════════════════════════════════════════════════════════════════════

✓ Database Integration (MySQL/PostgreSQL)
✓ Persistent Data Storage (JSON/XML files)
✓ Multiple Discount Types (Percentage, Fixed Amount, BOGO)
✓ Inventory Management with Low Stock Alerts
✓ Order History and Order Tracking
✓ Payment Gateway Integration
✓ Email Notifications
✓ User Authentication (Login/Password)
✓ Admin Panel for Product Management
✓ Analytics and Sales Reports
✓ Customer Reviews and Ratings
✓ Wishlist Functionality

═══════════════════════════════════════════════════════════════════════════════════
12. CONCLUSION
═══════════════════════════════════════════════════════════════════════════════════

This Online Shopping Cart System is a comprehensive demonstration of Java OOP
principles in a practical, real-world context. It showcases:

• Clear separation of concerns through well-defined classes
• Proper encapsulation with private data and public interfaces
• Inheritance hierarchy for code reuse (Product → PhysicalProduct/DigitalProduct)
• Polymorphic behavior through abstract classes and interfaces
• Abstraction of complex logic behind simple interfaces
• Professional, user-friendly interactive interface
• Input validation and error handling
• Scalable architecture for future enhancements

The project successfully implements SOLID principles and serves as an educational
resource for learning Java OOP concepts through practical application.

═══════════════════════════════════════════════════════════════════════════════════


