package Entity;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ProductTest {
    Product ten_wings;

    @Before
    public void setUp() {
        ten_wings = new Product("10 Wings", "1", 16.49, 5);
    }

    @Test
    public void testGetProductName() {
        assertEquals("10 Wings", ten_wings.getProductName());
    }

    @Test
    public void testGetProductId() {
        assertEquals("1", ten_wings.getProductId());
    }

    @Test
    public void testGetProductPrice() {
        assertEquals(16.49, ten_wings.getProductPrice(), 0);
    }

    @Test
    public void testGetProductStock() {
        assertEquals(5, ten_wings.getProductStock());
    }

    @Test
    public void testUpdateStock() {
        ten_wings.updateStock(10);
        assertEquals(15, ten_wings.getProductStock());
    }
}