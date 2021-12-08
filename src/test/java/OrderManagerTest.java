import Entity.*;
import UseCases.OrderManager;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class OrderManagerTest {
    OrderManager om;
    Order order_1;
    Product ten_wings;
    Restaurant popeyes;
    Customer customer;
    DeliveryPerson deliveryPerson;

    @Before
    public void setUp() {
        om = new OrderManager();
        order_1 = new Order("1");
        ten_wings = new Product("10 Wings", "1", 16.49, 5);
        popeyes = new Restaurant("Popeyes", "5384975983", "abcd123", "r", "645 Yonge St");
        customer = new Customer("Jenny", "34579345534", "iojju564", "St George");
        deliveryPerson = new DeliveryPerson("James", "6437825641", "fwigyeg1", "d", "w");
    }


    @Test
    public void testMatchDeliveryPerson() {
        om.addDeliveryPerson(deliveryPerson);
        order_1.addProductToOrder(ten_wings, 1);
        om.addOrder(order_1);
        order_1.addRestaurantInfo(popeyes);
        order_1.addCustomerInfo(customer);
        assertTrue(om.matchDeliveryPerson(order_1));
    }

    @Test
    public void testGetOrderById() {
        om.addOrder(order_1);
        assertEquals(om.getOrderById("1"), order_1);
    }

    @Test
    public void testUpdateDeliveryPerson() {
        om.addOrder(order_1);
        om.updateOrderDeliveryPerson("1", deliveryPerson.getUserPhone_num());
        assertTrue(order_1.getDeliveryPersonInfo().contains(deliveryPerson.getUserPhone_num()));
    }

    // public void testGetAllUndeliveredOrders() {
     //   om.addOrder(order_1);
       // om.addOrder(undelivered_order);
       // om.getAllOrders()
}