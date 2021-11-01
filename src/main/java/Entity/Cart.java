package Entity;

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

    // Add quantity number of Product product to listProduct. If there is enough stock for product, update product's
    // stock and listProducts, and return true. If stock is not enough, return false.
    public boolean addProductToCart(Product product, Integer quantity) {
        if (listProducts.containsKey(product)) {
            if (product.getProductStock() >= quantity) {// Check if there is enough stock
                listProducts.put(product, listProducts.get(product) + quantity);
                product.updateStock(quantity);
                return true;
            } else {

                return false;
            }
        }
        else {
            if (product.getProductStock() >= quantity) {// Check if there is enough stock
                listProducts.put(product, quantity);
                product.updateStock(quantity);
                return true;
            } else {
                return false;
            }
        }
    }

    public boolean removeProductFromCart(Product product, Integer quantity) {
        if (listProducts.containsKey(product)) {
            if (quantity.equals(listProducts.get(product))) {
                listProducts.remove(product);
                product.updateStock(quantity);
                return true;
            }
            else if (quantity < listProducts.get(product)) {
                listProducts.put(product, listProducts.get(product) - quantity);
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
        for(Product product: listProducts.keySet()){
            quantity = listProducts.get(product);
            order_price += product.getProductPrice() * quantity ;
        }
        return order_price;
    }
}
