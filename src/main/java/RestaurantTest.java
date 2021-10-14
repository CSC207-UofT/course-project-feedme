package java;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class RestaurantTest{
    Restaurant store;

    @Before
    public void setUp(){
        store = new Restaurant("feedit", "Toronto", 12, 1234567890, 110, 'c');
        Product food1 = new Product("fired chicken", 1, 30, 2);
        store.addRestaurantProducts(food1);
    }

    @Test
    public void TestRestaurantAddress(){
        assertEquals("Toronto", store.getRestaurantAddress());
    }

    @Test
    public void TestgetRestaurantProducts(){
        List<Product> lst_prod = new ArrayList<>();
        lst_prod.add(new Product("fired chicken", 1, 30, 2));
        assertEquals(lst_prod, store.getRestaurantProducts());
    }
}