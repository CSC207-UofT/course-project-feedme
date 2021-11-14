package UseCases;

import Entity.Order;
import Entity.DeliveryPerson;

import java.util.List;
import java.util.ArrayList;

public class DeliveryManager {
    private final List<DeliveryPerson> deliveryPeople = new ArrayList<>();

    OrderManager order_manager;

    //private Database database;

    public DeliveryManager(OrderManager order_manager) {
        this.order_manager = order_manager;
    }

    public boolean createDeliveryPerson(DeliveryPerson deliveryPerson) {
        deliveryPeople.add(deliveryPerson);

        return true;
    }

    // return a list of delivery people
    public List<DeliveryPerson> getDeliveryPeople() {
        return this.deliveryPeople;
    }

    // updateCurrentOrder -> update currentOrder
    public void updateCurrentOrder(String currentOrderId, String deliveryPersonId) {
        // use deliveryId to find the DeliveryPerson from DB
//        DeliveryPerson deliveryPersonFromDB = database.getDeliveryPersonById(deliveryPersonId);
//        Order currentOrder = order_manager.getOrderById(currentOrderId);
//
//        deliveryPersonFromDB.setCurrentOrder(currentOrder);
//        database.saveDeliveryPerson(deliveryPersonFromDB);

        DeliveryPerson deliveryPerson = null;
        for (DeliveryPerson dp : deliveryPeople) {
            if (dp.getUserName().equals(deliveryPersonId)) {
                deliveryPerson = dp;
            }
        }

        Order currentOrder = order_manager.getOrderById(currentOrderId);

        deliveryPerson.setCurrentOrder(currentOrder);
        deliveryPerson.getOrderHistory().add(currentOrder);
    }
}

