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
    public void cartToMap() {
        addToCart();
        Map<String, Integer> cartToMap =  cartUseCase.cartToMap();
        for(String key : cartToMap.keySet()){
            System.out.println(key +"\t\tquantity:\t" + cartToMap.get(key));
        }
    }

    @Test
    public void showRestaurantName() {
        System.out.println("showRestaurantName :" +cartUseCase.showRestaurantName());
    }

    @Test
    public void showMenu() {
        System.out.println("showMenu :" +cartUseCase.showMenu());
    }

    @Test
    public void verifyProductNum() {
        addToCart();
        String productINdex = "1";
        assertTrue(cartUseCase.verifyProductNum(productINdex));
    }

    @Test
    public void getProductName() {
        addToCart();
        String productINdex = "1";
        assertEquals(cartUseCase.getProductName(productINdex),"apple");
    }

    @Test
    public void addToCart() {
        cartUseCase.addToCart("apple",1);
    }
}