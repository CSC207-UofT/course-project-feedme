import UserInterface.BrowsingUI;
import UserInterface.DeliverUI;
import UserInterface.LoginUI;
import UserInterface.CartUI;
import UserInterface.OrderUI;

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
                OrderUI Oui = new OrderUI(customerNum, restaurantNum, cart);
                Oui.placeOrder();
            } catch (NullPointerException ignored) {
            }
        } else if (user.get(1).equals("d")) {
            DeliverUI deliverUI = new DeliverUI();
            deliverUI.startDeliverUI(user.get(0));
        }
        if (user.get(1).equals("r")) {
            try {
                RestaurantUI restaurantUI = new RestaurantUI(user.get(0));
                restaurantUI.restaurantEdit(user.get(0));
            } catch (NullPointerException ignored) {
            }
        }
    }

}
