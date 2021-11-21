import Entity.Cart;
import Entity.Restaurant;
import Entity.User;
import UserInterface.BrowsingUI;
import UserInterface.DeliverUI;
import UserInterface.LoginUI;
import UserInterface.OrderUI;


public class Main {

    public static void main(String[] args) {
        LoginUI Lui = new LoginUI();
        User user = Lui.login();

        if (user.getUserType().equals("d")) {
            DeliverUI deliverUI = new DeliverUI();
            deliverUI.showDeliverPortal(user);
        }
        else {
            BrowsingUI Bui = new BrowsingUI();
            Restaurant restaurant = Bui.browsing();

            if (restaurant != null){
                OrderUI Oui = new OrderUI(restaurant);
                Cart cart = Oui.ordering();
                if (cart != null) {
                    System.out.println("Enter order distribution");
                }
            }
        }
    }

}

