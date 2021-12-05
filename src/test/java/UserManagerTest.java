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
    public void  testCreateCustomer() {
//        String phone_number1 = "1261652712";
//        Customer customer1 = new Customer("Alex", phone_number1,"avg343", "c","11 Wellesley St E");
//        assertFalse(um.createCustomer(customer1.getUserName(), customer1.getUserPhone_num(),
//                customer1.getUserPassword(), customer1.getUserType(), customer1.getCustomerAddress()));
//        assertTrue(um.verifyUser(phone_number1, customer1.getUserPassword()));
//        assertTrue(um.userLookup(phone_number1));

        String phone_number2 = "5346789541";
        Customer customer2 = new Customer("Jimmy", phone_number2,"req12", "c","21 Grenville St");
        assertFalse(um.verifyUser(phone_number2, customer2.getUserPassword()));
        assertTrue(um.createCustomer(customer2.getUserName(), customer2.getUserPhone_num(),
                customer2.getUserPassword(), customer2.getUserType(), customer2.getCustomerAddress()));
    }
}