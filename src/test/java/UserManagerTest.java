import Entity.Customer;
import Entity.User;
import UseCases.UserManager;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class UserManagerTest {
    UserManager um;

    @Before
    public void setUp() {
        um = new UserManager();
    }

    @Test
    public void testCreateUser() {
        User customer = new Customer("Alex", "25 St. George St" ,"4168237263", "asdf1234",'c');
        assertTrue(um.verifyUser("0123456789", customer.getUserPassword()));
        assertTrue(um.userLookup("0123456789"));
    }

}