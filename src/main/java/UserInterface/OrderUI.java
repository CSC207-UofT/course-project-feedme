package UserInterface;

import Controller.OrderController;
import Entity.Order;

import java.util.List;
import java.util.Map;

public class OrderUI {

    private final String customerNum;
    private final String restaurantNum;
    private final Map<String, Integer> cart;

    public OrderUI(String customerNum, String restaurantNum, Map<String, Integer> cart) {
        this.customerNum = customerNum;
        this.restaurantNum = restaurantNum;
        this.cart = cart;
    }

    public void placeOrder() {
        OrderController orderController = new OrderController(customerNum, restaurantNum, cart);
        orderController.createOrder(customerNum);
    }

    }


