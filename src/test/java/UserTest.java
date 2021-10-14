/**
 * Test file for User class
 */

import Entity.*;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class UserTest {
    User customer;
    User restaurant;
    User deliveryperosn;

    @Before
    public void setUp() {
        customer = new Customer("Alex", "25 St. George St" ,"4168237263", "asdf1234",'c');
        restaurant = new Restaurant("Ramen", "7 St Mary St", "4161234554", "sdfa89789", 'r');
        deliveryperosn = new DeliveryPerson("Jack", "4167892537", "1234567", 'd');
    }

    @Test
    public void TestCustomerConstructor() {
        assertEquals("Alex", customer.getUserName());
    }

    @Test
    public void TestRestaurantConstructor() {
        assertEquals("4161234554", restaurant.getUserPhone_num());
    }

    @Test
    public void TestDeliveryPersonConstructor() {
        assertEquals('d', deliveryperosn.getUserType());
    }


}
