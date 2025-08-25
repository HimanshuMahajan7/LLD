package applycoupons.src;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    List<Product> productList;

    public ShoppingCart() {
        productList = new ArrayList<>();
    }

    public void addToCart(Product product) {
        Product productWithEligibleDiscount = new TypeCouponDecorator(
                new PercentageCouponDecorator(10, product), product.getType(), 3
        );
        productList.add(productWithEligibleDiscount);
    }

    public double totalPrice() {
        double totalPrice = 0;
        for (Product product: productList) {
            totalPrice += product.getPrice();
        }
        return totalPrice;
    }
}
