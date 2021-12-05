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
    private final Restaurant restaurant;

    /**
     * Generate a empty cart, and get information for the restaurant that is selected in the browsing stage.
     * @param restaurantNum the restaurant that is selected in browsing stage.
     */
    public CartUseCase(String restaurantNum) {
        this.cart = new Cart();
        int count = 1;
        RestaurantList restaurantList = new RestaurantList();
        this.restaurant = restaurantList.findRestaurnat(restaurantNum);
        for (Product product: restaurant.getRestaurantMenu()) {
            this.menu.put(String.valueOf(count), product);
            count++;
        }
    }

    public Cart getCart() {
        return this.cart;
    }

    public Map<Product, Integer> cartToMap(){
        Map<Product, Integer> products = new HashMap<Product, Integer>();
        for (Product product: this.cart.getCart().keySet()){
            products.put(product, this.cart.getCart().get(product));
        }
        return products;
    }

    public String showMenu(String restaurantNum) {
        List<Product> list = this.restaurant.getRestaurantMenu();
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