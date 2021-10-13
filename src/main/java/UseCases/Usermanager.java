package UseCases;

import Entity.Customer;
import Entity.DeliveryPerson;
import Entity.Restaurant;
import Entity.User;
import java.util.HashMap;

public class Usermanager {
    private HashMap<String, User> user_map = new HashMap<String, User>();

    public boolean add_user(String phone_num, User user){
        if(!this.user_map.containsKey(phone_num)){
            this.user_map.put(phone_num, user);
            return true;
        }
        return false;
    }

    public boolean user_lookup(String phone_num) { return this.user_map.containsKey(phone_num); }

    public boolean check_password(String phone_num, String enter_password) {
        return (this.user_map.get(phone_num).getUserPassword().equals(enter_password));
    }

    public Customer customer_signup(String name, String phone_num, String password, char type_, String address){
        return new Customer(name, phone_num, password, type_, address);
    }
    public Restaurant restaurant_signup(String name, String phone_num, String password, char type_, String address){
        return new Restaurant(name, phone_num, password, type_, address);
    }
    public DeliveryPerson deliveryperson_signup(String name, String phone_num, String password, char type_){
        return new DeliveryPerson(name, phone_num, password, type_);
    }
}


