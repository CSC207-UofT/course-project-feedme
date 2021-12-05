import UserInterface.BrowsingUI;
import UserInterface.LoginUI;
import UserInterface.OrderUI;

import java.util.Map;


public class Main {

    public static void main(String[] args) {
        LoginUI Lui = new LoginUI();
        String userNum = Lui.login();
        BrowsingUI Bui = new BrowsingUI();
        String restaurantNum = Bui.browsing();
        try {
            OrderUI Oui = new OrderUI(restaurantNum);
            Map<String, Integer> cart = Oui.ordering();
            System.out.println(cart);
        } catch (NullPointerException ignored) {}



    }

}

