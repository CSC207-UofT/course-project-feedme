package UseCases;

import Entity.*;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

public class UserManagerTest {
    UserManager um;

    @Before
    public void setUp() {
        System.setProperty("isTest","111") ;
        um = new UserManager();
    }

    @Test
    public void testCreateUser() {
        Random rnd = new Random();
        int phoneNum = 100000 + rnd.nextInt(900000);
        int phoneNum1 = 100000 + rnd.nextInt(900000);
        int phoneNum2 = 100000 + rnd.nextInt(900000);

        String username = "Leo";
        String password = "qwe123";
        String address = "Downtown Toronto";

        User user = new Customer(username,String.valueOf(phoneNum),password,"c", address);
        User user2 = new Restaurant(username,String.valueOf(phoneNum1),password,"r", address);
        User user3 = new DeliveryPerson(username,String.valueOf(phoneNum2),password, "d");

        um.createUser(user.getUserName(), user.getUserPhone_num(), user.getUserPassword(), user.getUserType(), address);
        um.createUser(user2.getUserName(), user2.getUserPhone_num(), user2.getUserPassword(), user2.getUserType(), address);
        um.createUser(user3.getUserName(), user3.getUserPhone_num(), user3.getUserPassword(), user3.getUserType(), null);
    }

    @Test
    public void testUpdateUser() {
        Random rnd = new Random();
        int phone = 100000 + rnd.nextInt(900000);

        String username = "Bob";
        String password = "qaz234";
        String address = "Airports";

        User user = new Customer(username,String.valueOf(phone),password,address);
        User user2 = new Restaurant(username,String.valueOf(phone),password,"r", address);
        User user3 = new DeliveryPerson(username,String.valueOf(phone),password,address);

        um.updateUser(user);
        um.updateUser(user2);
        um.updateUser(user3);
    }

    @Test
    public void testAddUser() {
        Random rnd = new Random();
        int phoneNum = 100000 + rnd.nextInt(900000);

        String username = "Allen";
        String password = "abc123";
        String address = "11 Bay St";

        Customer user1 = new Customer(username,String.valueOf(phoneNum),password,address);
        Restaurant user2 = new Restaurant(username, String.valueOf(phoneNum), password, "r", address);
        DeliveryPerson user3 = new DeliveryPerson(username, String.valueOf(phoneNum), password, "d");
        um.addUser(String.valueOf(phoneNum),user1);
        um.addUser(String.valueOf(phoneNum),user2);
        um.addUser(String.valueOf(phoneNum),user3);
    }

    @Test
    public void testGetCustomer() {
        String customerNum = "6470000000";
        assert um.getCustomer(customerNum) != null;

        String customerNum2 = "6470000000not";
        assert um.getCustomer(customerNum2) == null;
    }

    @Test
    public void testGetRestaurant() {
        String restaurantNum = "139516356663";
        assert um.getRestaurant(restaurantNum) != null;

        String restaurantNumNotExist = "139516356663not";
        assert um.getRestaurant(restaurantNumNotExist) == null;
    }

    @Test
    public void testUserLookup() {
        String phoneNum = "6470000000";
        assertTrue(um.userLookup(phoneNum));
    }

    @Test
    public void testGetType() {
        String phoneNum = "6470000000";
        assertEquals(um.getType(phoneNum),"c");
    }

    @Test
    public void testVerifyUser() {
        String username = "6470000000";
        String pass = "dummy11111";
        assertTrue(um.verifyUser(username,pass));
        assertFalse(um.verifyUser("3245343244",pass));
    }

    @Test
    public void testUpdateUserOrderHistory() {
        String customerNum = "6470000000";
        String restaurantNum = "139516356663";
        Order order = new Order("1234567");
        um.updateUserOrderHistory(order,customerNum,restaurantNum);
    }
}