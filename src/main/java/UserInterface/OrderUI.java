package UserInterface;

import Controller.OrderController;
import Entity.Cart;
import Entity.Restaurant;
import InOut.SystemInOut;

public class OrderUI {

    private final Restaurant restaurant;
    public OrderUI(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
    public Cart ordering() {
        OrderController controller = new OrderController(restaurant);
        return controller.addToCart();
    }
}
