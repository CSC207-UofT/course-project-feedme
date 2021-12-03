package Controller;

import Entity.Restaurant;
import UseCases.BrowsingUseCase;
import InOut.SystemInOut;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Controls the process for browsing restaurants menu and decide which restaurant to order.
 */

public class BrowsingController implements SystemInOut{


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



    /**
     * Initiate a new BrowsingUseCase which will read restaurant serialization file.
     */

    private final BrowsingUseCase browsingUsecase = new BrowsingUseCase();

    /**
     * Method that allows customer to view and select restaurants.
     * @return Restaurant selected restaurant
     */

    public Restaurant selectRestaurant() {

        boolean confirmSelection = false;
        Restaurant restaurant = null;
        // While-loop for viewing restaurants' menu
        while (!confirmSelection) {
            // Show a list of restaurants
            sendOutput(browsingUsecase.showRestaurants());
            try {
                String input = getInput();
                // While loop for checking valid input
                while (!browsingUsecase.verifyRestautantSeleciton(input)) {
                    sendOutput("\nThe number you entered is not valid. Please check and re-enter the number.");
                    sendOutput(browsingUsecase.showRestaurants());
                    input = getInput();
                }
                // Save selected restaurant
                restaurant = browsingUsecase.getRestaurant(input);
                // Show menu
                sendOutput("\nHere is the menu for " + browsingUsecase.showRestaurantName(input) + ":");
                sendOutput(browsingUsecase.showMenu(input));

            } catch (IOException e) {
                sendOutput("Something went wrong");
            }

            // Ask customer to comfirm selection or exit.
            sendOutput("\nPlease type '1' if you would like to order from this restaurant. If you want to go " +
                    "back to the list of restaurants, please type '2'. If you would like to exit, please type '3'.");
            try {
                String input = getInput();
                if (input.equals("1")){
                    confirmSelection = true;
                    break;
                } else if (input.equals("3")) {
                    restaurant = null;
                    return restaurant;
                }

            } catch (IOException e) {
                sendOutput("Something went wrong");
            }
        }
    // Return the selected restaurant
    return restaurant;

    }
}
