package Controller;

import Entity.Restaurant;
import UseCases.BrowsingUseCase;

import java.io.IOException;

/**
 * Controls the process for browsing restaurants menu and decide which restaurant to order.
 */

public class BrowsingController {

    /**
     * The input and output boundary for the browsing Controller.
     */

    public interface InOut {
        String getInput() throws IOException;

        void sendOutput(String output);
    }

    /**
     * Initiate a new BrowsingUseCase which will read restaurant serialization file.
     */

    private final BrowsingUseCase browsingUsecase = new BrowsingUseCase();

    /**
     * Method that allows customer to view and select restaurants.
     * @param inOut input output boundary
     * @return Restaurant selected restaurant
     */

    public Restaurant selectRestaurant(InOut inOut) {

        boolean confirmSelection = false;
        Restaurant restaurant = null;
        // While-loop for viewing restaurants' menu
        while (!confirmSelection) {
            // Show a list of restaurants
            inOut.sendOutput(browsingUsecase.showRestaurants());
            try {
                String input = inOut.getInput();
                // While loop for checking valid input
                while (!browsingUsecase.verifyRestautantSeleciton(input)) {
                    inOut.sendOutput("\nThe number you entered is not valid. Please check and re-enter the number.");
                    inOut.sendOutput(browsingUsecase.showRestaurants());
                    input = inOut.getInput();
                }
                // Save selected restaurant
                restaurant = browsingUsecase.getRestaurant(input);
                // Show menu
                inOut.sendOutput("\nHere is the menu for " + browsingUsecase.showRestaurantName(input) + ":");
                inOut.sendOutput(browsingUsecase.showMenu(input));

            } catch (IOException e) {
                inOut.sendOutput("Something went wrong");
            }

            // Ask customer to comfirm selection or exit.
            inOut.sendOutput("\nPlease type '1' if you would like to order from this restaurant. If you want to go " +
                    "back to the list of restaurants, please type '2'. If you would like to exit, please type '3'.");
            try {
                String input = inOut.getInput();
                if (input.equals("1")){
                    confirmSelection = true;
                    break;
                } else if (input.equals("3")) {
                    restaurant = null;
                    return restaurant;
                }

            } catch (IOException e) {
                inOut.sendOutput("Something went wrong");
            }
        }
    // Return the selected restaurant
    return restaurant;

    }
}
