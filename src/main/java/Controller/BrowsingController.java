package Controller;

import Entity.Restaurant;
import UseCases.BrowsingUseCase;

import java.io.IOException;

/**
 * Controls the process for browsing restaurants menu and decide which restaurant to order.
 */

public class BrowsingController {

    /**
     * The input and output boundary fo the browsing use case.
     */

    public interface InOut {
        String getInput() throws IOException;

        void sendOutput(String output);
    }

    private final BrowsingUseCase browsingUsecase = new BrowsingUseCase();

    public Restaurant selectRestaurant(InOut inOut) {

        boolean confirmSelection = false;
        Restaurant restaurant = null;

        while (!confirmSelection) {
            inOut.sendOutput(browsingUsecase.showRestaurants());
            try {
                String input = inOut.getInput();
                while (!browsingUsecase.verifyRestautantSeleciton(input)) {
                    inOut.sendOutput("\nThe number you entered is not valid. Please check and re-enter the number.");
                    inOut.sendOutput(browsingUsecase.showRestaurants());
                    input = inOut.getInput();
                }
                restaurant = browsingUsecase.getRestaurant(input);
                inOut.sendOutput("\nHere is the menu for " + browsingUsecase.showRestaurantName(input) + ":");
                inOut.sendOutput(browsingUsecase.showMenu(input));

            } catch (IOException e) {
                inOut.sendOutput("Something went wrong");
            }

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

    return restaurant;

    }
}
