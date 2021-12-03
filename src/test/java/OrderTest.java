import Entity.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class OrderTest {
    Order order_1;

    @Before
    public void setUp() {
        order_1 = new Order("1");
    }

    @Test
    public void testRemoveProduct() {
        Product ten_wings = new Product("10 Wings", "1", 16.49, 5);
        Product tender_combo = new Product("Tender Combo", "2", 11.79, 7);

        assertTrue(order_1.addProductToOrder(ten_wings, 1));
        assertFalse(order_1.removeProductFromOrder(tender_combo, 3));
        assertFalse(order_1.removeProductFromOrder(ten_wings, 3));
    }

    @Test
    public void testGetOrderPrice() {
        Product ten_wings = new Product("10 Wings", "1", 16.49, 2);
        Product tender_combo = new Product("Tender Combo", "2", 11.79, 2);
        order_1.addProductToOrder(ten_wings, 1);
        order_1.addProductToOrder(tender_combo, 1);
        System.out.println(order_1);
        assertEquals(28.28, order_1.getOrderPrice(), 0.01);
    }

    @Test
    public void testAddInfo(){
        Restaurant popeyes = new Restaurant("Popeyes", "5437893432", "sdrd67", "r", "645 Yonge St");
        Customer customer = new Customer("Jenny", "43246823213","fdsd768","St George");
        DeliveryPerson deliveryman = new DeliveryPerson("James", "6437825641", "fwigyeg1", "d", "w");
        order_1.addRestaurantInfo(popeyes);
        order_1.addCustomerInfo(customer);
        order_1.addDeliveryPersonInfo(deliveryman);
        System.out.println(order_1.getRestaurantInfo());
        assertEquals(2, order_1.getCustomerInfo().size());
    }

}
