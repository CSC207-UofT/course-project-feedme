package UseCases;

import Entity.Customer;
import Entity.DeliveryPerson;
import Entity.Restaurant;
import Entity.User;

import java.util.ArrayList;
import java.util.HashMap;

public class UserManager {
    private final HashMap<String, User> userHashMap;  //Since a UserManager could add and remove users, the field may not
    // noy be final
//    private final String file_path= "C:\\Users\\Edward\\IdeaProjects\\course-project-feedme\\data\\user_data.txt";

    public UserManager() {
        GetUserMap getUserMap = new GetUserMap();
        this.userHashMap = (HashMap<String, User>) getUserMap.getMap();
    }

    public boolean createUser(String phone_num, User user) {
        if (!this.userHashMap.containsKey(phone_num)) {
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

    public void updateUser(User user) {
        UserReadWrite urw = new UserReadWrite();
        if (user instanceof Customer) {
            ArrayList<Customer> list = (ArrayList<Customer>) urw.readCustomers();
            list.add((Customer) user);
            urw.updateCustomer(list);
        } else if (user instanceof Restaurant) {
            ArrayList<Restaurant> list = (ArrayList<Restaurant>) urw.readRestaurants();
            list.add((Restaurant) user);
            urw.updateRestaurant(list);
        } else {
            ArrayList<DeliveryPerson> list = (ArrayList<DeliveryPerson>) urw.readDpersons();
            list.add((DeliveryPerson) user);
            urw.updateDperson(list);
        }


    }

    public boolean addUser(String phone_num, User user) {
        if (!this.userHashMap.containsKey(phone_num)) {
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

    public boolean userLookup(String phone_num) {
        return this.userHashMap.containsKey(phone_num);
    }

    public String getType(String phone_num) {
        return this.userHashMap.get(phone_num).getUserType();
    }

    public boolean verifyUser(String phone_num, String enter_password) {
        if (this.userHashMap.containsKey(phone_num)) {
            return (this.userHashMap.get(phone_num).getUserPassword().equals(enter_password));
        }
        return false;
    }

    public boolean createCustomer(String name, String phone_num, String password, String type_, String address) {
        Customer customer = new Customer(name, phone_num, password, type_, address);
        return this.addUser(customer.getUserPhone_num(), customer);
    }

    // For method restaurantSignup and deliveryPersonSignup, since we are not sure the relation between them and Login &
    // Signup, we just leave them as they are
    public boolean createRestaurant(String name, String phone_num, String password, String type_, String address) {
        Restaurant restaurant = new Restaurant(name, phone_num, password, type_, address);
        return this.addUser(restaurant.getUserPhone_num(), restaurant);
    }

    public boolean createDeliveryPerson(String name, String phone_num, String password, String type_) {
        DeliveryPerson deliveryPerson = new DeliveryPerson(name, phone_num, password, type_);
        return this.addUser(deliveryPerson.getUserPhone_num(), deliveryPerson);
    }
}