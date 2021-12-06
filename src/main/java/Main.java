import UserInterface.BrowsingUI;
import UserInterface.LoginUI;
import UserInterface.CartUI;

import java.util.List;
import java.util.Map;


public class Main {

    public static void main(String[] args) {
        LoginUI Lui = new LoginUI();
        List<String> user = Lui.login();
        if (user.get(1).equals("c")) {
            String customerNum = user.get(0);
            BrowsingUI Bui = new BrowsingUI();
            String restaurantNum = Bui.browsing();
            try {
                CartUI Cui = new CartUI(restaurantNum);
                Map<String, Integer> cart = Cui.ordering();
            } catch (NullPointerException ignored) {
            }
        }



    }

}

