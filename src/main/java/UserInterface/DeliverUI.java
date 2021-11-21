package UserInterface;

import Controller.BrowsingController;
import Controller.DeliverController;
import Controller.OrderController;
import Entity.DeliveryPerson;
import Entity.Order;
import Entity.Restaurant;
import Entity.User;

import java.util.Scanner;


/**
 * A user interface for deliver men to view order list and select which order to deliver.
 */

public class DeliverUI {
    private DeliverController deliverController = new DeliverController();

    public void showDeliverPortal(User user) {
        System.out.println("\n\n=== DELIVER PORTAL ===" +
                "\n1) Type 1 to show order information" +
                "\n2) Type 2 to update order information"+
                "\n3) Type 3 to exit the system" +
                "\n==================");

        printAskForCommandMessage();
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();

        while (!command.equals("3")) {
            if (command.equals("1")) {
                for (Order order : deliverController.getAllUndeliveredOrders()) {
                    System.out.println("Order Id: " + order.getOrderId());
                }
            }
            else if (command.equals("2")) {
                System.out.println("Please select the order you want to deliver by typing an order ID");
                String orderId = scanner.nextLine();

               deliverController.updateOrderDeliveryPerson(orderId, user);
                System.out.println("Order info successfully updated!");
            }
            else if (command.equals("3")) {
                System.exit(1);
            }
            else{
                System.out.println("No such command!");
            }

            printAskForCommandMessage();
            command = scanner.nextLine();
        }

        // command is not equal to 'exit'
        System.exit(1);
    }

    private void printAskForCommandMessage() {
        System.out.print(" Enter command (1, 2, 3)=> ");
    }
}
