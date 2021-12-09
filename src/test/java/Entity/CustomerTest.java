package Entity;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CustomerTest {
    Customer customer;
    Customer customer2;
    Customer customer3;

    @Before
    public void setUp() {
        customer = new RegularCustomer("Alex", "4168237263","asdf1234", "c","St George", "r");
        customer = new RegularCustomer("Alex", "4168237263","asdf1234", "c", "St George");
        customer = new RegularCustomer("Alex", "4168237263","asdf1234", "St George");

        customer2 = new PremiumCustomer("Bob", "2168237263","asdf1234", "c","St George", "p");
        customer2 = new PremiumCustomer("Bob", "2168237263","asdf1234", "c", "St George");
        customer2 = new PremiumCustomer("Bob", "2168237263","asdf1234", "St George");

        customer3 = new Customer("Bob", "2168237263","asdf1234", "c","St George", "p");
        customer3 = new Customer("Bob", "2168237263","asdf1234", "c", "St George");
        customer3 = new Customer("Bob", "2168237263","asdf1234", "St George");
    }

    @Test
    public void testRegularCustomerGetterMethod() {
        assertEquals("Alex", customer.getUserName());
        assertEquals("4168237263", customer.getUserPhone_num());
        assertEquals("asdf1234", customer.getUserPassword());
        assertEquals("c", customer.getUserType());
        assertEquals("r", customer.getCustomerType());
        assertEquals("St George", customer.getCustomerAddress());
        assertEquals(0, customer.getOrderHistory().size());
    }

    @Test
    public void testPremiumCustomerGetterMethod() {
        assertEquals("Bob", customer2.getUserName());
        assertEquals("2168237263", customer2.getUserPhone_num());
        assertEquals("asdf1234", customer2.getUserPassword());
        assertEquals("c", customer2.getUserType());
        assertEquals("p", customer2.getCustomerType());
        assertEquals("St George", customer2.getCustomerAddress());
        assertEquals(0, customer2.getOrderHistory().size());
    }
}
