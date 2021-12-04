import Entity.Cart;
import Entity.Restaurant;
import Entity.User;
import UserInterface.BrowsingUI;
import UserInterface.LoginUI;
import UserInterface.OrderUI;


public class Main {

    public static void main(String[] args) {
        LoginUI Lui = new LoginUI();
        User user = Lui.login();
        BrowsingUI Bui = new BrowsingUI();
        String restaurantNum = Bui.browsing();
        if (restaurantNum != null){
            OrderUI Oui = new OrderUI(restaurantNum);
            Cart cart = Oui.ordering();
            if (cart != null) {
                System.out.println("Enter order distribution");
            }
        }

    }

}

