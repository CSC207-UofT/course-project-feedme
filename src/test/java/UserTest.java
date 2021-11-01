import Entity.Customer;
import Entity.DeliveryPerson;
import Entity.Restaurant;
import Entity.User;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserTest {
    User customer;
    User restaurant;
    User deliveryperson;

    @Before
    public void setUp() {
        customer = new Customer("Alex" ,"4168237263", "asdf1234","c", "25 St. George St");
        restaurant = new Restaurant("Ramen", "4161234554", "sdfa89789", "r", "7 St Mary St");
        deliveryperson = new DeliveryPerson("Jack", "4167892537", "1234567", "d");
    }

    @Test (timeout = 50)
    public void testGetCustomerUserName() {
        assertEquals("Alex", customer.getUserName());
    }

    @Test (timeout = 50)
    public void testGetRestaurantUserName() {
        assertEquals("Ramen", restaurant.getUserName());
    }

    @Test (timeout = 50)
    public void testGetDeliveryPersonUserName() {
        assertEquals("Jack", deliveryperson.getUserName());
    }

    @Test (timeout = 50)
    public void testGetCustomerPhone_num() {
        assertEquals("4168237263", customer.getUserPhone_num());
    }

    @Test (timeout = 50)
    public void testGetRestaurantPhone_num() {
        assertEquals("4161234554", restaurant.getUserPhone_num());
    }

    @Test (timeout = 50)
    public void testGetDeliveryPeronPhone_num() {
        assertEquals("4167892537", deliveryperson.getUserPhone_num());
    }

    @Test (timeout = 50)
    public void testGetCustomerPassword() {
        assertEquals("asdf1234", customer.getUserPassword());
    }

    @Test (timeout = 50)
    public void TestGetRestaurantPassword() {
        assertEquals("sdfa89789", restaurant.getUserPassword());
    }

    @Test (timeout = 50)
    public void testGetDeliveryPersonPassword() {
        assertEquals("1234567", deliveryperson.getUserPassword());
    }

    @Test (timeout = 50)
    public void testGetCustomerUserType() {
        assertEquals('c', customer.getUserType());
    }

    @Test (timeout = 50)
    public void testGetRestaurantUserType() {
        assertEquals('r', restaurant.getUserType());
    }

    @Test (timeout = 50)
    public void testGetDeliveryPersonUserType() {
        assertEquals('d', deliveryperson.getUserType());
    }

}
