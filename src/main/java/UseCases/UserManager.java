package UseCases;
import Entity.Customer;
import Entity.DeliveryPerson;
import Entity.Restaurant;
import Entity.User;

import java.util.HashMap;

public class UserManager {
    private final HashMap<String, User> userHashMap;  //Since a UserManager could add and remove users, the field may not
                                                 // noy be final
//    private final String file_path= "C:\\Users\\Edward\\IdeaProjects\\course-project-feedme\\data\\user_data.txt";

    public UserManager(){
        GetUserMap getUserMap = new GetUserMap();
        this.userHashMap = (HashMap<String, User>) getUserMap.getMap();
    }

    public boolean createUser(String phone_num, User user){
        if(!this.userHashMap.containsKey(phone_num)){
            this.userHashMap.put(phone_num, user);
            return true;
        }
        return false;
    }


    //May be used in the future
//    public void initUserMap()  {
//        try {
//            File file = new File(this.file_path);
//            Scanner sc = new Scanner(file);
//            while (sc.hasNextLine()) {
//                String[] user_info = sc.nextLine().split(",");
//                if (user_info[3].equals("c")) {
//                    this.addUser(user_info[1], this.createCustomer(user_info[0], user_info[1],
//                            user_info[2], user_info[3], user_info[4]));
//                }
//                if (user_info[3].equals("r")) {
//                    this.addUser(user_info[1], this.createRestaurant(user_info[0], user_info[1],
//                            user_info[2], user_info[3], user_info[4]));
//                }
//                if (user_info[3].equals("d")) {
//                    this.addUser(user_info[1], this.createDeliveryPerson(user_info[0],
//                            user_info[1], user_info[2], user_info[3]));
//                }
//            }
//
//        }
//        catch (Exception e){
//            System.out.println("There is error reading user data. Please contact us.");
//        }
//    }

    public void updateUser(User user){
        UserWriter writer = new UserWriter();
        writer.addUser(user);
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


