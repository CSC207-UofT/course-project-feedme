import UserInterface.BrowsingUI;
import UserInterface.LoginUI;
import UserInterface.CartUI;

import java.util.Map;


public class Main {

    public static void main(String[] args) {
        LoginUI Lui = new LoginUI();
        String userNum = Lui.login();
        BrowsingUI Bui = new BrowsingUI();
        String restaurantNum = Bui.browsing();
        try {
            CartUI Oui = new CartUI(restaurantNum);
            Map<String, Integer> cart = Oui.ordering();
        } catch (NullPointerException ignored) {}



    }

}