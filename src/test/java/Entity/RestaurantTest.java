package Entity;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class RestaurantTest {
    Restaurant popeyes;

    @Before
    public void setUp() {
        popeyes = new Restaurant("Popeyes", "35479853433", "jhb12", "r", "645 Yonge St");
    }

    @Test
    public void testRestaurantAddress() {
        assertEquals("645 Yonge St", popeyes.getRestaurantAddress());
    }

    @Test
    public void testRestaurantToString() {
        assertEquals("Popeyes", popeyes.toString());
    }

    @Test
    public void testAddProduct() {
        Product ten_wings = new Product("10 Wings", "1", 16.49, 2);
        Product tender_combo = new Product("Tender Combo", "2", 11.79, 2);
        assertTrue(popeyes.addProductToMenu(ten_wings));
        assertFalse(popeyes.addProductToMenu(ten_wings));
        assertTrue(popeyes.addProductToMenu(tender_combo));
    }

    @Test
    public void testRemoveProduct() {
        Product ten_wings = new Product("10 Wings", "1", 16.49, 2);
        Product tender_combo = new Product("Tender Combo", "2", 11.79, 2);
        popeyes.addProductToMenu(ten_wings);
        assertTrue(popeyes.removeProductFromMenu(ten_wings));
        assertFalse(popeyes.removeProductFromMenu(tender_combo));
    }

    @Test
    public void testGetRestaurantMenu() {
        Product ten_wings = new Product("10 Wings", "1", 16.49, 2);
        Product tender_combo = new Product("Tender Combo", "2", 11.79, 2);
        popeyes.addProductToMenu(ten_wings);
        popeyes.addProductToMenu(tender_combo);
        assertEquals(2, popeyes.getRestaurantMenu().size());
    }
}