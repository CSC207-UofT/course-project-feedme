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

    public UserGatherer(){
    }
    public HashMap<String, User> loadUser() {
        HashMap<String, User> userHashMap = new HashMap<String, User>();
        try {
            File file = new File("users.txt");
            BufferedReader br = new BufferedReader(new FileReader(file));


            String user;
            while ((user = br.readLine()) != null) {
                String[] user_info = user.split(",");
                if (user_info[3].equals("c")) {
                    userHashMap.put(user_info[1], new Customer(user_info[0], user_info[1],
                            user_info[2], user_info[3], user_info[4]));
                }
                if (user_info[3].equals("r")) {
                    userHashMap.put(user_info[1], new Restaurant(user_info[0], user_info[1],
                            user_info[2], user_info[3], user_info[4]));
                }
                if (user_info[3].equals("d")) {
                    userHashMap.put(user_info[1], new DeliveryPerson(user_info[0],
                            user_info[1], user_info[2], user_info[3]));
                }
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return userHashMap;
    }
}
