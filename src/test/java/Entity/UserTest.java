package Entity;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class UserTest {
    User customer;
    User restaurant;
    User deliveryperson;

    @Before
    public void setUp() {
        customer = new RegularCustomer("Alex", "4168237263","asdf1234", "c","St George");
        restaurant = new Restaurant("Ramen", "25443534534", "sdfa89789", "r", "7 St Mary St");
        deliveryperson = new DeliveryPerson("Jack", "132032474232", "rte567", "d", "w");
    }

    @Test
    public void testCustomerGetterMethod() {
        assertEquals("Alex", customer.getUserName());
        assertEquals("4168237263", customer.getUserPhone_num());
        assertEquals("asdf1234", customer.getUserPassword());
        assertEquals("c", customer.getUserType());
        assertEquals("r", ((RegularCustomer) customer).getCustomerType());
        assertEquals(0, customer.getOrderHistory().size());
    }

    @Test
    public void testRestaurantGetterMethod() {
        assertEquals("Ramen", restaurant.getUserName());
        assertEquals("25443534534", restaurant.getUserPhone_num());
        assertEquals("sdfa89789", restaurant.getUserPassword());
        assertEquals("r", restaurant.getUserType());
        assertEquals(0, restaurant.getOrderHistory().size());
    }

    @Test
    public void testDeliveryPersonGetterMethod() {
        assertEquals("Jack", deliveryperson.getUserName());
        assertEquals("132032474232", deliveryperson.getUserPhone_num());
        assertEquals("rte567", deliveryperson.getUserPassword());
        assertEquals("d", deliveryperson.getUserType());
        assertEquals("w", ((DeliveryPerson) deliveryperson).getTransport());
        assertEquals(0, deliveryperson.getOrderHistory().size());
    }
}
