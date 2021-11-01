import Entity.Product;
import Entity.Restaurant;
import UseCases.RestaurantManager;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class RestaurantManagerTest {
    Restaurant mcDonald;
    RestaurantManager mcDonaldController;

    @Before
    public void setUp(){
        mcDonald = new Restaurant("mcDonald", "11 yonge st.W", "456787654", "777777", 'r');
        mcDonaldController = new RestaurantManager(mcDonald);
    }

    @Test
    public void testEditRestaurantMenu(){
        Product fried_chicken = new Product("Fried Chicken", "007", 22.3, 5);
        Product big_mac = new Product("Big Mac", "001", 10.5, 1000);
        Product mc_flurry = new Product("Mc_Flurry", "000", 5.0, 1);
        mcDonald.addRestaurantProduct(fried_chicken);
        mcDonald.addRestaurantProduct(big_mac);
        assertTrue(mcDonaldController.editRestaurantMenu(big_mac, false));
        assertTrue(mcDonaldController.editRestaurantMenu(big_mac, true));
        assertFalse(mcDonaldController.editRestaurantMenu(mc_flurry, false));
        assertTrue(mcDonaldController.editRestaurantMenu(mc_flurry, true));
    }

    @Test
    public void testGetMenu(){
        Product fried_chicken = new Product("Fried Chicken", "007", 22.3, 5);
        Product big_mac = new Product("Big Mac", "001", 10.5, 0);
        Product mc_flurry = new Product("Mc_Flurry", "000", 5.0, 1);
        mcDonald.addRestaurantProduct(fried_chicken);
        mcDonald.addRestaurantProduct(big_mac);
        //.......
    }

}
