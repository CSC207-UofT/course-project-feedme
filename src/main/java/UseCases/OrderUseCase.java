package UseCases;

import Entity.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderUseCase {

    private final Customer customer;
    private final Restaurant restaurant;
    private final Map<Product, Integer> items;

    public OrderUseCase(String customerNum, String restaurantNum, Map<String, Integer> cart){
        UserManager userManager = new UserManager();
        this.customer = userManager.getCustomer(customerNum);
        this.restaurant = userManager.getRestaurant(restaurantNum);
        this.items = new HashMap<>();
        for (String productName: cart.keySet()){
            this.items.put(getProduct(productName), cart.get(productName));
        }
    }

    public Product getProduct(String productName) {
        for (Product product: this.restaurant.getRestaurantMenu()){
            if(product.getProductName().equals(productName)) {
                return product;
            }
        } return null;
    }

    public String makeOrder(){
        String id = this.customer.getUserPhone_num() + this.customer.getOrderHistory().size();
        Order order = new Order(id);
        order.addCustomerInfo(this.customer);
        order.addRestaurantInfo(this.restaurant);
        order.addItems(items);
        this.customer.addOrderToOrderHistory(order);
        this.restaurant.addOrderToOrderHistory(order);
        updateUser(order);
        return id;
    }

    public void updateUser(Order order) {
        UserReadWrite readWrite = new UserReadWrite();

        List<Customer> customerList = readWrite.readCustomers();
        List<Restaurant> restaurantList = readWrite.readRestaurants();

        for (Customer customer: customerList) {
            if (customer.getUserPhone_num().equals(this.customer.getUserPhone_num())) {
                customer.addOrderToOrderHistory(order);
            }
        }

        for (Restaurant restaurant: restaurantList) {
            if (restaurant.getUserPhone_num().equals(this.restaurant.getUserPhone_num())) {
                restaurant.addOrderToOrderHistory(order);
            }
        }

        readWrite.updateCustomer(customerList);
        readWrite.updateRestaurant(restaurantList);

    }




}
