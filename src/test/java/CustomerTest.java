import Entity.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CustomerTest {
    private Customer customer_1;

    @Before
    public void setUp() {
        customer_1 = new Customer("Jenny", "2502094357","abc123","St George");
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
