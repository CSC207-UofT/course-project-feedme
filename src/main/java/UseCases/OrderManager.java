package UseCases;
import Entity.*;
import java.util.HashMap;


public class OrderManager {

    private HashMap<Product, Integer> orderHashMap;

    public OrderManager(){ this.orderHashMap = new HashMap<Product, Integer>(); }

    public boolean verifyProductName(Restaurant restaurant, String productName) {
        for (Product product: restaurant.getRestaurantMenu()) {
            if (product.getProductName().equals(productName)) {
                return true;
            }
        }
        return false;
    }

    public Product productNameToProduct(Restaurant restaurant, String productName) {
        for (Product product: restaurant.getRestaurantMenu()) {
            if (product.getProductName().equals(productName)) {
                return product;
            }
        }
        return null;
    }

    public boolean checkStockAvailability(Product product, Integer quantity) {
        return quantity >= product.getProductStock();
    }


    // Add quantity number of Product product to listProduct. If there is enough stock for product, update product's
    // stock and listProducts, and return true. If stock is not enough, return false.
//    public boolean addProductToOrder(Product product, Integer quantity) {
//        if (orderHashMap.containsKey(product)) {
//            if (product.getProductStock() >= quantity) {// Check if there is enough stock
//                orderHashMap.put(product, orderHashMap.get(product) + quantity);
//                product.updateStock(-quantity);
//                return true;
//            } else {
//                return false;
//            }
//        } else {
//            if (product.getProductStock() >= quantity) {// Check if there is enough stock
//                orderHashMap.put(product, quantity);
//                product.updateStock(quantity);
//                return true;
//            } else {
//                return false;
//            }
//        }
//    }
//
//    public boolean removeProductFromOrder(Product product, Integer quantity) {
//        if (orderHashMap.containsKey(product)) {
//            if (quantity.equals(orderHashMap.get(product))) {
//                orderHashMap.remove(product);
//                product.updateStock(quantity);
//                return true;
//            } else if (quantity < orderHashMap.get(product)) {
//                orderHashMap.put(product, orderHashMap.get(product) - quantity);
//                product.updateStock(quantity);
//                return true;
//            } else {
//                return false; // Number of product to remove > Product number in listProducts.
//            }
//        } else {
//            return false; // listProduct does not contain Product product.
//        }
//    }
//
}
