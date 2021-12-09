package UseCases;
import Entity.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

/**
 * Represents the entire system of Order.
 */
public class OrderManager {
    private final List<Order> orderList;
    private final List<DeliveryPerson> availableDeliveryPersonList;

    /**
     * Creates a OrderManager with lists of Order and DeliveryPerson.
     */
    public OrderManager() {
        this.orderList = new ArrayList<>();
        this.availableDeliveryPersonList = new ArrayList<>();

        //create default orders
        Order order = new Order("order1");
        orderList.add(order);

        Order order_2 = new Order("order2");
        orderList.add(order_2);
    }

    /**
     * Stores the order in this Order's order list.
     * @param order Order to be added
     */
    public void addOrder(Order order) {
        orderList.add(order);
    }

    /**
     * Stores the deliveryPerson in this Order's available delivery person list.
     * @param deliveryPerson DeliveryPerson to be added
     */
    public void addDeliveryPerson(DeliveryPerson deliveryPerson) {
        availableDeliveryPersonList.add(deliveryPerson);
    }
    /**
     * Match DeliveryPerson with Order due to different type of Customer. Regular Customer will match delivery person
     * randomly while Premium Customer will match delivery person who ride a bike or drive a car􏱉 firstly (General􏰿y,
     * people 􏱁who ride a bike or drive a car􏱉 are faster than 􏱁walking􏱊􏱂).
     * @param order Order need to deliver
     */
    public boolean matchDeliveryPerson(Order order) {
        if (availableDeliveryPersonList.size() == 0) {
            return false;
        }
        if (Objects.equals(order.getCustomerInfo().get(0), "r")) {
            Random rand = new Random();
            DeliveryPerson deliveryPerson = availableDeliveryPersonList.get(rand.nextInt(availableDeliveryPersonList.size()));
            order.addDeliveryPersonInfo(deliveryPerson);
            availableDeliveryPersonList.remove(deliveryPerson);
            return true;
        }
        ArrayList<DeliveryPerson> list = new ArrayList<>();
        for ( DeliveryPerson deliveryPerson: availableDeliveryPersonList) {
            if (!Objects.equals(deliveryPerson.getTransport(), "w")) {
                list.add(deliveryPerson);
            }
        }
        if (list.size()!=0) {
            Random rand = new Random();
            DeliveryPerson deliveryPerson = list.get(rand.nextInt(list.size()));
            order.addDeliveryPersonInfo(deliveryPerson);
            availableDeliveryPersonList.remove(deliveryPerson);
            return true;
        }
        Random rand = new Random();
        DeliveryPerson deliveryPerson = availableDeliveryPersonList.get(rand.nextInt(availableDeliveryPersonList.size()));
        order.addDeliveryPersonInfo(deliveryPerson);
        availableDeliveryPersonList.remove(deliveryPerson);
        return true;
    }

    public List<Order> getAllOrders() {
        return orderList;
    }

    public Order getOrderById(String id) {
        for (Order order : orderList) {
            if (order.getOrderId().equals(id)) {
                return order;
            }
        }
        return  null;
    }

    public void updateOrderDeliveryPerson(String currentOrderId, String user_phonenum) {
        Order currentOrder = getOrderById(currentOrderId);
        currentOrder.addDeliveryPersonInfo(user_phonenum);
    }
}
//
//    private HashMap<Product, Integer> orderHashMap;
//
//    public OrderManager(){ this.orderHashMap = new HashMap<Product, Integer>(); }
//
//    public boolean verifyProductName(Restaurant restaurant, String productName) {
//        for (Product product: restaurant.getRestaurantMenu()) {
//            if (product.getProductName().equals(productName)) {
//                return true;
//            }
//        }
//        return false;
//    }
//
//    public Product productNameToProduct(Restaurant restaurant, String productName) {
//        for (Product product: restaurant.getRestaurantMenu()) {
//            if (product.getProductName().equals(productName)) {
//                return product;
//            }
//        }
//        return null;
//    }
//
//    public boolean checkStockAvailability(Product product, Integer quantity) {
//        return quantity >= product.getProductStock();
//    }
//
//    public void matchDeliveryMan() {
//
//    }


