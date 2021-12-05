import Entity.Product;
import Entity.Restaurant;
import UseCases.RestaurantGatherer;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class RestaurantGatherTest {
    RestaurantGatherer rs = new RestaurantGatherer();
    ArrayList<Restaurant> list1;

    @Before
    public void setup(){
        list1 = (ArrayList<Restaurant>) rs.getRestaurants();

    }

    @Test
    public void testUsername(){
        assertEquals(list1.get(0).getUserName(), "Edward's resturant");
    }

    @Test
    public void testListItems(){
        ArrayList<Restaurant> test_list = new ArrayList<>();
        Product p1 = new Product("fish", "001", 30.2, 10);
        Product p2 = new Product("chicken", "002", 21.1, 2);
        Restaurant r1 = new Restaurant("Edward's resturant","647", "abc", "r"
                , "12 abc st.");
        r1.addProductToMenu(p1);
        Restaurant r2 = new Restaurant("Pig's resturant","416", "abc", "r"
                , "15 abc st.");
        r2.addProductToMenu(p2);
        test_list.add(r1);
        test_list.add(r2);
        for (int i=0; i < list1.size(); i++){
            assertEquals(list1.get(i).getUserPassword(), test_list.get(i).getUserPassword());
            assertEquals(list1.get(i).getUserName(), test_list.get(i).getUserName());
            assertEquals(list1.get(i).getUserType(), test_list.get(i).getUserType());
            assertEquals(list1.get(i).getRestaurantAddress(), test_list.get(i).getRestaurantAddress());
            assertEquals(list1.get(i).getRestaurantMenu().get(0).getProductPrice(), test_list.get(i).getRestaurantMenu().get(0).getProductPrice(), 0.5);
        }

            
    }
}



