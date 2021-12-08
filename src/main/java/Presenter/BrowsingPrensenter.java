package Presenter;

import InOut.SystemInOut;
import UseCases.BrowsingUseCase;

/**
 * Presenter for BrowsingController
 */
public class BrowsingPrensenter {

    BrowsingUseCase browsingUseCasease = new BrowsingUseCase();

    /**
     * show the list of restaurants
     * @return (String) The list of restaurants
     */
    public String showRestaurantsList() {
        return browsingUseCasease.showRestaurants();
    }

    /**
     * Show message for invalid input
     * @return (String) The message for invalid input
     */
    public String invalidMessage(){
        return "\nThe number you entered is not valid. Please check and re-enter the number.";
    }

    /**
     * Show the name of the restaurant
     * @param input (String) input restaurant number
     * @return (String)The name of the restaurant
     */
    public String showRestaurantName(String input) {
        return "\nHere is the menu for " + browsingUseCasease.showRestaurantName(input) + ":";
    }

    /**
     * Show error message for exception
     * @return error message
     */
    public String showError() {
        return "Something went wrong";
    }

    /**
     * Ask customer to select if they would like to order from this restaurant
     * @return (String) Asking for selection
     */
    public String askSelection() {
        return "\nPlease type '1' if you would like to order from this restaurant. If you want to go " +
                "back to the list of restaurants, please type '2'. If you would like to exit, please type '3'.";
    }


}
