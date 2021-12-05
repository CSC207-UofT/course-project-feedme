package UserInterface;

import Controller.OrderController;

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

    public Map<String, Integer> ordering() {
        OrderController controller = new OrderController(restaurantNum);
        return controller.addToCart();
    }
}
