import Entity.User;
import UseCases.UserGatherer;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;


public class UserGathererTest {
    UserGatherer ug = new UserGatherer();
    HashMap<String, User> map;
    @Before
    public void setup(){
        map = ug.loadCustomer();
    }

    @Test
    public void testUserType(){
        assertEquals(map.get("416").getUserType(), "c");
    }

    @Test
    public void testUserName(){
        assertEquals(map.get("416").getUserName(), "pauline");
    }

}
