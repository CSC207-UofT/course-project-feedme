package UseCases;

import Entity.Restaurant;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class RestaurantGatherer {
    /**
     * return a hashmap where key is restaurant name and item is list of products.
     */
    public List<Restaurant> getRestaurants() {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("restaurants.txt"));
            return (List<Restaurant>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
