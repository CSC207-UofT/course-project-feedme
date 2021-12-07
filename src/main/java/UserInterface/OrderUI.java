package UserInterface;

import Controller.OrderController;
import java.util.Map;

/**
 * User interface for placing order
 */
public class OrderUI {

    private final String customerNum;
    private final String restaurantNum;
    private final Map<String, Integer> cart;

    /**
     * Initiating OrderUI
     * @param customerNum (String) customer's phone number
     * @param restaurantNum (String) restaurant's phone number
     * @param cart (Map<String, Integer>) a map contains the name of selected product and its quantity
     */
    public OrderUI(String customerNum, String restaurantNum, Map<String, Integer> cart) {
        this.customerNum = customerNum;
        this.restaurantNum = restaurantNum;
        this.cart = cart;
    }

    /**
     * Allow customers to place order
     */
    public void placeOrder() {
        OrderController orderController = new OrderController(customerNum, restaurantNum, cart);
        orderController.createOrder();
    }

    }


