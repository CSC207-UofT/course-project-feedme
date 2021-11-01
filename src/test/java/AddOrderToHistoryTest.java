import Entity.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AddOrderToHistoryTest {
    Restaurant popeyes;
    Restaurant macdonalds;
    Customer customer_1;
    Customer customer_2;
    DeliveryPerson deliveryman_1;
    DeliveryPerson deliveryman_2;
    Product ten_wings;
    Order order_1;

    @Before
    public void setUp() {
        popeyes = new Restaurant("Popeyes", "645 Yonge St", "0123456789", "abcd123", 'r');
        macdonalds = new Restaurant("Macdonald's", "125 Yonge St", "9876543210", "abcd123", 'r');
        ten_wings = new Product("10 Wings", "1", 16.49, 2);
        customer_1 = new Customer("Jenny", "St George", "2508862345", "asdfa132", 'c');
        customer_2 = new Customer("Tom", "St George", "1232332450", "asdfa132", 'c');
        deliveryman_1 = new DeliveryPerson("James", "6437825641", "fwigyeg1", 'd');
        deliveryman_2 = new DeliveryPerson("Tony", "111111111", "fwigyeg1", 'd');
        order_1 = new Order("1");
    }

    @Test
    public void testAddOrderToRestaurant() {
        order_1.addProductToOrder(ten_wings, 1);
        popeyes.addOrderToOrderHistory(order_1);
        customer_1.addOrderToOrderHistory(order_1);
        deliveryman_1.addOrderToOrderHistory(order_1);

        assertEquals(popeyes.getOrderHistory().size(), 1);
        assertEquals(customer_1.getOrderHistory().size(), 1);
        assertEquals(deliveryman_1.getOrderHistory().size(), 1);

        assertEquals(macdonalds.getOrderHistory().size(), 0);
        assertEquals(customer_2.getOrderHistory().size(), 0);
        assertEquals(deliveryman_2.getOrderHistory().size(), 0);
    }
}
