package UseCases;

import Entity.Customer;
import Entity.DeliveryPerson;
import Entity.Product;
import Entity.Restaurant;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UserReadWriteTest {
    private UserReadWrite userReadWrite;
    @Before
    public void setUp(){
        System.setProperty("isTest","111") ;
        userReadWrite = new UserReadWrite();
    }
    @Test
    public void readCustomers() {
        System.out.println("all customers : "+userReadWrite.readCustomers());
    }

    @Test
    public void readDpersons() {
        System.out.println("all deliveryPersons : "+userReadWrite.readDpersons());
    }

    @Test
    public void readRestaurants() {
        System.out.println("all Restaurants: "+userReadWrite.readRestaurants());
    }

    @Test
    public void updateCustomer() {
        List<Customer> customerList = userReadWrite.readCustomers();
        System.out.println("change before : "+customerList);
        String name = "Bob";
        String phone = "13951635666";
        String password = "asd081623A";
        String address = "princeton";
        Customer customer = new Customer(name,phone,password,address);
        customerList.add(customer);
        userReadWrite.updateCustomer(customerList);
        System.out.println("change after : "+customerList);
    }

    @Test
    public void updateDperson() {
        List<DeliveryPerson> dPersons = userReadWrite.readDpersons();
        System.out.println("change before : "+dPersons);
        String name = "Leo";
        String phone = "139516356665";
        String password = "asd081623AA";
        DeliveryPerson dPerson = new DeliveryPerson(name,phone,password);
        dPersons.add(dPerson);
        userReadWrite.updateDperson(dPersons);
        System.out.println("change after : "+dPersons);
    }

    @Test
    public void updateRestaurant() {
        List<Restaurant> restaurants = userReadWrite.readRestaurants();
        System.out.println("change before : "+restaurants);
        String name = "Loblaws";
        String phone = "139516356663";
        String password = "asd081623A3";
        String address = "princeton3";
        List<Product> products = new ArrayList<>();
        Product apples = new Product("apple","1",11.0f,200);
        Product oranges = new Product("orange","2",15.0f,200);
        Product juices = new Product("juice","3",8.0f,200);
        Product lemons = new Product("lemon","4",18.0f,200);
        Product coffees = new Product("coffee","5",25.0f,200);
        products.addAll(Stream.of(apples,oranges,juices,lemons,coffees).collect(Collectors.toList()));
        Restaurant restaurant = new Restaurant(name,phone,password,"r",address,products);
        restaurants.add(restaurant);
        userReadWrite.updateRestaurant(restaurants);
        System.out.println("change after : "+restaurants);
    }
}