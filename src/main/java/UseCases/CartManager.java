package UseCases;
import Entity.*;

public class CartManager {

    private final Cart cart;

    public CartManager(){ this.cart = new Cart(); }

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
        if (cart.getCart().containsKey(product)) {
            cart.getCart().put(product, cart.getCart().get(product) + quantity);
        } else {
            cart.getCart().put(product, quantity);
        }
        product.updateStock(-quantity);
    }

    public boolean checkStockAvailability(Product product, Integer quantity) {
        return quantity >= product.getProductStock();
    }


}
