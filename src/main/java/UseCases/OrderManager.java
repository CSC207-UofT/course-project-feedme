package UseCases;

import Entity.Order;
import java.util.HashMap;

public class OrderManager {
    protected HashMap<String, Order> orderList;

    public OrderManager() {
        this.orderList = new HashMap<>();
    }

    //Add order to the list of order.
    public void addOrder(Order item) {
        String o_id = item.getOrderId();
        if (!orderList.containsKey(o_id)) {
            this.orderList.put(o_id, item);
        }
    }

    //Create a new order and add it into the list of order(order history).
    public void createOrder(String o_id){
        Order item = new Order(o_id);
        addOrder(item);
    }

    //Delete order from the list.
    public void deleteOrder(Order item) {
        String o_id = item.getOrderId();
        if (orderList.containsKey(o_id)) {
            this.orderList.remove(o_id);
        }
    }

    //Return the list of orders.
    public HashMap<String, Order> displayOrders() {
        return this.orderList;
    }

    //Change order status to state if the current status is not state.
    public void changeOrderStatus(Order item, String state){
        if(!state.equals(item.getOrderStatus())){
            item.setOrderStatus(state);
        }
    }

}
