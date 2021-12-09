package UseCases;

import Entity.*;
import Gateway.UserReadWrite;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class UserManager {
    private final HashMap<String, User> userHashMap;

    /**
     * This is a large use case to control all the users. Any other use case or controller would like to get user info
     * would need to use this class. This class called getUserMap (helper class) by default to gather all users' info
     * as Map first.
     */
    public UserManager(){
        GetUserMap getUserMap = new GetUserMap();
        this.userHashMap = (HashMap<String, User>) getUserMap.getMap();
    }

    public boolean createUser(String name, String phone_num, String password, String type_, String address){
        if(!this.userHashMap.containsKey(phone_num)){
            if (type_.equals("c")){
                this.addUser(phone_num, new Customer(name, phone_num, password, type_, address));
            }
            else if (type_.equals("r")){
                this.addUser(phone_num, new Restaurant(name, phone_num, password,type_, address));
            }
            else{
                this.addUser(phone_num, new DeliveryPerson(name, phone_num, password, type_));
            }
            return true;
        }
        return false;
    }

    public void updateUser(User user){
        UserReadWrite urw = new UserReadWrite();
        if (user instanceof Customer) {
            ArrayList<Customer> list = (ArrayList<Customer>) urw.readCustomers();
            list.add((Customer) user);
            urw.updateCustomer(list);
        }
        else  if (user instanceof Restaurant){
            ArrayList<Restaurant> list = (ArrayList<Restaurant>) urw.readRestaurants();
            list.add((Restaurant) user);
            urw.updateRestaurant(list);
        }
        else {
            ArrayList<DeliveryPerson> list =(ArrayList<DeliveryPerson>) urw.readDpersons();
            list.add((DeliveryPerson) user);
            urw.updateDperson(list);
        }


    }
    public boolean addUser(String phone_num, User user){
        if(!this.userHashMap.containsKey(phone_num)){
            this.userHashMap.put(phone_num, user);
            this.updateUser(user);
            return true;
        }
        return false;
    }

    public Customer getCustomer(String customerNum) {
        return (Customer) this.userHashMap.get(customerNum);
    }

    public Restaurant getRestaurant(String restaurantNum) {
        return (Restaurant) this.userHashMap.get(restaurantNum);
    }

    public boolean userLookup(String phone_num) { return this.userHashMap.containsKey(phone_num); }

    public String getType(String phone_num) {return this.userHashMap.get(phone_num).getUserType();}

    public User getUserByPhoneNumber(String phone_num) { return this.userHashMap.get(phone_num); }

    public boolean verifyUser(String phone_num, String enter_password) {
        if (this.userHashMap.containsKey(phone_num)) {
            return (this.userHashMap.get(phone_num).getUserPassword().equals(enter_password));
        }
        return false;
    }

    /**
     * Add order user's order history
     * @param order (Order) The order that needs to be added to order history
     * @param customerNum (String) The phone number of the customer
     * @param restaurantNum (String) The phone number of the restaurant
     */
    public void updateUserOrderHistory(Order order, String customerNum, String restaurantNum) {
        UserReadWrite readWrite = new UserReadWrite();

        List<Customer> customerList = readWrite.readCustomers();
        List<Restaurant> restaurantList = readWrite.readRestaurants();

        for (Customer customer: customerList) {
            if (customer.getUserPhone_num().equals(customerNum)) {
                customer.addOrderToOrderHistory(order);
            }
        }

        for (Restaurant restaurant: restaurantList) {
            if (restaurant.getUserPhone_num().equals(restaurantNum)) {
                restaurant.addOrderToOrderHistory(order);
            }
        }

        readWrite.updateCustomer(customerList);
        readWrite.updateRestaurant(restaurantList);

    }

}


