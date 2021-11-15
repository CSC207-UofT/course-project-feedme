import Entity.Customer;
import Entity.PremiumCustomer;
import Entity.RegularCustomer;
import FactoryPattern.CustomerFactory;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CustomerFactoryTest {
    private Customer customer_1;
    private Customer customer_2;

    CustomerFactory customerFactory = new CustomerFactory();

    @Before
    public void setUp() {
        customer_1 = new Customer("Jenny", "St George","2508862345","asdfa132");
        customer_2 = new Customer("Tom", "761 Bay St","2346785835","asdfa132");
    }



    @Test
    public void testMakeCustomer() {
        assertTrue(customerFactory.makeCustomer("regular", customer_1) instanceof RegularCustomer);
        assertTrue(customerFactory.makeCustomer("premium", customer_1) instanceof PremiumCustomer);
    }
}
