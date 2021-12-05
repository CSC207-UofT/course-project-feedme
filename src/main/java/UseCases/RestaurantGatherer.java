package UseCases;

import Entity.Restaurant;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class RestaurantGatherer {
    /**
     * return a hashmap where key is restaurant name and item is list of products.
     */
    public ArrayList<Restaurant> getRestaurants() {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("restaurants.ser"));
            return (ArrayList<Restaurant>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
