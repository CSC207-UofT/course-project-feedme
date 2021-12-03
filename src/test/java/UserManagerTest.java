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
        User customer = new Customer("Alex", "4168237263" ,"avg343", "c","11 Wellesley St E");
        um.createUser("4168237263", customer);
        assertTrue(um.verifyUser("4168237263", customer.getUserPassword()));
        assertTrue(um.userLookup("4168237263"));
    }

}