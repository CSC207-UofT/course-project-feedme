package UseCases;

import Entity.Product;
import Entity.Restaurant;
import UseCases.RestaurantWriter;

import java.util.ArrayList;
import java.util.List;
import java.io.*;

public class restaurantList implements Serializable {
    /**
     * return a hashmap where key is restaurant name and item is list of products.
     */

    private final ArrayList<Restaurant> restaurantList = new ArrayList<Restaurant>();

    public ArrayList<Restaurant> getRestaurants() {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("restaurants.txt"));
            return (ArrayList<Restaurant>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String toString() {
        int count = 1;
        StringBuilder list = new StringBuilder("Here is the list of restaurants:");
        for (Restaurant restaurant: restaurantList) {
            String line = String.valueOf(1) + ": " + restaurant + "\n";
            list.append(line);
            count ++;
        }
        list.append("Please enter restaurant's number to view its menu:");
        return list.toString();
    }
}
