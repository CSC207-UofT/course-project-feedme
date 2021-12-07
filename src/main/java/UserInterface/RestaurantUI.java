package UserInterface;

import Controller.RestaurantSystemController;
import Entity.Restaurant;
import UseCases.RestaurantManager;
import InOut.SystemInOut;
import java.io.IOException;

public class RestaurantUI {
    Restaurant r;
    public RestaurantUI(Restaurant restaurant){
        this.r = restaurant;
    }

    public void restaurantEdit() throws IOException {
        RestaurantManager rm = new RestaurantManager(r);
        RestaurantSystemController rsc = new RestaurantSystemController(rm);
        SystemInOut inOut = new SystemInOut();
        rsc.run(inOut);
    }
}