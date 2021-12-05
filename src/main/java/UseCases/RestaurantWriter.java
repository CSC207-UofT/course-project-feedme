package UseCases;

import Entity.Restaurant;

import java.io.*;
import java.util.ArrayList;

/**
 * changes: changed input as an array list (before was restaurant).
 */
public class RestaurantWriter implements Serializable{
    public void addRestaurant(Restaurant restaurant) {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("restaurants.ser"));
            ArrayList<Restaurant> rArr = (ArrayList<Restaurant>) ois.readObject();
            rArr.add(restaurant);
            ois.close();
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("restaurants.ser"));
            oos.writeObject(rArr);
            oos.close();

        } catch (ClassNotFoundException | IOException e) {e.printStackTrace();}

    }
    //TODO: finish this class to update restaurant into restaurant.txt (restaurant client added product to its menu)
    public void updateRestaurant(ArrayList<Restaurant> restaurants_list){
        try{
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("restaurants.ser"));
            oos.writeObject(restaurants_list);
            oos.close();

        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}

