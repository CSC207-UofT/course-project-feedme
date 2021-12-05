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

    /**
     * Convert Cart to Map.
     * @return A Map with Product as keys and Integer as items.
     */
    public Map<String, Integer> cartToMap(){
        Map<String, Integer> products = new HashMap<String, Integer>();
        for (Product product: this.cart.getCart().keySet()){
            products.put(product.getProductName(), this.cart.getCart().get(product));
        }
        return products;
    }

    /**
     * Show the name of the restaurant
     * @return (String) the name of the restaurant
     */
    public String showRestaurantName(){
        return this.restaurant.getUserName();
    }

    /**
     * Show the restaurant's menu
     * @return (String) the menu of the restaurant
     */
    public String showMenu() {
        List<Product> list = this.restaurant.getRestaurantMenu();
        StringBuilder menu = new StringBuilder("Menu:\n");
        int count = 1;
        for (Product product: list) {
            menu.append(count).append(": ").append(product);
            count++;
        }
        return menu.toString();
    }

    /**
     * Verify if the input is valid.
     * @param num (String) the number of the product.
     * @return (Boolean) true if the input is valid, false is the input is invalid.
     */
    public boolean verifyProductNum(String num) {
        return this.menu.containsKey(num);
    }

    /**
     * Get product name based on the number of the product
     * @param num (String) the number of the product.
     * @return (String) the name of the product.
     */
    public String getProductName(String num) {
        return this.menu.get(num).getProductName();
    }


    public void addToCart(String productName, Integer quantity) {
        Product product = null;
        for (Product p: this.restaurant.getRestaurantMenu()) {
            if (p.getProductName().equals(productName)) {
                product = p;
            }
        }
        if (this.cart.getCart().containsKey(product)) {
            this.cart.getCart().put(product, this.cart.getCart().get(product) + quantity);
        } else {
            this.cart.getCart().put(product, quantity);
        }
        assert product != null;
        product.updateStock(-quantity);
    }

    public boolean checkStockAvailability(String productName, Integer quantity) {
        for (Product product: this.restaurant.getRestaurantMenu()) {
            if (product.getProductName().equals(productName)) {
                return quantity <= product.getProductStock();
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return this.cart.toString();
    }
}