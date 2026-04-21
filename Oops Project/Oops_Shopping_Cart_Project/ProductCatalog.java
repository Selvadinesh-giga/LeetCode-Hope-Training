import java.util.*;
import java.util.stream.Collectors;

public class ProductCatalog {
    private List<Product> products;
    private int nextProductId;

    public ProductCatalog() {
        this.products = new ArrayList<>();
        this.nextProductId = 1;
    }

    // Add a product to the catalog with auto-generated ID
    public void addProduct(Product product) {
        product.setId(nextProductId++);
        products.add(product);
    }

    // Display all products
    public void displayAll() {
        System.out.println("\n═══════════════════════ PRODUCT CATALOG ═══════════════════════");
        products.forEach(System.out::println);
        System.out.println("════════════════════════════════════════════════════════════════\n");
    }

    // Filter by category
    public void displayByCategory(String category) {
        System.out.println("\n── Category: " + category + " ──");
        products.stream()
                .filter(p -> p.getCategory().equalsIgnoreCase(category))
                .forEach(System.out::println);
        System.out.println();
    }

    // Get product by ID
    public Product getById(int id) {
        return products.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);
    }

    // Search by name keyword
    public List<Product> search(String keyword) {
        return products.stream()
                .filter(p -> p.getName().toLowerCase().contains(keyword.toLowerCase()))
                .collect(Collectors.toList());
    }
}
