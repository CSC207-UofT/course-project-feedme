package UseCases;

import org.junit.Before;
import org.junit.Test;
import java.util.Map;
import static org.junit.Assert.*;

public class CartUseCaseTest {

    private CartUseCase cartUseCase;
    @Before
    public void setUp(){
        System.setProperty("isTest","111") ;
        String restaurantNum = "139516356663";
        cartUseCase = new CartUseCase(restaurantNum);
    }

    @Test
    public void testCartToMap() {
        addToCart();
        Map<String, Integer> cartToMap =  cartUseCase.cartToMap();
        for(String key : cartToMap.keySet()){
            System.out.println(key +"\t\tquantity:\t" + cartToMap.get(key));
        }
    }

    @Test
    public void testShowRestaurantName() {
        System.out.println("showRestaurantName :" +cartUseCase.showRestaurantName());
    }

    @Test
    public void testShowMenu() {
        System.out.println("showMenu :" +cartUseCase.showMenu());
    }

    @Test
    public void testVerifyProductNum() {
        addToCart();
        String productIndex = "1";
        assertTrue(cartUseCase.verifyProductNum(productIndex));
    }

    @Test
    public void testGetProductName() {
        addToCart();
        String productIndex = "1";
        assertEquals(cartUseCase.getProductName(productIndex),"apple");
    }

    @Test
    public void addToCart() {
        cartUseCase.addToCart("apple",1);
        cartUseCase.addToCart("apple",1);
    }

    @Test
    public void testCheckStockAvailability() {
        assertTrue(cartUseCase.checkStockAvailability("apple", 2));
        assertFalse(cartUseCase.checkStockAvailability("apple", 201));
        assertFalse(cartUseCase.checkStockAvailability("coke", 1));
    }

    @Test
    public void testToString() {
        assertNotNull(cartUseCase.toString());
    }
}