package UseCases;


import Entity.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GetUserMap {
    UserReadWrite urw = new UserReadWrite();

    private HashMap<String, User> hash_map= new HashMap<>();

    public Map<String, User> getMap(){
        List<User> list = new ArrayList<>();
        list.addAll(urw.readRestaurants());
        list.addAll(urw.readCustomers());
        list.addAll(urw.readDpersons());
        for (User user : list){
            hash_map.put(user.getUserPhone_num(), user);
        }
        return hash_map;
    }

}