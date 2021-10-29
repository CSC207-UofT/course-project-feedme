package UseCases;

import Entity.Order;

import java.util.HashMap;

public class OrderManager {
    // TODO implement Command Design Pattern
    HashMap<String, Order> OrderHistroy;

    public OrderManager(){ this.OrderHistroy = new HashMap<String, Order>(); }

    public boolean createOrder(String id, Order order) {
        if (! this.OrderHistroy.containsKey(id)) {
            this.OrderHistroy.put(id, order);
            return true;
        }
        return false;
    }
}
