package entity;

import Entity.Customer;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CustomerTest {
    private Customer customer;

    @Before
    public void setUp() {
        customer = new Customer("jenny", "4373431298","abc1234",'a', "st george");
    }

    @Test
    public void testGetCustomerAddress() {
        assertEquals("st george", customer.getCustomerAddress());
    }
}
