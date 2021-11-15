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
        popeyes = new Restaurant("Popeyes", "645 Yonge St", "0123456789", "abcd123", "r");
        customer = new Customer("Jenny", "St George", "2508862345", "asdfa132");
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
}
