// ABSTRACTION via Interface: Any discount type must implement this
public interface Discountable {
    double applyDiscount(double originalPrice);
    String getDiscountDescription();
}
