package UseCases;

import Entity.Restaurant;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BrowsingUseCaseTest {
    private BrowsingUseCase browsingUseCase ;

    @Before
    public void setUp(){
        System.setProperty("isTest","111") ;
        browsingUseCase = new BrowsingUseCase();
    }
    @Test
    public void showRestaurants() {
        System.out.println("showRestaurants is : "+browsingUseCase.showRestaurants());
    }

    @Test
    public void getRestaurant() {
        String phone = "7";
        String restaurant = browsingUseCase.getRestaurant(phone);
        assertEquals(restaurant ,"139516356663");
    }

    @Test
    public void verifyRestautantSeleciton() {
        String index = "7";
        boolean exist = browsingUseCase.verifyRestautantSeleciton(index);
        assertTrue(exist);
    }

    @Test
    public void showRestaurantName() {
        String index = "7";
        String restaurantName = browsingUseCase.showRestaurantName(index);
        System.out.println(" restaurantName: " +  restaurantName);
    }

    @Test
    public void showMenu() {
        String index = "7";
        String menus = browsingUseCase.showMenu(index);
        System.out.println("menus  : \n"+menus);
    }

    @Test
    public void restaurantNum() {
        Restaurant restaurant = new Restaurant("name","130","asdf","r","adddress");
        String userPhone = browsingUseCase.restaurantNum(restaurant);
        assertEquals(userPhone , "130");
    }
}