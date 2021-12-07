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

    /**
     * All customer to add items to the cart
     * @return (Map<String, Integer>) A map that contains the name of selected product and its quantity
     */
    public Map<String, Integer> ordering() {
        CartController cartController = new CartController(restaurantNum);
        return cartController.addToCart();
    }


}
