package UserInterface;

import Controller.OrderController;
import Entity.Cart;
import Entity.Product;
import Entity.Restaurant;
import InOut.SystemInOut;

import java.util.Map;

public class OrderUI {

    private final String restaurantNum;
    public OrderUI(String restaurantNum) {
        this.restaurantNum = restaurantNum;
    }
    public Map<Product, Integer> ordering() {
        OrderController controller = new OrderController(restaurantNum);
        return controller.addToCart();
    }
}
