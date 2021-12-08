package Controller;

import Entity.Order;
import Entity.User;
import InOut.SystemInOut;
import UseCases.OrderManager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Controls the process for browsing order list and decide which order to deliver.
 */

public class DeliverController {
    public void setOrderManager(OrderManager orderManager) {
        this.orderManager = orderManager;
    }

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

    public void showDeliverPortal(User user, SystemInOut inOut) {
        inOut.sendOutput("\n\n=== DELIVER PORTAL ===" +
                "\n1) Type 1 to show order information" +
                "\n2) Type 2 to update order information" +
                "\n3) Type 3 to exit the system" +
                "\n==================");

        inOut.sendOutput(" Enter command (1, 2, 3)=> ");
        try {
            String command = inOut.getInput();

            while (!command.equals("3")) {
                if (command.equals("1")) {
                    for (Order order : getAllUndeliveredOrders()) {
                        inOut.sendOutput("Order Id: " + order.getOrderId());
                    }
                } else if (command.equals("2")) {
                    inOut.sendOutput("Please select the order you want to deliver by typing an order ID");
                    String orderId = inOut.getInput();

                    updateOrderDeliveryPerson(orderId, user);
                    inOut.sendOutput("Order info successfully updated!");
                } else if (command.equals("3")) {
                    System.exit(1);
                } else {
                    inOut.sendOutput("No such command!");
                }

                inOut.sendOutput(" Enter command (1, 2, 3)=> ");
                command = inOut.getInput();
            }

            // command is not equal to 'exit'
            System.exit(1);
        } catch (IOException e) {
            inOut.sendOutput("Something went wrong");
        }
    }
}


