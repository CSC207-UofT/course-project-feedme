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

    public UserManager() {
        UserGatherer userGatherer = new UserGatherer();
        this.userHashMap = userGatherer.loadUser();

    }

//    public boolean createUser(String phone_num, User user) {
//        if (!this.userHashMap.containsKey(phone_num)) {
//            this.userHashMap.put(phone_num, user);
//            return true;
//        }
//        return false;
//    }


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

    public void updateUser(User user) {
        UserWriter writer = new UserWriter();
        writer.addUser(user);
    }

    public boolean addUser(String phone_num, User user) {
        if (!this.userHashMap.containsKey(phone_num)) {
            this.userHashMap.put(phone_num, user);
            this.updateUser(user);
            return true;
        }
        return false;
    }

    public boolean userLookup(String phone_num) {
        return this.userHashMap.containsKey(phone_num);
    }

    public boolean verifyUser(String phone_num, String enter_password) {
        if (this.userHashMap.containsKey(phone_num)) {
            return (this.userHashMap.get(phone_num).getUserPassword().equals(enter_password));
        }
        return false;
    }

    public boolean createCustomer(String name, String phone_num, String password, String type_, String address) {
        Customer customer;
        customer = new Customer(name, phone_num, password, type_, address);
        return this.addUser(customer.getUserPhone_num(), customer);
    }

    // For method restaurantSignup and deliveryPersonSignup, since we are not sure the relation between them and Login &
    // Signup, we just leave them as they are
    public boolean createRestaurant(String name, String phone_num, String password, String type_, String address) {
        Restaurant restaurant;
        restaurant = new Restaurant(name, phone_num, password, type_, address);
        return this.addUser(restaurant.getUserPhone_num(), restaurant);
    }

    public boolean createDeliveryPerson(String name, String phone_num, String password, String type_) {
        DeliveryPerson deliveryPerson;
        deliveryPerson = new DeliveryPerson(name, phone_num, password, type_);
        return this.addUser(deliveryPerson.getUserPhone_num(), deliveryPerson);
    }
}