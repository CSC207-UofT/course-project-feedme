package UseCases;

import Entity.Product;
import Entity.Restaurant;
import UseCases.RestaurantGatherer;
import java.util.*;

import java.util.ArrayList;
import java.util.List;
import java.io.*;

public class RestaurantList {


    RestaurantGatherer restaurantGatherer = new RestaurantGatherer();
    private final ArrayList<Restaurant> restaurants = restaurantGatherer.getRestaurants();

    public ArrayList<Restaurant> restaurantsGetter() { return restaurants; }

    @Override
    public String toString() {
        int count = 1;
        StringBuilder list = new StringBuilder("\nHere is the list of restaurants:\n");
        for (Restaurant restaurant: restaurants) {
            String line = count + ": " + restaurant + "\n";
            list.append(line);
            count++;
        }
        list.append("\nPlease enter restaurant's number to view its menu:");
        return list.toString();
    }
}
