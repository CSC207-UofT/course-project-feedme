import Entity.Customer;
import UseCases.UserManager;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertTrue;

public class UserManagerTest {
    UserManager um;

    @Before
    public void setUp() {
        um = new UserManager();
    }

    @Test
    public void testCreateUser() {
        Random rnd = new Random();
        int phone_number = 1000000000 + rnd.nextInt(900000000);
        Customer customer = new Customer("Alex", String.valueOf(phone_number) ,"avg343", "c","11 Wellesley St E");
        assertTrue(um.createCustomer(customer.getUserName(), customer.getUserPhone_num(),
                customer.getUserPassword(), customer.getUserType(), customer.getCustomerAddress()));
        assertTrue(um.verifyUser(String.valueOf(phone_number), customer.getUserPassword()));
        assertTrue(um.userLookup(String.valueOf(phone_number)));
    }

}