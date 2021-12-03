package Entity;

import java.util.HashMap;

/**
 * Before an order is generated, item are added to the cart which is then used to generate an Order.
 */
public class Cart {
    private final HashMap<Product, Integer> cart; // key is a Product, value is product number

    //Initialize an chart
    public Cart(){
        this.cart = new HashMap<>();
    }

    public HashMap<Product, Integer> getCart() { return this.cart; }

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

    public double getOrderPrice(){
        double order_price = 0.00;
        Integer quantity;
        for(Product product: cart.keySet()){
            quantity = cart.get(product);
            order_price += product.getProductPrice() * quantity ;
        }
        return order_price;
    }

    @Override
    public String toString() {
        StringBuilder items = new StringBuilder("Here are the items in your cart:\n");
        for (Product product: this.cart.keySet()) {
            items.append(this.cart.get(product)).append("\t").append(product);
        }
        items.append("\nTotal price: $").append(getOrderPrice());
        return items.toString();
    }

}
