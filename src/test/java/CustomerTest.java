import Entity.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CustomerTest {
    private Customer customer_1;

    @Before
    public void setUp() {
        customer_1 = new Customer("Jenny", "St George","2508862345","asdfa132");
    }


    @Test
    public void testGetCustomerAddress() {
        assertEquals("St George", customer_1.getCustomerAddress());
    }

    @Test
    public void testGetCustomerType() {
        assertEquals("c", customer_1.getUserType());
    }
}
