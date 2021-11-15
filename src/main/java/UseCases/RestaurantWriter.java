package UseCases;

import Entity.Restaurant;

import java.io.*;
import java.util.ArrayList;

public class RestaurantWriter implements Serializable{

    public void addRestaurant(Restaurant restaurant) {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("restaurants.txt"));
            ArrayList<Restaurant> rArr = (ArrayList<Restaurant>) ois.readObject();
            rArr.add(restaurant);
            ois.close();
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("restaurants.txt"));
            oos.writeObject(rArr);
            oos.close();

        } catch (ClassNotFoundException | IOException e) {e.printStackTrace();}

    }

    public void updateRestaurant(Restaurant restaurant){
        try{
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("restaurants.txt"));
            ArrayList<Restaurant> rArr = (ArrayList<Restaurant>) ois.readObject();
            ois.close();


        }
        catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}

