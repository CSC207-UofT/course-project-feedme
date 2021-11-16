import Entity.Customer;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CustomerTest {
    private Customer customer;

    @Before
    public void setUp() {
        customer = new Customer("jenny", "123" ,"asdf","c", "St George");
    }

    @Test
    public void testGetCustomerAddress() {
        assertEquals("St George", customer.getCustomerAddress());
    }
}
