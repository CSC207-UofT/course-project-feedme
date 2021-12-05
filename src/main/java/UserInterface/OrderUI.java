package UserInterface;

import Controller.OrderController;
import Entity.Cart;
import Entity.Product;
import Entity.Restaurant;
import InOut.SystemInOut;

import java.util.Map;

/**
 * User interface for ordering items
 */
public class OrderUI {

    private final String restaurantNum;

    /**
     * Initiating OrderUI
     * @param restaurantNum The string of phone number of selected restaurant
     */
    public OrderUI(String restaurantNum) {
        this.restaurantNum = restaurantNum;
    }

    public Map<Product, Integer> ordering() {
        OrderController controller = new OrderController(restaurantNum);
        return controller.addToCart();
    }
}
