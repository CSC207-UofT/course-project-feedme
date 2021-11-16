//package UseCases;
//import Entity.*;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Objects;
//import java.util.Random;
//
//public class OrderManager {
//    private final List<Order> orderList;
//    private final List<DeliveryPerson> availableDeliveryPersonList;
//
//    public OrderManager() {
//        this.orderList = new ArrayList<>();
//        this.availableDeliveryPersonList = new ArrayList<>();
//    }
//
//    public void addOrder(Order order) {
//        orderList.add(order);
//    }
//
//    public void addDeliveryPerson(DeliveryPerson deliveryPerson) {
//        availableDeliveryPersonList.add(deliveryPerson);
//    }
//
//    public boolean matchDeliveryPerson(Order order) {
//        if (availableDeliveryPersonList.size() == 0) {
//            return false;
//        }
//        if (Objects.equals(order.getCustomerInfo().get(0), "r")) {
//            // list.get(rand.nextInt(list.size()));
//            Random rand = new Random();
//            DeliveryPerson deliveryPerson = availableDeliveryPersonList.get(rand.nextInt(availableDeliveryPersonList.size()));
//            order.addDeliveryPersonInfo(deliveryPerson);
//            availableDeliveryPersonList.remove(deliveryPerson);
//            return true;
//        }
//        ArrayList<DeliveryPerson> list = new ArrayList<>();
//        for ( DeliveryPerson deliveryPerson: availableDeliveryPersonList) {
//            if (!Objects.equals(deliveryPerson.getTransport(), "w")) {
//                list.add(deliveryPerson);
//            }
//        }
//        if (list.size()!=0) {
//            Random rand = new Random();
//            DeliveryPerson deliveryPerson = list.get(rand.nextInt(list.size()));
//            order.addDeliveryPersonInfo(deliveryPerson);
//            availableDeliveryPersonList.remove(deliveryPerson);
//            return true;
//        }
//        Random rand = new Random();
//        DeliveryPerson deliveryPerson = availableDeliveryPersonList.get(rand.nextInt(availableDeliveryPersonList.size()));
//        order.addDeliveryPersonInfo(deliveryPerson);
//        availableDeliveryPersonList.remove(deliveryPerson);
//        return true;
//    }
//}
//
//    private HashMap<Product, Integer> orderHashMap;
//
//    public OrderManager(){ this.orderHashMap = new HashMap<Product, Integer>(); }
//
//    public boolean verifyProductName(Restaurant restaurant, String productName) {
//        for (Product product: restaurant.getRestaurantMenu()) {
//            if (product.getProductName().equals(productName)) {
//                return true;
//            }
//        }
//        return false;
//    }
//
//    public Product productNameToProduct(Restaurant restaurant, String productName) {
//        for (Product product: restaurant.getRestaurantMenu()) {
//            if (product.getProductName().equals(productName)) {
//                return product;
//            }
//        }
//        return null;
//    }
//
//    public boolean checkStockAvailability(Product product, Integer quantity) {
//        return quantity >= product.getProductStock();
//    }
//
//    public void matchDeliveryMan() {
//
//    }


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
