import Entity.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

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
        popeyes = new Restaurant("Popeyes", "34579843534", "abcd123", "r", "645 Yonge St");
        macdonalds = new Restaurant("Macdonald's", "23194843234", "sfa321", "r", "125 Yonge St");
        ten_wings = new Product("10 Wings", "1", 16.49, 2);
        customer_1 = new Customer("Jenny", "2508862345", "dsf67", "c", "St George");
        customer_2 = new Customer("Tom", "5789435354", "asdfa132", "c", "St George");
        deliveryman_1 = new DeliveryPerson("James", "6437825641", "fwigyeg1", "d", "w");
        deliveryman_2 = new DeliveryPerson("Tony", "111111111", "fwigyeg1", "d","b");
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