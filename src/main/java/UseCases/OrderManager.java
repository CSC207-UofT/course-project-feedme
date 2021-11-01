package UseCases;

import Entity.*;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;


public class OrderManager {

    private HashMap<Product, Integer> cart;

    public OrderManager(){ this.cart = new HashMap<Product, Integer>(); }

    public boolean verifyProductName(Restaurant restaurant, String productName) {
        for (Product product: restaurant.getRestaurantMenu()) {
            if (product.getProductName().equals(productName)) {
                return true;
            }
        }
        return false;
    }

    public Product productNameToProduct(Restaurant restaurant, String productName) {
        for (Product product: restaurant.getRestaurantMenu()) {
            if (product.getProductName().equals(productName)) {
                return product;
            }
        }
        return null;
    }

    public void addToCart(Product product, Integer quantity) {
        if (cart.containsKey(product)) {
            cart.put(product, cart.get(product) + quantity);
        } else {
            cart.put(product, quantity);
        }
        product.updateStock(-quantity);
    }

    public boolean checkStockAvailability(Product product, Integer quantity) {
        return quantity >= product.getProductStock();
    }




}
