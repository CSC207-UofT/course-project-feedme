package Entity;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;

/**
 * Before an order is generated, item are added to the cart which is then used to generate an Order.
 */
public class Cart {
    private final HashMap<Product, Integer> cart; // key is a Product, value is product quantity
    //Initialize an chart
    public Cart(){
        this.cart = new HashMap<>();
    }

    public HashMap<Product, Integer> getCart() { return this.cart; }

    public boolean addProductToCart(Product product, Integer quantity) {
        if (this.cart.containsKey(product)) {
            if (product.getProductStock() >= quantity) {// Check if there is enough stock
                cart.put(product, cart.get(product) + quantity);
                product.updateStock(-quantity);
                return true;
            } else {
                return false;
            }
        } else {
            if (product.getProductStock() >= quantity) {// Check if there is enough stock
                cart.put(product, quantity);
                product.updateStock(-quantity);
                return true;
            } else {
                return false;
            }
        }
    }

    public boolean removeProductFromCart(Product product, Integer quantity) {
        if (cart.containsKey(product)) {
            if (quantity.equals(cart.get(product))) {
                cart.remove(product);
                product.updateStock(quantity);
                return true;
            }
            else if (quantity < cart.get(product)) {
                cart.put(product, cart.get(product) - quantity);
                product.updateStock(quantity);
                return true;
            }
            else {
                return false; // Number of product to remove > Product number in listProducts.
            }
        } else {
            return false; // listProduct does not contain Product product.
        }
    }

    public double getOrderPrice() {
        double order_price = 0.00;
        int quantity;
        for (Product product : cart.keySet()) {
            quantity = cart.get(product);
            order_price += product.getProductPrice() * quantity;
        }
        BigDecimal b = new BigDecimal(order_price);
        return b.setScale(2, RoundingMode.HALF_UP).doubleValue();
    }

    @Override
    public String toString() {
        StringBuilder items = new StringBuilder("Here are the items in your cart:\n");
        for (Product product: this.cart.keySet()) {
            items.append(this.cart.get(product)).append(" ").append(product).append("\n");
        }
        items.append("\nTotal price: $").append(getOrderPrice());
        return items.toString();
    }
}
