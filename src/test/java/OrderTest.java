package src.test.java;

import Entity.Order;
import Entity.Product;
import Entity.Restaurant;
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
        Product ten_wings = new Product("10 Wings", "1", 16.49, 2);
        Product tender_combo = new Product("Tender Combo", "2", 11.79, 2);
        assertTrue(order_1.addProduct(ten_wings));
        assertFalse(order_1.removeProduct(tender_combo));
        assertTrue(order_1.removeProduct(ten_wings));
    }

    @Test
    public void testGetOrderPrice() {
        Product ten_wings = new Product("10 Wings", "1", 16.49, 2);
        Product tender_combo = new Product("Tender Combo", "2", 11.79, 2);
        order_1.addProduct(ten_wings);
        order_1.addProduct(tender_combo);
        assertEquals(28.28, order_1.getOrderPrice(), 0.001);
    }

}
