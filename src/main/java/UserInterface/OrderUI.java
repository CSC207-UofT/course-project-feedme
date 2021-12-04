package UserInterface;

import Controller.OrderController;
import Entity.Cart;
import Entity.Restaurant;
import InOut.SystemInOut;

public class OrderUI {

    private final String restaurantNum;
    public OrderUI(String restaurantNum) {
        this.restaurantNum = restaurantNum;
    }
    public Cart ordering() {
        OrderController controller = new OrderController(restaurantNum);
        return controller.addToCart();
    }
}
