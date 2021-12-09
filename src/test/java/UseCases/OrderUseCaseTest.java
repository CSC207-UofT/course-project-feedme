package UseCases;

import Entity.Product;
import Gateway.UserReadWrite;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class OrderUseCaseTest {
    private OrderUseCase orderUseCase;

    @Before
    public void setUp(){

        System.setProperty("isTest","1");
        UserReadWrite userReadWrite = new UserReadWrite();

        String customerNum =  userReadWrite.readCustomers().get(0).getUserPhone_num();
        String restaurantNum = "139516356663";
        Map<String, Integer> cart = new HashMap<>();
        cart.put("apple",1);
        orderUseCase = new OrderUseCase(customerNum,restaurantNum,cart);
    }

    @Test
    public void testGetProduct() {
        Product product = orderUseCase.getProduct("apple");
        assertNotNull(product);
        Product product2 = orderUseCase.getProduct("apples");
        assertNull(product2);
    }

    @Test
    public void testMakeOrder() {
        orderUseCase.makeOrder();
    }
}