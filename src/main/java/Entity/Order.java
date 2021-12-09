package Entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

/**
 * Order has all the information for restaurant owner and delivery person to distribute and deliver the order. Order
 * contains order id, a Map a product that has Product as key and Integer as value, order status, a List of
 * restaurantInfo, a List of customerInfo, a List of deliveryPersonInfo.
 */
public class Order implements Serializable {
    private static final long serialVersionUID = 1;
    private final String id;
    private Map<Product, Integer> listProducts; // key is a Product, value is product number.
    private String status;
    private final List<String> restaurantInfo;
    private final List<String> customerInfo;
    private final List<String> deliveryPersonInfo;


    /**
     * Initialize an Order
     * @param id the id of the order. Id is generated by the customer's phone number followed by the size of the
     *           customer's order history.
     */
    public Order(String id) {
        this.id = id;
        this.listProducts = new HashMap<>();
        this.status = "Order placed";
        this.restaurantInfo = new ArrayList<>();
        this.customerInfo = new ArrayList<>();
        this.deliveryPersonInfo = new ArrayList<>();
    }

    /**
     * Getter for getting Order id.
     * @return (String) order id.
     */
    public String getOrderId() {
        return this.id;
    }

    /**
     * Getter of getting the products in the order.
     * @return Map<Product, Integer> The map that contains the products in the order.
     */
    public Map<Product, Integer> getOrderProducts() {
        return this.listProducts;
    }

    /**
     * Add a list of restaurant info to the order which contains restaurant's name and restaurant's phone number
     * @param restaurant (Restaurant) The restaurant that is related to the order.
     */
    public void addRestaurantInfo(Restaurant restaurant) {
        this.restaurantInfo.add(restaurant.getUserName());
        this.restaurantInfo.add(restaurant.getUserPhone_num());
    }

    /**
     * Add a list of customer info to the order which contains customer's name and customer's phone number
     * @param customer (Customer) The customer that placed the order.
     */
    public void addCustomerInfo(Customer customer) {
        this.customerInfo.add(customer.getCustomerType());
        this.customerInfo.add(customer.getUserPhone_num());
    }

    /**
     * Add a list of customer info to the order which contains customer's name and customer's phone number
     * @param deliveryPerson (DeliveryPerson) The customer that placed the order.
     */
    public void addDeliveryPersonInfo(DeliveryPerson deliveryPerson) {
        this.deliveryPersonInfo.add(deliveryPerson.getUserPhone_num());
    }

    public void addDeliveryPersonInfo(String user_phonenum) {
        this.deliveryPersonInfo.add(user_phonenum);
    }

    /**
     * Change productList to items.
     * @param items (Map<Product, Integer>) a Map from CartUI that contains products that need to be added to the order.
     */
    public void addItems(Map<Product, Integer> items) {
        this.listProducts = items;
    }

    /**
     * Getter for getting restaurant's information.
     * @return The List<String> that contains the restaurant's info.
     */
    public List<String> getRestaurantInfo() {
        return this.restaurantInfo;
    }

    /**
     * Getter for getting customer's information.
     * @return The List<String> that contains the customer's info.
     */
    public List<String> getCustomerInfo() {
        return this.customerInfo;
    }

    /**
     * Getter for getting delivery person's information.
     * @return The List<String> that contains the delivery person's info.
     */
    public List<String> getDeliveryPersonInfo() {
        return this.deliveryPersonInfo;
    }

    /**
     * Getter for getting the status of the order
     * @return The string of the status of the order
     */
    public String getOrderStatus() {
        return this.status;
    }

    /**
     * Setter for setting the status of the order
     * @param status (String) The order status that needs to be set
     */
    public void setOrderStatus(String status) {
        this.status = status;
    }




   /**
    * Add quantity number of Product product to listProduct. If there is enough stock for product, update product's
    * stock and listProducts, and return true. If stock is not enough, return false.
    * @param product (Product) The product that is added to the order
    * @param quantity (Integer) The quantity of product that is added to the order
    * @return (boolean) true if product is successfully added, false if there isn't enough stock
    */
    public boolean addProductToOrder(Product product, Integer quantity) {
        if (this.getOrderProducts().containsKey(product)) {
            if (product.getProductStock() >= quantity) {// Check if there is enough stock
                listProducts.put(product, listProducts.get(product) + quantity);
                product.updateStock(-quantity);
                return true;
            } else {
                return false;
            }
        } else {
            if (product.getProductStock() >= quantity) {// Check if there is enough stock
                listProducts.put(product, quantity);
                product.updateStock(-quantity);
                return true;
            } else {
                return false;
            }
        }
    }

    public boolean removeProductFromOrder(Product product, Integer quantity) {
        if (this.getOrderProducts().containsKey(product)) {
            if (quantity.equals(this.getOrderProducts().get(product))) {
                listProducts.remove(product);
                product.updateStock(quantity);
                return true;
            } else if (quantity < listProducts.get(product)) {
                listProducts.put(product, listProducts.get(product) - quantity);
                product.updateStock(quantity);
                return true;
            } else {
                return false; // Number of product to remove > Product number in listProducts.
            }
        } else {
            return false; // listProduct does not contain Product product.
        }
    }


    /**
     * Get the price of the order
     * @return (double) price of the order
     */
    public double getOrderPrice() {
        double order_price = 0.00;
        int quantity;
        for (Product product : listProducts.keySet()) {
            quantity = listProducts.get(product);
            order_price += product.getProductPrice() * quantity;
        }
        BigDecimal b = new BigDecimal(order_price);
        return b.setScale(2, RoundingMode.HALF_UP).doubleValue();
    }


    @Override
    public String toString() {
        StringBuilder content = new StringBuilder("Order id: " + getOrderId() + ", " + "total price: " + getOrderPrice() + "\n");
        for (Product product : listProducts.keySet()) {
            content.append(product.toString()).append("\n");
        }
        return content.substring(0, content.length() - 1);
    }
}
