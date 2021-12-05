import Entity.Cart;
import Entity.Product;
import Entity.Restaurant;
import Entity.User;
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
            Map<Product, Integer> cart = Oui.ordering();

        } catch (NullPointerException ignored) {}



    }

}

