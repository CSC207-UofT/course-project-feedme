package UserInterface;

import java.util.Scanner;
import Controller.BrowsingController;
import InOut.SystemInOut;

/**
 * An user interface for customer to view restaurants' menu and select which restaurant to order.
 */

public class BrowsingUI<inOut> {

    public void browsing() {
        BrowsingController controller = new BrowsingController();
        SystemInOut inOut = new SystemInOut();
        controller.viewRestaurants(inOut);
    }


}




