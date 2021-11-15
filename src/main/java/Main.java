
import Controller.BrowsingController;
import Entity.Restaurant;

import InOut.SystemInOut;
import UseCases.RestaurantGatherer;
import UseCases.restaurantList;
import UserInterface.BrowsingUI;
//import UserInterface.BrowsingUI;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
//        restaurantList restaurants = new restaurantList();
//        BrowsingUseCase usecase = new BrowsingUseCase(restaurants);
//        BrowsingController controller = new BrowsingController(usecase);
//        BrowsingUI ui = new BrowsingUI();
//
//        ui.viewRestaurants(controller);
//        restaurantList list = new restaurantList();
//        RestaurantGatherer rg = new RestaurantGatherer();
//        ArrayList<Restaurant> r = rg.getRestaurants();
//        for (Restaurant restaurant: r) {
//            System.out.println(restaurant.getUserName());
//        System.out.println(list);
        BrowsingUI ui = new BrowsingUI();
        ui.browsing();
        }


    }

