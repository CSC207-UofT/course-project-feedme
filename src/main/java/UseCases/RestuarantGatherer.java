package UseCases;

import Entity.Restaurant;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class RestuarantGatherer {
    /**
     * return a hashmap where key is restaurant name and item is list of products.
     */
    public Restaurant[] getRestaurants() {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("restaurants.txt"));
            return (Restaurant[]) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
