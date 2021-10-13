/**
 * Test file for User class
 */

import Entity.*;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class UserTest {
    User user;

    @Before
    public void setUp() {
        user = new Customer("Alex", "25 St. George St" ,"4168237263", "asdf234", 'c');
    }
}
