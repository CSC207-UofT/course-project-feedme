import Entity.Customer;
import Entity.DeliveryPerson;
import Entity.Product;
import Entity.Restaurant;
import Gateway.UserReadWrite;

import java.util.List;

public class DisplayUsers {
    /**
     * this is a class specifically for debug purpose, that display all the user in Run.
     *
     * NO CLASSES SHOULD CALL THIS CLASS AT ALL. (FOR DEBUG PURPOSES ONLY)
     */
    public static void main(String[] args) {
        UserReadWrite urw = new UserReadWrite();
        List<Customer> c_lst = urw.readCustomers();
        List<Restaurant> r_lst = urw.readRestaurants();
        List<DeliveryPerson> d_lst = urw.readDpersons();

        System.out.println("this is all the user stored in Feed me database: ");
        System.out.println("Customers: ");
        for (Customer customer: c_lst){
            System.out.println("Customer name: "+ customer.getUserName() +
                               "; Phone number: "+ customer.getUserPhone_num() +
                               "; Password: " +customer.getUserPassword());
        }
        System.out.println("");
        System.out.println("");
        System.out.println("Restaurants: ");
        for (Restaurant restaurant: r_lst){
            System.out.println("Restaurant name: "+ restaurant.getUserName() +
                               "; Phone number: "+ restaurant.getUserPhone_num() +
                               "; Password: " +restaurant.getUserPassword());
            List<Product> menu = restaurant.getRestaurantMenu();
            System.out.println("Menu:");
            for (Product product: menu){
                System.out.println("1. " + product);
            }
            System.out.println("");
        }
        System.out.println("");
        System.out.println("Deliver Persons: ");
        for (DeliveryPerson deliveryPerson: d_lst){
            System.out.println("DeliverPerson name: "+ deliveryPerson.getUserName() +
                    "; Phone number: "+ deliveryPerson.getUserPhone_num() +
                    "; Password: " +deliveryPerson.getUserPassword());
        }

    }
}
