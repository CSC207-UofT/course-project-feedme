import Entity.Customer;
import Entity.User;
import UseCases.UserManager;
import UseCases.UserWriter;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class UserWriterTest {
    UserWriter uw = new UserWriter();
    @Before
    public void setup(){

    }

    @Test
    public void testUserWrtieIn(){
        User user = new Customer("edward", "6471231234", "abc123def", "c", "12 abc st.");
        uw.saveToFile(user);
        UserManager um = new UserManager();
        assertTrue(um.userLookup("6471231234"));
    }
}
