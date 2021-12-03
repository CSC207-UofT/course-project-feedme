import Entity.Customer;
import UseCases.UserManager;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class UserManagerTest {
    UserManager um;

    @Before
    public void setUp() {
        um = new UserManager();
    }

    @Test
    public void testCreateUser() {
        String phone_number = "1261652712";
        Customer customer = new Customer("Alex", phone_number,"avg343", "c","11 Wellesley St E");
        assertFalse(um.createCustomer(customer.getUserName(), customer.getUserPhone_num(),
                customer.getUserPassword(), customer.getUserType(), customer.getCustomerAddress()));
        assertTrue(um.verifyUser(phone_number, customer.getUserPassword()));
        assertTrue(um.userLookup(phone_number));
    }
}