package UseCases;
import Entity.Customer;
import Entity.DeliveryPerson;
import Entity.Restaurant;
import Entity.User;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Scanner;

public class UserManager {
    private HashMap<String, User> userHashMap;  //Since a UserManager could add and remove users, the field may not
                                                 // noy be final
    private final String file_path= "C:\\Users\\Edward\\IdeaProjects\\course-project-feedme\\data\\user_data.txt";

    public UserManager(){
        this.userHashMap = new HashMap<>();

    }


    public void initUserMap()  {
        try {
            File file = new File(this.file_path);
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                String[] user_info = sc.nextLine().split(",");
                if (user_info[3].equals("c")) {
                    this.addUser(user_info[1], this.createCustomer(user_info[0], user_info[1],
                            user_info[2], user_info[3], user_info[4]));
                }
                if (user_info[3].equals("r")) {
                    this.addUser(user_info[1], this.createRestaurant(user_info[0], user_info[1],
                            user_info[2], user_info[3], user_info[4]));
                }
                if (user_info[3].equals("d")) {
                    this.addUser(user_info[1], this.createDeliveryPerson(user_info[0],
                            user_info[1], user_info[2], user_info[3]));
                }
            }

        }
        catch (Exception e){
            System.out.println("There is error reading user data. Please contact us.");
        }
    }

    public void updateUser(User user){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(this.file_path));
            String userdata = null;
            userdata = user.getUserName() + ',' + user.getUserPhone_num() + ',' + user.getUserPassword() + ',' +
                    user.getUserType();
            if (user instanceof Customer){userdata += ',' + ((Customer) user).getCustomerAddress();}
            if (user instanceof Restaurant){userdata += ',' + ((Restaurant) user).getRestaurantAddress();}
            if (userdata != null){
                writer.write(userdata);}
            writer.close();
        }
        catch (Exception e){
            System.out.println("There is a problem updating user. Please contact us.");
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

    public boolean userLookup(String phone_num) { return this.userHashMap.containsKey(phone_num); }

    public boolean verifyUser(String phone_num, String enter_password) {
        if (this.userHashMap.containsKey(phone_num)) {
            return (this.userHashMap.get(phone_num).getUserPassword().equals(enter_password));
        }
        return false;
    }

    public Customer createCustomer(String name, String phone_num, String password, String type_, String address){
        return new Customer(name, phone_num, password, type_, address);
    }

    // For method restaurantSignup and deliveryPersonSignup, since we are not sure the relation between them and Login &
    // Signup, we just leave them as they are
    public Restaurant createRestaurant(String name, String phone_num, String password, String type_, String address){
        return new Restaurant(name, phone_num, password, type_, address);
    }

    public DeliveryPerson createDeliveryPerson(String name, String phone_num, String password, String type_){
        return new DeliveryPerson(name, phone_num, password, type_);
    }
}


