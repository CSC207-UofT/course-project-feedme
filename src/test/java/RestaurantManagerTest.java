
import Entity.Product;
import Entity.Restaurant;
import UseCases.RestaurantManager;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class RestaurantManagerTest {
    Restaurant mcDonald;
    RestaurantManager mcDonaldController;

    @Before
    public void setUp() {
        mcDonald = new Restaurant("mcDonald", "1234567890", "456787654", "r", "11 Yonge st.W");
        mcDonaldController = new RestaurantManager(mcDonald);
    }

    @Test
    public void testCreateProduct() {
        Product fried_chicken = new Product("Fried Chicken", "0", 22.3, 5);
        Product big_mac = new Product("Big Mac", "1", 10.5, 1000);
        Product mc_flurry = new Product("Mc_Flurry", "2", 5.0, 1);
        assertEquals(mcDonaldController.createProduct("Fried Chicken", 22.3, 5), fried_chicken);
        assertEquals(mcDonaldController.createProduct("Big Mac", 10.5, 1000), big_mac);
        assertEquals(mcDonaldController.createProduct("Mc_Flurry", 5.0, 1), mc_flurry);

    }


    @Test
    public void testProductMap() {
        Product fried_chicken = new Product("Fried Chicken", "0", 22.3, 5);
        Product big_mac = new Product("Big Mac", "1", 10.5, 1000);
        Product mc_flurry = new Product("Mc_Flurry", "2", 5.0, 1);
        mcDonald.addProductToMenu(fried_chicken);
        mcDonald.addProductToMenu(big_mac);
        assertEquals(mcDonaldController.ProductMap(mcDonald.getRestaurantMenu()).get("0"), fried_chicken);
        assertEquals(mcDonaldController.ProductMap(mcDonald.getRestaurantMenu()).get("1"), big_mac);
        assertEquals(mcDonaldController.ProductMap(mcDonald.getRestaurantMenu()).get("2"), mc_flurry);

    }


    @Test
    public void testFindProduct() {
        Product fried_chicken = new Product("Fried Chicken", "0", 22.3, 5);
        Product big_mac = new Product("Big Mac", "1", 10.5, 1000);
        Product mc_flurry = new Product("Mc_Flurry", "2", 5.0, 1);
        mcDonald.addProductToMenu(fried_chicken);
        mcDonald.addProductToMenu(big_mac);
        assertEquals(mcDonaldController.findProduct("0"), fried_chicken);
        assertEquals(mcDonaldController.findProduct("1"), big_mac);
        assertEquals(mcDonaldController.findProduct("2"), mc_flurry);

    }


    @Test
    public void testContainProduct() {
        Product fried_chicken = new Product("Fried Chicken", "0", 22.3, 5);
        Product big_mac = new Product("Big Mac", "1", 10.5, 1000);
        Product mc_flurry = new Product("Mc_Flurry", "2", 5.0, 1);
        mcDonald.addProductToMenu(fried_chicken);
        mcDonald.addProductToMenu(big_mac);
        assertTrue(mcDonaldController.containProduct("0"));
        assertTrue(mcDonaldController.containProduct("1"));
        assertTrue(mcDonaldController.containProduct("2"));
        assertFalse(mcDonaldController.containProduct("3"));
        assertFalse(mcDonaldController.containProduct("-1"));

    }


    @Test
    public void testDistributeOrder() {
        Product fried_chicken = new Product("Fried Chicken", "0", 22.3, 5);
        Product big_mac = new Product("Big Mac", "1", 10.5, 1000);
        Product mc_flurry = new Product("Mc_Flurry", "2", 5.0, 1);
        List<Object> empty_lst = new ArrayList<>();
        mcDonald.addProductToMenu(fried_chicken);
        mcDonald.addProductToMenu(big_mac);
        assertEquals(mcDonaldController.distributeOrder(), empty_lst);

    }
}