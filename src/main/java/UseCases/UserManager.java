package UseCases;

import Entity.Customer;
import Entity.DeliveryPerson;
import Entity.Restaurant;
import Entity.User;
import java.util.HashMap;

public class UserManager {
    private final HashMap<String, User> userHashMap;

    public UserManager(){
        this.userHashMap = new HashMap<>();
    }

    public boolean createUser(String phone_num, User user){
        if(!this.userHashMap.containsKey(phone_num)){
            this.userHashMap.put(phone_num, user);
            return true;
        }
        return false;
    }

    public boolean userLookup(String phone_num) { return this.userHashMap.containsKey(phone_num); }

    public boolean verifyUser(String phone_num, String enter_password) {
        if (this.userHashMap.containsKey(phone_num)) {
            return (this.userHashMap.get(phone_num).getUserPassword().equals(enter_password));
        }
        return false;
    }

    public Customer customerSignup(String name, String phone_num, String password, char type_, String address){
        return new Customer(name, address, phone_num, password, type_);
    }

    //Since we are not sure when we need to use them , we just leave it.
    public Restaurant restaurantSignup(String name, String phone_num, String password, char type_, String address){
        return new Restaurant(name, address, phone_num, password, type_);
    }
    public DeliveryPerson deliveryPersonSignup(String name, String phone_num, String password, char type_){
        return new DeliveryPerson(name, phone_num, password, type_);
    }
}


