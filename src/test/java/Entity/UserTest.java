package Entity;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class UserTest {
    User customer;
    User restaurant;
    User deliveryperson;
    Order order_1;
    Product ten_wings;

    @Before
    public void setUp() {
        customer = new RegularCustomer("Alex", "4168237263","asdf1234", "c","St George");
        customer = new RegularCustomer("Alex", "4168237263","asdf1234", "c","St George", "r");
        customer = new RegularCustomer("Alex", "4168237263","asdf1234", "St George");
        restaurant = new Restaurant("Ramen", "25443534534", "sdfa89789", "r", "7 St Mary St");
        deliveryperson = new DeliveryPerson("Jack", "132032474232", "rte567", "d", "w");
        order_1 = new Order("1");
        ten_wings = new Product("10 Wings", "1", 16.49, 5);
        order_1.addProductToOrder(ten_wings, 2);
    }

    @Test
    public void testCustomerGetterMethod() {
        assertEquals("Alex", customer.getUserName());
        assertEquals("4168237263", customer.getUserPhone_num());
        assertEquals("asdf1234", customer.getUserPassword());
        assertEquals("c", customer.getUserType());
        assertEquals("r", ((RegularCustomer) customer).getCustomerType());
        customer.addOrderToOrderHistory(order_1);
        assertEquals(1, customer.getOrderHistory().size());
        assertNotNull(customer.toString());
    }

    @Test
    public void testRestaurantGetterMethod() {
        assertEquals("Ramen", restaurant.getUserName());
        assertEquals("25443534534", restaurant.getUserPhone_num());
        assertEquals("sdfa89789", restaurant.getUserPassword());
        assertEquals("r", restaurant.getUserType());
        restaurant.addOrderToOrderHistory(order_1);
        assertEquals(1, restaurant.getOrderHistory().size());
    }

    @Test
    public void testDeliveryPersonGetterMethod() {
        assertEquals("Jack", deliveryperson.getUserName());
        assertEquals("132032474232", deliveryperson.getUserPhone_num());
        assertEquals("rte567", deliveryperson.getUserPassword());
        assertEquals("d", deliveryperson.getUserType());
        assertEquals("w", ((DeliveryPerson) deliveryperson).getTransport());
        deliveryperson.addOrderToOrderHistory(order_1);
        assertEquals(1, deliveryperson.getOrderHistory().size());
    }
}
