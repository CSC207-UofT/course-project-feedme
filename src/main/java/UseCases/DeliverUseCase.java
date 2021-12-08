package UseCases;

import Entity.Order;
import Entity.DeliveryPerson;
import Entity.User;

import java.util.List;
import java.util.ArrayList;

public class DeliverUseCase {

    private final List<DeliveryPerson> deliveryPeople = new ArrayList<>();
    private final List<Order> orderList = new ArrayList<>();

    OrderManager order_manager;

    //private Database database;

    public DeliverUseCase(OrderManager order_manager) {
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

}