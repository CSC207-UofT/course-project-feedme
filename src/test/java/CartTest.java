import Entity.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class CartTest {
    Cart cart_1;

    @Before
    public void setUp() {
        cart_1 = new Cart();
    }

    @Test
    public void testRemoveProduct() {
        Product ten_wings = new Product("10 Wings", "1", 16.49, 5);
        Product tender_combo = new Product("Tender Combo", "2", 11.79, 7);

        assertTrue(cart_1.addProductToCart(ten_wings, 3));
        assertTrue(cart_1.removeProductFromCart(ten_wings, 2));
        assertFalse(cart_1.removeProductFromCart(ten_wings, 2));
        assertFalse(cart_1.removeProductFromCart(tender_combo, 1));
    }

    @Test
    public void testGetCartPrice() {
        Product ten_wings = new Product("10 Wings", "1", 16.49, 2);
        Product tender_combo = new Product("Tender Combo", "2", 11.79, 2);
        cart_1.addProductToCart(ten_wings, 1);
        cart_1.addProductToCart(tender_combo, 2);
//        System.out.println(cart_1);
        assertEquals(40.07, cart_1.getOrderPrice(), 0);
    }

}