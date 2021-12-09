package UseCases;

import Entity.Restaurant;
import org.junit.Before;
import org.junit.Test;
import java.util.List;
import static org.junit.Assert.*;

public class RestaurantListTest {
    private RestaurantList restaurantList;

    @Before
    public void setUp(){
        this.restaurantList = new RestaurantList();
    }

    @Test
    public void testRestaurantsGetter() {
        System.setProperty("isTest","111") ;
        List<Restaurant> restaurants =  restaurantList.restaurantsGetter();
        assertTrue(restaurants.size() != 0);
    }

    @Test
    public void testFindRestaurant() {
        String userPhone = "139516356663";
        Restaurant restaurant = restaurantList.findRestaurnat(userPhone);
        assertNotNull(restaurant);
    }

    @Test
    public void testFindRestaurant2() {
        String userPhone = "6666666666";
        Restaurant restaurant = restaurantList.findRestaurnat(userPhone);
        assertNull(restaurant);
    }
}