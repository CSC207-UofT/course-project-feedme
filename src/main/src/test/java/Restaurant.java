package src.test.java;

import Entity.Product;
import Entity.Restaurant;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class RestaurantTest {
    Restaurant popeyes;

    @Before
    public void setUp() {
        popeyes = new Restaurant("Popeyes", "645 Yonge St", "0123456789", "abcd123", 'r');
    }

    @Test
    public void testRestaurantAddress() {
        assertEquals("645 Yonge St", popeyes.getAddress());
    }

    @Test
    public void testAddProduct() {
        Product ten_wings = new Product("10 Wings", "1", 16.49, 2);
        Product tender_combo = new Product("Tender Combo", "2", 11.79, 2);
        assertTrue(popeyes.addProduct(ten_wings));
        assertFalse(popeyes.addProduct(ten_wings));
        assertTrue(popeyes.addProduct(tender_combo));
        assertEquals(2, popeyes.getProduct().size());
    }
}