import Controller.DeliverController;
import Entity.*;
import UseCases.OrderManager;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class DeliverControllerTest {
    OrderManager om;
    Order order_1;
    List<Order> undeliveredOrder;

    Customer customer;
    DeliveryPerson deliveryPerson;
    DeliverController dc;

    @Before
    public void setUp() {
        om = new OrderManager();
        order_1 = new Order("1");
        List<Order> undeliveredOrder = new ArrayList<>();

        customer = new Customer("Jenny", "34579345534", "iojju564", "St George");
        deliveryPerson = new DeliveryPerson("James", "6437825641", "fwigyeg1", "d", "w");
        dc = new DeliverController();
        dc.setOrderManager(om);
    }


    @Test
    public void testGetAllUndeliveredOrder() {
        om.addOrder(order_1);
        assertTrue(dc.getAllUndeliveredOrders().contains(order_1));
    }
}