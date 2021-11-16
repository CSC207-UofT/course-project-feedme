package Controller;
import Entity.Product;
import UseCases.RestaurantManager;
import Entity.Order;

import java.util.List;
import java.util.ArrayList;


public class RestaurantSystemController {
    private final RestaurantManager resManger;
    public ArrayList<Order> readyToDistribute;

    public RestaurantSystemController(RestaurantManager resManger){
        this.resManger = resManger;
        this.readyToDistribute = new ArrayList<>();
    }

    private ArrayList<Order> getReadyToDistribute() {
        return readyToDistribute;
    }

    //return true if successfully edit the menu, false otherwise.
    public boolean editMenu(Product product, Boolean bool){
        return this.resManger.editRestaurantMenu(product, bool);
    }

    //set order status to "preparing" and store the order in order history and readyToDistribute list.
    public void receiveOrder(Order order){
        order.setOrderStatus("preparing");
        this.readyToDistribute.add(order);
        this.resManger.receiveOrder(order);
    }

    public List<Product>  displayMenu(){
        return this.resManger.getMenu();
    }

    //return the list of order which is ready to distribute and empty the readyToDistribute list.
    public ArrayList<Order> distributeOrder(){
        ArrayList<Order> readyToDistribute = getReadyToDistribute();
        this.readyToDistribute.removeAll(readyToDistribute);
        return readyToDistribute;
    }
}
