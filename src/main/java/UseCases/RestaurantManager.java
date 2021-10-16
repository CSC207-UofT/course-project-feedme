package UseCases;

import Entity.Product;
import Entity.Restaurant;
import Entity.Order;
import UseCases.OrderManager;

import java.util.HashMap;
import java.util.List;

public class RestaurantManager {
    Restaurant restaurant;
    OrderManager o_manager;
    public RestaurantManager(Restaurant restaurant){
        this.restaurant = restaurant;
        this.o_manager = new OrderManager();}

    //Add product to restaurant menu if boolean is true, vice versa.
    public void editRestaurantMenu(Product item, boolean bool){
        if(bool){
            this.restaurant.addRestaurantProduct(item);
        }
        this.restaurant.removeRestaurantProduct(item);
    }

    //Change restaurant menu to a new one.
    public void changeMenu(List<Product> menu){
        this.restaurant.setProductList(menu);
    }

    //Precondition: products in order are all from the restaurant.
    //Receive order and record it. The stock reduces by given quantities in the order.
    public void receiveOrder(Order order){
        this.o_manager.addOrder(order);
        HashMap<Product, Integer> hashMap = order.getOrderProducts();
        for (Product key: hashMap.keySet()) {
            key.reduceProductStock(hashMap.get(key));
        }
    }
}
