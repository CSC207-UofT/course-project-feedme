package UseCases;

import DataAccess.CustomerGatherer;
import DataAccess.DpersonGatherer;
import DataAccess.RestaurantGatherer;
import Entity.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GetUserMap {
    RestaurantGatherer restaurantGatherer = new RestaurantGatherer();
    CustomerGatherer customerGatherer = new CustomerGatherer();
    DpersonGatherer dpersonGatherer = new DpersonGatherer();

    private HashMap<String, User> hash_map= new HashMap<>();

    public Map<String, User> getMap(){
        List<User> list = new ArrayList<>();
        list.addAll(restaurantGatherer.getRestaurants());
        list.addAll(customerGatherer.getCustomerArray());
        list.addAll(dpersonGatherer.getDpersonArray());
        for (User user : list){
            hash_map.put(user.getUserPhone_num(), user);
        }
        return hash_map;
    }

}
