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
        User customer = new Customer("Alex", "25 St. George St" ,"4168237263", "asdf1234","c");
        um.createUser("4168237263", customer);
        assertTrue(um.verifyUser("4168237263", customer.getUserPassword()));
        assertTrue(um.userLookup("4168237263"));
    }

}