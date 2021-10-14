package java;

import java.util.ArrayList;
import java.util.List;

public class OrderManager {
    protected List<Order> orderlist;

    public OrderManager() {
        this.orderlist = new ArrayList<>();
    }

    public void createOrder(Order item) {
        if(!orderlist.contains(item)){
            this.orderlist.add(item);
        };
    }

    public void deleteOrder(Order item) {
        if(orderlist.contains(item)){
            this.orderlist.remove(item);
        }
    }

    public List<Order> displayOrders() {
        return this.orderlist;
    }

}
