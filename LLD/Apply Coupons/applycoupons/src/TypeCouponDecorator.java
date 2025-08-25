package applycoupons.src;

import java.util.List;

public class TypeCouponDecorator extends CouponDecorator {

    ProductType productType;

    final static List<ProductType> eligibleTypes = List.of(ProductType.FURNITURE);

    public TypeCouponDecorator(Product product, ProductType productType, int discountPercentage) {
        this.discountPercentage = discountPercentage;
        this.product = product;
        this.productType = productType;
    }

    @Override
    public double getPrice() {
        double price = product.getPrice();
        if (eligibleTypes.contains(productType)) {
            return price - (price * discountPercentage) / 100;
        }
        return price;
    }
}
