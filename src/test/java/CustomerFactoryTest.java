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
        customer_1 = new Customer("Jenny", "2347234324","fsa687","St George");
        customer_2 = new Customer("Tom", "4523967423","dsf789","761 Bay St");
    }



    @Test
    public void testMakeCustomer() {
        assertTrue(customerFactory.makeCustomer("regular", customer_1) instanceof RegularCustomer);
        assertTrue(customerFactory.makeCustomer("premium", customer_2) instanceof PremiumCustomer);
    }
}
