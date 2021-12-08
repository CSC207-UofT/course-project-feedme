package UseCases;

import Entity.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Usecases for generating an order.
 */

public class OrderUseCase {

    private final Customer customer;
    private final Restaurant restaurant;
    private final Map<Product, Integer> items;
    private final UserManager userManager = new UserManager();

    /**
     * Construct the order use case
     * @param customerNum A string of customer's phone number
     * @param restaurantNum A string of restaurant's phone number
     * @param cart a Map of items that need to be added to the order
     */

    public OrderUseCase(String customerNum, String restaurantNum, Map<String, Integer> cart){
        this.customer = userManager.getCustomer(customerNum);
        this.restaurant = userManager.getRestaurant(restaurantNum);
        this.items = new HashMap<>();
        for (String productName: cart.keySet()){
            this.items.put(getProduct(productName), cart.get(productName));
        }
    }

    /**
     * Find product entity by productName. A helper method for OrderUseCase constructor
     * @param productName (String) The name of the product
     * @return (Product) the product entity
     */
    public Product getProduct(String productName) {
        for (Product product: this.restaurant.getRestaurantMenu()){
            if(product.getProductName().equals(productName)) {
                return product;
            }
        } return null;
    }

    /**
     * Generating order and add order to user's order history. Use updateUserOderHistory in UserManager to update
     * user's order history,
     * @return (String) The order id
     */
    public String makeOrder(){
        String id = this.customer.getUserPhone_num() + this.customer.getOrderHistory().size();
        Order order = new Order(id);
        order.addCustomerInfo(this.customer);
        order.addRestaurantInfo(this.restaurant);
        order.addItems(items);
        this.customer.addOrderToOrderHistory(order);
        this.restaurant.addOrderToOrderHistory(order);
        this.userManager.updateUserOrderHistory(order, this.customer.getUserPhone_num(), this.restaurant.getUserPhone_num());
        return id;
    }




}