package Entity;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class DeliveryPersonTest {
    DeliveryPerson deliveryperson;

    @Before
    public void setUp() {
        deliveryperson = new DeliveryPerson("Jack", "132032474232", "rte567", "d", "w");
    }

    @Test
    public void testDeliveryPersonGetter() {
        assertEquals("Jack", deliveryperson.getUserName());
        assertEquals("132032474232", deliveryperson.getUserPhone_num());
        assertEquals("rte567", deliveryperson.getUserPassword());
        assertEquals("d", deliveryperson.getUserType());
        assertEquals("w", deliveryperson.getTransport());
        assertEquals(0, deliveryperson.getOrderHistory().size());
    }
}
