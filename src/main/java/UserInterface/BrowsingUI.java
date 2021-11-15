package UserInterface;

import Controller.BrowsingController;
import InOut.SystemInOut;

/**
 * An user interface for customer to view restaurants' menu and select which restaurant to order.
 */

public class BrowsingUI {

    public boolean browsing() {
        BrowsingController controller = new BrowsingController();
        SystemInOut inOut = new SystemInOut();
        return controller.selectRestaurant(inOut);
    }


}




