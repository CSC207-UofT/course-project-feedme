import Entity.Customer;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CustomerTest {
    private Customer customer;

    @Before
    public void setUp() {
        customer = new Customer("jenny", "St George","2508862345","asdfa132", "c");
    }

    @Test
    public void testGetCustomerAddress() {
        assertEquals("St George", customer.getCustomerAddress());
    }
}
