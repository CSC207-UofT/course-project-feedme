package UseCases;

import Entity.Customer;
import Entity.DeliveryPerson;
import Entity.Restaurant;
import Entity.User;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;


public class UserGatherer {
    public HashMap<String, User> loadCustomer() {
        HashMap<String, User> customerHashMap = new HashMap<>();
        try {
            File file = new File("customer.txt");
            BufferedReader br = new BufferedReader(new FileReader(file));
            String user;
            while ((user = br.readLine()) != null) {
                String[] user_info = user.split(",");
                if (user_info.length >= 5) {
                    customerHashMap.put(user_info[1], new Customer(user_info[0], user_info[1],
                            user_info[2], user_info[3], user_info[4]));
                }
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return customerHashMap;
    }

    public HashMap<String, User> loadDeliveryPerson() {
        HashMap<String, User> deliveryPersonHashMap = new HashMap<>();
        try {
            File file = new File("deliveryperson.txt");
            BufferedReader br = new BufferedReader(new FileReader(file));
            String user;
            while ((user = br.readLine()) != null) {
                String[] user_info = user.split(",");
                if (user_info.length >= 5) {
                    deliveryPersonHashMap.put(user_info[1], new DeliveryPerson(user_info[0], user_info[1],
                            user_info[2], user_info[3], user_info[4]));
                }
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return deliveryPersonHashMap;
    }
//    public HashMap<String, User> loadUser() {
//        HashMap<String, User> userHashMap = new HashMap<>();
//        try {
//            File file = new File("customer.txt");
//            BufferedReader br = new BufferedReader(new FileReader(file));
//
//
//            String user;
//            while ((user = br.readLine()) != null) {
//                String[] user_info = user.split(",");
//                if (user_info.length >= 5 && user_info[3].equals("c")) {
//                    HashMap.put(user_info[1], new Customer(user_info[0], user_info[1],
//                            user_info[2], user_info[3], user_info[4]));
//                }
//                if (user_info.length >= 5 && user_info[3].equals("r")) {
//                    userHashMap.put(user_info[1], new Restaurant(user_info[0], user_info[1],
//                            user_info[2], user_info[3], user_info[4]));
//                }
//                if (user_info.length >= 5 && user_info[3].equals("d")) {
//                    userHashMap.put(user_info[1], new DeliveryPerson(user_info[0],
//                            user_info[1], user_info[2], user_info[3], user_info[4]));
//                }
//            }
//        }
//        catch (IOException e){
//            e.printStackTrace();
//        }
//        return userHashMap;
//    }
}
