package Entity;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * This is a controller to the ordering process.
 */
public class Order {
    private final String id;
    private final HashMap<Product, Integer> listProducts; // key is a Product, value is product number.
    private String status;
    private final ArrayList<String> restaurantInfo;
    private final ArrayList<String> customerInfo;
    private final ArrayList<String> deliveryPersonInfo;


    //Initialize an order
    public Order(String id) {
        this.id = id;
        this.listProducts = new HashMap<>();
        this.status = "Order placed";
        this.restaurantInfo = new ArrayList<>();
        this.customerInfo = new ArrayList<>();
        this.deliveryPersonInfo = new ArrayList<>();
    }

    public String getOrderId() {
        return this.id;
    }

    public HashMap<Product, Integer> getOrderProducts() {
        return this.listProducts;
    }

    public void addRestaurantInfo(Restaurant restaurant) {
        this.restaurantInfo.add(restaurant.getUserName());
        this.restaurantInfo.add(restaurant.getUserPhone_num());
    }

    public void addCustomerInfo(Customer customer) {
        this.customerInfo.add(customer.getCustomerType());
        this.customerInfo.add(customer.getUserPhone_num());
    }

    public void addDeliveryPersonInfo(DeliveryPerson deliveryPerson) {
        this.deliveryPersonInfo.add(deliveryPerson.getUserPhone_num());
    }

    public ArrayList<String> getRestaurantInfo() {
        return this.restaurantInfo;
    }

    public ArrayList<String> getCustomerInfo() {
        return this.customerInfo;
    }

    public ArrayList<String> getDeliveryPersonInfo() {
        return this.deliveryPersonInfo;
    }

    public String getOrderStatus() {
        return this.status;
    }

    public void setOrderStatus(String status) {
        this.status = status;
    }

    // Add quantity number of Product product to listProduct. If there is enough stock for product, update product's
    // stock and listProducts, and return true. If stock is not enough, return false.
    public boolean addProductToOrder(Product product, Integer quantity) {
        if (listProducts.containsKey(product)) {
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
                product.updateStock(quantity);
                return true;
            } else {
                return false;
            }
        }
    }

    public boolean removeProductFromOrder(Product product, Integer quantity) {
        if (listProducts.containsKey(product)) {
            if (quantity.equals(listProducts.get(product))) {
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
