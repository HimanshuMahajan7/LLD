package applycoupons.src;

public class PercentageCouponDecorator extends CouponDecorator {

    public PercentageCouponDecorator(int discountPercentage, Product product) {
        this.discountPercentage = discountPercentage;
        this.product = product;
    }

    @Override
    public double getPrice() {
        double price = product.getPrice();
        return price - (price * discountPercentage) / 100;
    }
}
