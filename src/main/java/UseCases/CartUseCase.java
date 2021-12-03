package UseCases;

import Entity.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * CartUseCase is for OrderController that allows customer to add products into a cart and ready for generating an
 * order.
 */
public class CartUseCase {

    private final Cart cart;
    private final Map<String, Product> menu = new HashMap<>();

    /**
     * Generate a empty cart, and get information for the restaurant that is selected in the browsing stage.
     * @param restaurant the restaurant that is selected in browsing stage.
     */
    public CartUseCase(Restaurant restaurant) {
        this.cart = new Cart();
        int count = 1;
        for (Product product: restaurant.getRestaurantMenu()) {
            this.menu.put(String.valueOf(count), product);
            count++;
        }
    }

    public Cart getCart() {
        return this.cart;
    }

    public String showMenu(Restaurant restaurant) {
        List<Product> list = restaurant.getRestaurantMenu();
        StringBuilder menu = new StringBuilder("Menu:\n");
        int count = 1;
        for (Product product: list) {
            menu.append(count).append(": ").append(product);
            count++;
        }
        return menu.toString();
    }

    public boolean verifyProductNum(String num) {
        return this.menu.containsKey(num);
    }

    public Product getProduct(String num) {
        return this.menu.get(num);
    }

    public void addToCart(Product product, Integer quantity) {
        if (cart.getCart().containsKey(product)) {
            cart.getCart().put(product, cart.getCart().get(product) + quantity);
        } else {
            cart.getCart().put(product, quantity);
        }
        product.updateStock(-quantity);
    }

    public boolean checkStockAvailability(Product product, Integer quantity) {
        return quantity <= product.getProductStock();
    }

    @Override
    public String toString() {
        return this.cart.toString();
    }
}