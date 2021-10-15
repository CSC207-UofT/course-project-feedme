package src.test.java; /**
 * Test file for User class
 */

import Entity.Customer;
import Entity.DeliveryPerson;
import Entity.Restaurant;
import Entity.User;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class UserTest {
    User customer;
    User restaurant;
    User deliveryperson;

    @Before
    public void setUp() {
        customer = new Customer("Alex", "25 St. George St" ,"4168237263", "asdf1234",'c');
        restaurant = new Restaurant("Ramen", "7 St Mary St", "4161234554", "sdfa89789", 'r');
        deliveryperson = new DeliveryPerson("Jack", "4167892537", "1234567", 'd');
    }

    @Test
    public void testCustomerConstructor() {
        assertEquals("Alex", customer.getUserName());
    }

    @Test
    public void testRestaurantConstructor() {
        assertEquals("4161234554", restaurant.getUserPhone_num());
    }

    @Test
    public void testDeliveryPersonConstructor() {
        assertEquals('d', deliveryperson.getUserType());
    }


}
