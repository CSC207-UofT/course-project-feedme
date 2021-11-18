package Controller;

import Entity.DeliveryPerson;
import Entity.Order;
import Entity.User;
import UseCases.DeliveryManager;
import UseCases.RestaurantManager;

import java.util.List;
import java.util.ArrayList;

public class DeliverySystemController {
    public ArrayList<Order> readyToDistribute;
    private DeliveryManager deliveryManager;

    public DeliverySystemController(DeliveryManager deliver_manger){
        this.readyToDistribute = new ArrayList<Order>();
    }

    private ArrayList<Order> getReadyToChoose() {return readyToDistribute;}

    //Update delivery person information
    public boolean CreateDeliveryPerson(String name, String phone_num, String password) {
        DeliveryPerson newDeliveryPerson = new DeliveryPerson(name, phone_num, password, 'd');
        return deliveryManager.createDeliveryPerson(newDeliveryPerson);
    }

//choose one order from Restaurant ready to distribute in order history
    public void chooseOrder (Order order) {

        for (Order chosen_order : readyToDistribute) {
            System.out.println(chosen_order);
        }
    }

//set order status to "delivered" and store the order in order history
        public void deliverOrder (Order order){
        order.setOrderStatus("delivered");
        this.readyToDistribute.remove(order);
        System.out.println("Hi, your take-out has been delivered");
    }
}
