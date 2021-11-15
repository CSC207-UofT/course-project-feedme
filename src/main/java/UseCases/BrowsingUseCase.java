package UseCases;

import Entity.Restaurant;

import java.util.*;


public class BrowsingUseCase {

    private final restaurantList restaurants;
    private final HashMap<String, Restaurant> list = new HashMap<String, Restaurant>();

    public BrowsingUseCase() {
        this.restaurants = new restaurantList();
        int count = 1;
        for (Restaurant restaurant: restaurants.restaurantsGetter()) {
            this.list.put(String.valueOf(count), restaurant);
            count++;
        }
    }

    public String showRestaurants() {
        return restaurants.toString();
    }

    public boolean verifyRestautantSeleciton(String num) {
        return this.list.containsKey(num);
    }





}

