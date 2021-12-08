package UserInterface;

import Controller.RestaurantSystemController;
import Entity.Restaurant;
import UseCases.BrowsingUseCase;
import UseCases.RestaurantManager;

import java.io.IOException;

/**
 * A restaurant interface for deliver men to view order list and select which order to deliver.
 */
public class RestaurantUI {
    String r;
    public RestaurantUI(String restaurant){
        this.r = restaurant;
    }

    public void restaurantEdit(String resNum) throws IOException {


        RestaurantSystemController rsc = new RestaurantSystemController(resNum);
        rsc.run();
    }
}
