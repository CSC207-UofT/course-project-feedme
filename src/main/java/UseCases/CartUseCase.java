package UseCases;

import Entity.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class CartUseCase {

    private final Cart cart;
    private Map<String, Product> menu = new HashMap<>();


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
            menu.append(count + ": " + product  );
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
