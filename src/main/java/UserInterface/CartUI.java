package UserInterface;

import Controller.CartController;

import java.util.Map;

/**
 * User interface for ordering items
 */
public class CartUI {

    private final String restaurantNum;

    /**
     * Initiating OrderUI
     * @param restaurantNum The string of phone number of selected restaurant
     */
    public CartUI(String restaurantNum) {
        this.restaurantNum = restaurantNum;
    }

    public Map<String, Integer> ordering() {
        CartController cartController = new CartController(restaurantNum);
        return cartController.addToCart();
    }


}
