package Controller;

import Entity.Order;
import Entity.User;
import UseCases.OrderManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Controls the process for browsing order list and decide which order to deliver.
 */

public class DeliverController {
    private OrderManager orderManager = new OrderManager();

   public List<Order> getAllUndeliveredOrders() {
       List<Order> undeliveredOrder = new ArrayList<>();

       for (Order order : orderManager.getAllOrders()) {
           if (order.getDeliveryPersonInfo() == null || order.getDeliveryPersonInfo().size() == 0) {
               undeliveredOrder.add(order);
           }
       }

       return undeliveredOrder;
    }

    public void updateOrderDeliveryPerson(String currentOrderId, User user) {
        orderManager.updateOrderDeliveryPerson(currentOrderId, user);
    }
}
