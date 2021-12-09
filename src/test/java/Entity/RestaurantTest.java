package Entity;

import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;

public class RestaurantTest {
    Restaurant popeyes;
    Restaurant kfc;
    Product ten_wings;
    Product tender_combo;
    List<Product> menu;

    @Before
    public void setUp() {
        ten_wings = new Product("10 Wings", "1", 16.49, 2);
        tender_combo = new Product("Tender Combo", "2", 11.79, 2);
        menu = new ArrayList<>();
        menu.add(ten_wings);
        popeyes = new Restaurant("Popeyes", "35479853433", "jhb12", "r", "645 Yonge St");
        kfc = new Restaurant("Popeyes", "35479853433", "jhb12", "r", "645 Yonge St", menu);
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
        assertTrue(popeyes.addProductToMenu(ten_wings));
        assertFalse(popeyes.addProductToMenu(ten_wings));
        assertTrue(popeyes.addProductToMenu(tender_combo));
    }

    @Test
    public void testRemoveProduct() {
        popeyes.addProductToMenu(ten_wings);
        assertTrue(popeyes.removeProductFromMenu(ten_wings));
        assertFalse(popeyes.removeProductFromMenu(tender_combo));
    }

    @Test
    public void testGetRestaurantMenu() {
        popeyes.addProductToMenu(ten_wings);
        popeyes.addProductToMenu(tender_combo);
        assertEquals(2, popeyes.getRestaurantMenu().size());
    }
}