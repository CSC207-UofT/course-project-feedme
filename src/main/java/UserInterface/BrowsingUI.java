package UserInterface;

import Controller.BrowsingController;

/**
 * An user interface for customer to view restaurants' menu and select which restaurant to order.
 */

public class BrowsingUI {

    /**
     * Allow customer to browse all restaurants and their menu
     * @return (String) The selected restaurant name
     */
    public String browsing() {

        BrowsingController controller = new BrowsingController();

        return controller.selectRestaurant();
    }


}




