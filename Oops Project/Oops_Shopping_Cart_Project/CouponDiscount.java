// POLYMORPHISM: CouponDiscount implements Discountable interface
public class CouponDiscount implements Discountable {
    private String couponCode;
    private double discountPercent;

    public CouponDiscount(String couponCode, double discountPercent) {
        this.couponCode = couponCode;
        this.discountPercent = discountPercent;
    }

    public String getCouponCode() { return couponCode; }

    @Override
    public double applyDiscount(double originalPrice) {
        return originalPrice * (1 - discountPercent / 100);
    }

    @Override
    public String getDiscountDescription() {
        return String.format("Coupon [%s] - %.0f%% off", couponCode, discountPercent);
    }
}
