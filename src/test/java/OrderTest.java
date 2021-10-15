

import Entity.Order;
import Entity.Product;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class OrderTest {
    Order order_1;

    @Before
    public void setUp() {
        order_1 = new Order("1");
    }

    @Test
    public void testRemoveProduct() {
        Product ten_wings = new Product("10 Wings", "1", 16.49, 5);
        Product tender_combo = new Product("Tender Combo", "2", 11.79, 7);
        assertTrue(order_1.addProductToOrder(ten_wings, 1));
        assertFalse(order_1.removeProductFromOrder(tender_combo, 3));
        assertFalse(order_1.removeProductFromOrder(ten_wings, 3));
    }

    @Test
    public void testGetOrderPrice() {
        Product ten_wings = new Product("10 Wings", "1", 16.49, 2);
        Product tender_combo = new Product("Tender Combo", "2", 11.79, 2);
        order_1.addProductToOrder(ten_wings, 1);
        order_1.addProductToOrder(tender_combo, 1);
        assertEquals(28.28, order_1.getOrderPrice(), 0.01);
    }

}
