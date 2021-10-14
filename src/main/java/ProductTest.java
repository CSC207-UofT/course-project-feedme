package java; /**
 * Test for the Order class
 */

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.Product;
import java.util.ArrayList;
import java.util.List;

public class ProductTest {
    Product prod;

    @Before
    public void setUp(){
        prod = new Product("fried chicken", 1, 30, 3 );
    }

    @Test
    public void TestProductName() {
        assertEquals("fried chicken", prod.getProductName());
    }

    @Test
    public void TestProductID(){
        assertEquals(1, prod.getProductId());
    }

    @Test
    public void TestProductPrice(){
        assertEquals(30, prod.getProductPrice(), 0.5);
    }

    @Test
    public void TestProductStock(){
        assertEquals(3, prod.getProductStock());
    }
}

