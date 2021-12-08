package UseCases;

import Entity.Customer;
import Entity.DeliveryPerson;
import Entity.Restaurant;
import java.io.*;
import java.util.List;

/**
 * This class is for interact with the serialized file.
 */
public class UserReadWrite {
    private final boolean testFlag = System.getProperty("isTest") != null;
    public List<Customer> readCustomers(){

        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(testFlag ? "CustomersTest.ser" : "Customers.ser"));
            return (List<Customer>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
    public List<DeliveryPerson> readDpersons(){
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(testFlag ? "DeliverypersonTest.ser": "Deliveryperson.ser"));
            return (List<DeliveryPerson>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
    public List<Restaurant> readRestaurants() {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(testFlag ? "RestaurantsTest.ser" : "Restaurants.ser"));
            return (List<Restaurant>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
    public void updateCustomer(List<Customer> customer_list){
        try{
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(testFlag ? "CustomersTest.ser" : "Customers.ser"));
            oos.writeObject(customer_list);
            oos.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
    public void updateDperson(List<DeliveryPerson> d_person_list) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(testFlag ? "DeliverypersonTest.ser": "Deliveryperson.ser"));
            oos.writeObject(d_person_list);
            oos.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void updateRestaurant(List<Restaurant> restaurants_list){
        try{
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(testFlag ? "RestaurantsTest.ser" : "Restaurants.ser"));
            oos.writeObject(restaurants_list);
            oos.close();

        } catch (IOException e){
            e.printStackTrace();
        }
    }

}
