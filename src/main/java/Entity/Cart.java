package Entity;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;

/**
 * This is a controller to our ordering process.
 */
public class Cart {
    private final HashMap<Product, Integer> listProducts; // key is a Product, value is product number

    //Initialize an chart
    public Cart(){
        this.listProducts = new HashMap<>();
    }

    public HashMap<Product, Integer> getCart() { return this.listProducts; }

    public double getCartPrice() {
        double order_price = 0.00;
        int quantity;
        for (Product product : listProducts.keySet()) {
            quantity = listProducts.get(product);
            order_price += product.getProductPrice() * quantity;
        }
        BigDecimal b = new BigDecimal(order_price);
        return b.setScale(2, RoundingMode.HALF_UP).doubleValue();
    }

    @Override
    public String toString() {
        StringBuilder content = new StringBuilder("Cart + \n" + "total price: " + getCartPrice() + "\n");
        for (Product product : listProducts.keySet()) {
            content.append(product.toString()).append("\n");
        }
        return content.substring(0, content.length() - 1);
    }
}
