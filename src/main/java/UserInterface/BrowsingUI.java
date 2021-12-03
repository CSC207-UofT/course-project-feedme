package UserInterface;

import Controller.BrowsingController;
import Entity.Restaurant;
import InOut.SystemInOut;

/**
 * An user interface for customer to view restaurants' menu and select which restaurant to order.
 */

public class BrowsingUI {

    public Restaurant browsing() {

        BrowsingController controller = new BrowsingController();

        return controller.selectRestaurant();
    }


}




