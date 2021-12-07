package Entity;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CustomerTest {
    Customer customer;

    @Before
    public void setUp() {
        customer = new RegularCustomer("Alex", "4168237263","asdf1234", "c","St George");
    }

    @Test
    public void testCustomerGetterMethod() {
        assertEquals("Alex", customer.getUserName());
        assertEquals("4168237263", customer.getUserPhone_num());
        assertEquals("asdf1234", customer.getUserPassword());
        assertEquals("c", customer.getUserType());
        assertEquals("r", customer.getCustomerType());
        assertEquals(0, customer.getOrderHistory().size());
    }
}
