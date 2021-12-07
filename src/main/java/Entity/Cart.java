package Entity;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;

/**
 * Before an order is generated, item are added to the cart which is then used to generate an Order.
 */
public class Cart {
    private final HashMap<Product, Integer> cart; // key is a Product, value is product quantity

    /**
     * Initiate a Cart
     */
    public Cart(){
        this.cart = new HashMap<>();
    }

    /**
     * Getter for cart
     * @return
     */
    public HashMap<Product, Integer> getCart() { return this.cart; }

    /**
     * Add product and quantity to the cart whiling checking if there is enough stock.
     * @param product (Product) The product that needs to be added to the cart
     * @param quantity (Integer) The quantity of product that needs to be added to the cart
     * @return (boolean) true if product and quantity has been successfully added, false otherwise.
     */
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
                product.updateStock(quantity);
                return true;
            } else {
                return false;
            }
        }
    }

    /**
     * Remove product from cart
     * @param product (Product) the product that needs to be removed
     * @param quantity (Ineteger) the quantity of the product that needs to be removed
     * @return (boolean) true if product and quantity has been successfully removed, false otherwise.
     */
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

    /**
     * Get the total prices of the items in the cart.
     * @return (douple) The price of all items in the cart
     */
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

    /**
     * Overwrite toString to show the cart
     * @return (String) the formatted string that represent cart
     */
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
