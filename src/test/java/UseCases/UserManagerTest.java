package UseCases;

import Entity.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserManagerTest {
    Customer customer;
    Customer customer2;
    UserManager um;
    Restaurant popeyes;
    Restaurant kfc;
    DeliveryPerson deliveryPerson;

    @Before
    public void setUp() {
        um = new UserManager();
        customer = new Customer("Jenny", "34579345534", "iojju564", "St George");
        customer2 = new Customer("Bob", "21394832340", "iojju564", "St George");
        popeyes = new Restaurant("Popeyes", "35479853433", "jhb12", "r", "645 Yonge St");
        kfc = new Restaurant("KFC", "2343290193", "jhb12", "r", "1000 Bay St");
        deliveryPerson = new DeliveryPerson("James", "6437825641", "fwigyeg1", "d", "w");
    }

    @Test
    public void testCreateUser() {
        um.createUser(customer.getUserName(), customer.getUserPhone_num(), customer.getUserPassword(),
                customer.getUserType(), customer.getCustomerAddress());
        um.createUser(popeyes.getUserName(), popeyes.getUserPhone_num(), popeyes.getUserPassword(),
                popeyes.getUserType(), popeyes.getRestaurantAddress());
        um.createUser(deliveryPerson.getUserName(), deliveryPerson.getUserPhone_num(), deliveryPerson.getUserPassword(),
                deliveryPerson.getUserType(), null);
        assertTrue(um.verifyUser(customer.getUserPhone_num(), customer.getUserPassword()));
        assertTrue(um.verifyUser(popeyes.getUserPhone_num(), popeyes.getUserPassword()));
        assertTrue(um.verifyUser(deliveryPerson.getUserPhone_num(), deliveryPerson.getUserPassword()));
        assertFalse(um.verifyUser(customer2.getUserPhone_num(), customer2.getUserPassword()));
        assertFalse(um.verifyUser(kfc.getUserPhone_num(), kfc.getUserPassword()));
    }

    @Test
    public void testAddUser() {
        um.addUser(customer.getUserPhone_num(), customer);
        um.addUser(popeyes.getUserPhone_num(), popeyes);
        um.addUser(deliveryPerson.getUserPhone_num(), deliveryPerson);
        assertTrue(um.verifyUser(customer.getUserPhone_num(), customer.getUserPassword()));
        assertTrue(um.verifyUser(popeyes.getUserPhone_num(), popeyes.getUserPassword()));
        assertTrue(um.verifyUser(deliveryPerson.getUserPhone_num(), deliveryPerson.getUserPassword()));
        assertFalse(um.verifyUser(customer2.getUserPhone_num(), customer2.getUserPassword()));
        assertFalse(um.verifyUser(kfc.getUserPhone_num(), kfc.getUserPassword()));
    }

    @Test
    public void testGetUser() {
        um.addUser(customer.getUserPhone_num(), customer);
        um.addUser(popeyes.getUserPhone_num(), popeyes);
        assertEquals(customer.getUserPhone_num(), um.getCustomer(customer.getUserPhone_num()).getUserPhone_num());
        assertEquals(popeyes.getUserPhone_num(), um.getRestaurant(popeyes.getUserPhone_num()).getUserPhone_num());
    }

    @Test
    public void testUserLookup() {
        um.addUser(customer.getUserPhone_num(), customer);
        um.addUser(popeyes.getUserPhone_num(), popeyes);
        assertTrue(um.userLookup(customer.getUserPhone_num()));
        assertTrue(um.userLookup(popeyes.getUserPhone_num()));
        assertFalse(um.userLookup(customer2.getUserPhone_num()));
        assertFalse(um.userLookup(kfc.getUserPhone_num()));
    }

    @Test
    public void testGetType() {
        um.addUser(customer.getUserPhone_num(), customer);
        um.addUser(popeyes.getUserPhone_num(), popeyes);
        assertEquals("c", um.getType(customer.getUserPhone_num()));
        assertEquals("r", um.getType(popeyes.getUserPhone_num()));
    }
}
