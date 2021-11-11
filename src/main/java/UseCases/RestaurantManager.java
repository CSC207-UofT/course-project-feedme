package UseCases;

import Entity.Product;
import Entity.Restaurant;
import Entity.Order;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;


public class RestaurantManager {
    Restaurant restaurant;
    ArrayList<Order> orderHistory;
    public RestaurantManager(Restaurant restaurant){
        this.restaurant = restaurant;
        this.orderHistory = new ArrayList<Order>();
    }

    //Add product to restaurant menu if boolean is true, vice versa.
    public boolean editRestaurantMenu(Product item, boolean bool){
        if(bool){
            return this.restaurant.addRestaurantProduct(item);
        }
        return this.restaurant.removeRestaurantProduct(item);
    }

    //Change restaurant menu to a new one.
    public List<Product> getMenu(){
        return this.restaurant.getRestaurantProducts();
    }


    //Precondition: products in order are all from the restaurant.
    //Receive order and record it. The stock reduces by given quantities in the order.
    public void receiveOrder(Order order){
        this.orderHistory.add(order);
        HashMap<Product, Integer> hashMap = order.getOrderProducts();
        for (Product key: hashMap.keySet()) {
            key.reduceProductStock(hashMap.get(key));
        }
    }
}
