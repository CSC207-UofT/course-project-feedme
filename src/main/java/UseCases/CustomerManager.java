package UseCases;

import Entity.Customer;
import Entity.User;

import java.util.HashMap;

public class CustomerManager {
    private final HashMap<String, User> customerHashMap;  //Since a UserManager could add and remove users, the field may not
    // noy be final

    public CustomerManager(){
        this.customerHashMap = new HashMap<>();
    }

    public boolean add(Customer customer){
        if(!this.customerHashMap.containsKey(customer.getUserPhone_num())) {
            this.customerHashMap.put(customer.getUserPhone_num(), customer);
            return true;
        }
        return false;
    }

    public boolean userLookup(String phone_num) { return this.customerHashMap.containsKey(phone_num); }

    public boolean verifyCustomer(String phone_num, String enter_password) {
        if (this.customerHashMap.containsKey(phone_num)) {
            return (this.customerHashMap.get(phone_num).getUserPassword().equals(enter_password));
        }
        return false;
    }

}

