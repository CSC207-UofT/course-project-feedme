package Entity;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class DeliveryPersonTest {
    DeliveryPerson deliveryperson;

    @Before
    public void setUp() {
        deliveryperson = new DeliveryPerson("Jack", "132032474232", "rte567", "d", "w");
        deliveryperson = new DeliveryPerson("Jack", "132032474232", "rte567", "d");
        deliveryperson = new DeliveryPerson("Jack", "132032474232", "rte567");
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

    @Test
    public void testToString() {
        assertNotNull(deliveryperson.toString());
    }
}
