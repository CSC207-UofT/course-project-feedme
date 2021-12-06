package Presenter;

import InOut.SystemInOut;
import UseCases.BrowsingUseCase;

public class BrowsingPrensenter {

    BrowsingUseCase browsingUseCasease = new BrowsingUseCase();

    public String showRestaurantsList() {
        return browsingUseCasease.showRestaurants();
    }

    public String invalidMessage(){
        return "\nThe number you entered is not valid. Please check and re-enter the number.";
    }

    public String showRestaurantName(String input) {
        return "\nHere is the menu for " + browsingUseCasease.showRestaurantName(input) + ":";
    }

    public String showError() {
        return "Something went wrong";
    }

    public String askSelection() {
        return "\nPlease type '1' if you would like to order from this restaurant. If you want to go " +
                "back to the list of restaurants, please type '2'. If you would like to exit, please type '3'.";
    }


}
