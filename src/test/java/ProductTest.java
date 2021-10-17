import Entity.Product;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ProductTest {
    Product ten_wings;
    Product tender_combo;

    @Before
    public void setUp() {
        ten_wings = new Product("10 Wings", "1", 16.49, 5);
        tender_combo = new Product("Tender Combo", "2", 11.79, 7);
    }

    @Test
    public void testGetProductName() {
        assertEquals("10 Wings", ten_wings.getProductName());
        assertEquals("Tender Combo",  tender_combo.getProductName());
    }

    @Test
    public void testGetProductId() {
        assertEquals("1", ten_wings.getProductId());
        assertEquals("2",  tender_combo.getProductId());
    }

}
