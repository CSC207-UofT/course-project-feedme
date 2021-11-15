package UseCases;

import Entity.Customer;
import Entity.DeliveryPerson;
import Entity.Restaurant;
import Entity.User;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class UserManager {
    private HashMap<String, User> userHashMap;  //Since a UserManager could add and remove users, the field may not
    // noy be final

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

    public void init() throws FileNotFoundException {
        File file = new File("C:\\User\\Edward\\IdeaProjects\\course-project-feedme\\data\\user_data.txt");
        Scanner sc = new Scanner(file);

        while (sc.hasNextLine()){
            String[] user_info = sc.nextLine().split(",");
            if (user_info[3].equals("c")){this.createUser(user_info[1], this.createCustomer(user_info[0], user_info[1],
                    user_info[2], user_info[3], user_info[4]));}
            if (user_info[3].equals("r")){this.createUser(user_info[1], this.createRestaurant(user_info[0], user_info[1],
                    user_info[2], user_info[3], user_info[4]));}
            if (user_info[3].equals("d")){this.createUser(user_info[1], this.createDeliveryPerson(user_info[0],
                    user_info[1], user_info[2], user_info[3], user_info[4]));}
        }
    }

    public Customer createCustomer(String name, String phone_num, String password, String type_, String address){
        return new Customer(name, address, phone_num, password, type_);
    }

    // For method restaurantSignup and deliveryPersonSignup, since we are not sure the relation between them and Login &
    // Signup, we just leave them as they are
    public Restaurant createRestaurant(String name, String phone_num, String password, String type_, String address){
        return new Restaurant(name, address, phone_num, password, type_);
    }

    public DeliveryPerson createDeliveryPerson(String name, String phone_num, String password, String type_, String transport){
        return new DeliveryPerson(name, phone_num, password, type_, transport);
    }
}


