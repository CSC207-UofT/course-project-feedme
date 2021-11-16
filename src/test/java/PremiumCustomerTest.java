import Entity.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PremiumCustomerTest {
    private PremiumCustomer customer;

    @Before
    public void setUp() {
        customer = new PremiumCustomer("Jenny", "2502094357","abc123","St George");
    }


    @Test
    public void testGetCustomerAddress() {
        assertEquals("St George", customer.getCustomerAddress());
    }

    @Test
    public void testGetUserType() {
        assertEquals("c", customer.getUserType());
    }

    @Test
    public void testGetCustomerType() {
        assertEquals("p", customer.getCustomerType());
    }
}
