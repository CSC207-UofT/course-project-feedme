package UserInterface;

import Controller.RestaurantSystemController;
import Entity.Restaurant;
import UseCases.BrowsingUseCase;
import UseCases.RestaurantManager;

import java.io.IOException;

public class RestaurantUI {
    String r;
    public RestaurantUI(String restaurant){
        this.r = restaurant;
    }

    public void restaurantEdit(Restaurant res) throws IOException {

        RestaurantManager rm = new RestaurantManager(res);
        RestaurantSystemController rsc = new RestaurantSystemController(rm);
        rsc.run();
    }
}
