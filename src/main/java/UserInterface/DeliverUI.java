package UserInterface;

import Controller.BrowsingController;
import Controller.DeliverController;
import Controller.OrderController;
import Entity.DeliveryPerson;
import Entity.Order;
import Entity.Restaurant;
import Entity.User;
import InOut.SystemInOut;

import java.util.Scanner;


/**
 * A user interface for deliver men to view order list and select which order to deliver.
 */

public class DeliverUI {

    public void startDeliverUI(User user) {
        SystemInOut inOut = new SystemInOut();
        DeliverController deliverController = new DeliverController();
        deliverController.showDeliverPortal(user, inOut);
    }
}