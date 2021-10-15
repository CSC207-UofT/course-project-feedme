/**
 * Test file for User class. Test all methods in User class.
 */

import Entity.*;
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

    @Test (timeout = 50)
    public void TestGetCustomerUserName() {
        assertEquals("Alex", customer.getUserName());
    }

    @Test (timeout = 50)
    public void TestGetRestaurantUserName() {
        assertEquals("Ramen", restaurant.getUserName());
    }

    @Test (timeout = 50)
    public void TestGetDeliveryPersonUserName() {
        assertEquals("Jack", deliveryperson.getUserName());
    }

    @Test (timeout = 50)
    public void TestGetCustomerPhone_num() {
        assertEquals("4168237263", customer.getUserPhone_num());
    }

    @Test (timeout = 50)
    public void TestGetRestaurantPhone_num() {
        assertEquals("4161234554", restaurant.getUserPhone_num());
    }

    @Test (timeout = 50)
    public void TestGetDeliveryPeronPhone_num() {
        assertEquals("4167892537", deliveryperson.getUserPhone_num());
    }

    @Test (timeout = 50)
    public void TestGetCustomerPassword() {
        assertEquals("asdf1234", customer.getUserPassword());
    }

    @Test (timeout = 50)
    public void TestGetRestaurantPassword() {
        assertEquals("sdfa89789", restaurant.getUserPassword());
    }

    @Test (timeout = 50)
    public void TestGetDeliveryPersonPassword() {
        assertEquals("1234567", deliveryperson.getUserPassword());
    }

    @Test (timeout = 50)
    public void TestGetCustomerUserType() {
        assertEquals('c', customer.getUserType());
    }

    @Test (timeout = 50)
    public void TestGetRestaurantUserType() {
        assertEquals('r', restaurant.getUserType());
    }

    @Test (timeout = 50)
    public void TestGetDeliveryPersonUserType() {
        assertEquals('d', deliveryperson.getUserType());
    }

}
