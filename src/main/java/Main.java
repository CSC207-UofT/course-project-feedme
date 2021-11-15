

import Entity.Cart;
import Entity.Restaurant;
import InOut.SystemInOut;
import UserInterface.BrowsingUI;
import UserInterface.OrderUI;


public class Main {

    public static void main(String[] args) {

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

