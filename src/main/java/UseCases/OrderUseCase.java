package UseCases;

import Entity.Customer;
import Entity.Product;
import Entity.Restaurant;
import Entity.User;

import java.util.HashMap;
import java.util.Map;

public class OrderUseCase {

    private final Customer customer;
    private final Restaurant restaurant;
    private Map<Product, Integer> items;

    public OrderUseCase(String customerNum, String restaurantNum, Map<String, Integer> cart){
        UserManager userManager = new UserManager();
        this.customer = userManager.getCustomer(customerNum);
        this.restaurant = userManager.getRestaurant(restaurantNum);
        this.items = new HashMap<Product, Integer>();
    }

    public Product getProduct(String productName) {
        for (Product product: this.restaurant.getRestaurantMenu()){
            if()
        }
    }


}
