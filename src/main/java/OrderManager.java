package java;

import java.util.ArrayList;
import java.util.List;

public class OrderManager {
    protected List<Order> orderlist;

    public OrderManager() {
        this.orderlist = new ArrayList<>();
    }

    public void createOrder(Order item) {
        this.orderlist.add(item);
    }

    public void deleteOrder(Order item) {
        this.orderlist.remove(item);
    }

    public List<Order> getOrder() {
        return this.orderlist;
    }

}
