import Entity.Product;
import Entity.Restaurant;
import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.*;

public class RestaurantTest {
    Restaurant popeyes;

    @Before
    public void setUp() {
        popeyes = new Restaurant("Popeyes", "35479853433", "jhb12", "r", "645 Yonge St");
        assertEquals("r", popeyes.getUserType());
    }

    @Test
    public void testRestaurantAddress() {
        assertEquals("645 Yonge St", popeyes.getRestaurantAddress());
    }

    @Test
    public void testAddProduct() {
        Product ten_wings = new Product("10 Wings", "1", 16.49, 2);
        Product tender_combo = new Product("Tender Combo", "2", 11.79, 2);
        assertTrue(popeyes.addProductToMenu(ten_wings));
        assertFalse(popeyes.addProductToMenu(ten_wings));
        assertTrue(popeyes.addProductToMenu(tender_combo));
        assertEquals(2, popeyes.getRestaurantMenu().size());
    }

    @Test
    public void testRemoveProduct() {
        Product ten_wings = new Product("10 Wings", "1", 16.49, 2);
        Product tender_combo = new Product("Tender Combo", "2", 11.79, 2);
        assertTrue(popeyes.addProductToMenu(ten_wings));
        assertTrue(popeyes.addProductToMenu(tender_combo));
        assertTrue(popeyes.removeProductFromMenu(ten_wings));
        assertEquals(1, popeyes.getRestaurantMenu().size());
    }
}