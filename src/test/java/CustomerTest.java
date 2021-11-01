import Entity.*;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class CustomerTest {
    private Customer customer;

    @Before
    public void setUp() {
        customer = new Customer("Jenny", "St George","2508862345","asdfa132", 'c');
    }


    @Test
    public void testGetCustomerAddress() {
        assertEquals("St George", customer.getCustomerAddress());
    }



}
