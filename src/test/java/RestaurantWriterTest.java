import Entity.Product;
import Entity.Restaurant;
import UseCases.RestaurantGatherer;
import UseCases.RestaurantWriter;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RestaurantWriterTest {
    RestaurantWriter rw = new RestaurantWriter();
    @Before
    public void setup(){

    }

    @Test
    public void testWriteRestaurantWriterTest(){
        Product p1 = new Product("cow eye", "001", 1.2, 110);
        Product p2 = new Product("pig leg", "002", 2.1, 112);
        Restaurant r1 = new Restaurant("Bad boy restaurant","4374374377", "abcdef123", "r"
                , "1000 zxcv st.");
        r1.addProductToMenu(p1);
        r1.addProductToMenu(p2);
        rw.addRestaurant(r1);
        RestaurantGatherer rg = new RestaurantGatherer();
        Assert.assertEquals(rg.getRestaurants().size(), 4);
    }
}
