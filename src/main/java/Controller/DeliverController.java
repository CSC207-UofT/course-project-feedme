package Controller;

import Entity.Order;
import Entity.User;
import InOut.SystemInOut;
import UseCases.OrderManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Controls the process for browsing order list and decide which order to deliver.
 */

public class DeliverController implements SystemInOut{
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

    public void updateOrderDeliveryPerson(String currentOrderId, String user_phonenum) {
        orderManager.updateOrderDeliveryPerson(currentOrderId, user_phonenum);
    }

    @Override
    public String getInput() throws IOException {
        BufferedReader reader;
        reader = new BufferedReader(new InputStreamReader(System.in));
        return reader.readLine();
    }

    @Override
    public void sendOutput(String output) {
        System.out.println(output);
    }

    public void showDeliverPortal(String user_phonenum) {
        sendOutput("\n\n=== DELIVER PORTAL ===" +
                "\n1) Type 1 to show order information" +
                "\n2) Type 2 to update order information" +
                "\n3) Type 3 to exit the system" +
                "\n==================");

        sendOutput(" Enter command (1, 2, 3)=> ");
        try {
            String command = getInput();

            while (!command.equals("3")) {
                if (command.equals("1")) {
                    for (Order order : getAllUndeliveredOrders()) {
                        sendOutput("Order Id: " + order.getOrderId());
                    }
                } else if (command.equals("2")) {
                    sendOutput("Please select the order you want to deliver by typing an order ID");
                    String orderId = getInput();

                    updateOrderDeliveryPerson(orderId, user_phonenum);
                    sendOutput("Order info successfully updated!");
                } else if (command.equals("3")) {
                    System.exit(1);
                } else {
                    sendOutput("No such command!");
                }

                sendOutput(" Enter command (1, 2, 3)=> ");
                command = getInput();
            }

            // command is not equal to 'exit'
            System.exit(1);
        } catch (IOException e) {
            sendOutput("Something went wrong");
        }
    }
}


