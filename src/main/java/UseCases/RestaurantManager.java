package UseCases;

import Entity.Product;
import Entity.Restaurant;
import Entity.Order;


import java.util.*;

/**
 * The Use case for the RestaurantSystemController.
 */
public class RestaurantManager {
    Restaurant restaurant;
    ArrayList<Order> orderHistory;
    ArrayList<Order> readyToDistribute;
    List<Product> productList;
    int prod_id;

    /**
     * Initiating a new RestaurantManager will obtain a new restaurant, an order history,
     * a list that is ready to distribute and an initial product id.
     */
    public RestaurantManager(Restaurant restaurant) {
        this.restaurant = restaurant;
        this.orderHistory = new ArrayList<Order>();
        this.readyToDistribute = new ArrayList<Order>();
        prod_id = 0;

    }

    /**
     * Show the product list.
     * @param prodList The list of products that is used to edit.
     * @return A hashmap of the product with id in the key and product in the value.
     */
    public HashMap<String, Product> ProductMap(List<Product> prodList){
        HashMap<String, Product> map = new HashMap<>();
        for (Product prod : prodList){
            map.put(prod.getProductId(), prod);
        }
        return map;
    }

    /**
     * Create a new product with new name, price and stock.
     * @param name The name of new product
     * @param price The price of new product
     * @param stock The stock of new product
     * @return a new product with the given name, price, and stock
     */
    public Product createProduct(String name, double price, int stock) {
        Product product = new Product(name, String.valueOf(prod_id), price, stock);
        this.prod_id += 1;
        return product;
    }

    /**
     * Find the product according to the product id
     * @param productID The identification number of the product
     * @return A product with given product id
     */
    public Product findProduct(String productID){
        return ProductMap(this.restaurant.getRestaurantMenu()).get(productID);
    }

    /**
     * Edit the price of the product
     * @param productID The identification number of the product
     * @param price The new price  of the product
     */
    public void editPrice(String productID, double price) {
        findProduct(productID).setPrice(price);
    }

    /**
     * Edit the name of the product
     * @param productID The identification number of the product
     * @param name The new name of the product
     */
    public void editName(String productID, String name) {
        findProduct(productID).setName(name);
    }

    /**
     * Add product to restaurant menu if boolean is true, vice versa
     * @param productID The identification number of the product
     * @param stock The new stock of the product
     */
    public void editRestaurantMenu(String productID, int stock) {
        Product product = ProductMap(this.restaurant.getRestaurantMenu()).get(productID);
        if(stock > 0){
            product.setStock(stock);
        }}


    /**
     * Override toString method of orderHistory in the Order entity.
     */
    public void getOrderHistory() {
        System.out.println(orderHistory.toString());
    }

    /**
     * Override toString method of readyToDistribute in the Order entity.
     */
    public void getReadyToDistribute() {
        System.out.println(readyToDistribute.toString());
    }

    /**
     * Show the overall products that is in the menu with format name: price(stock)
     */
    public void getMenu(){
        for(String prod : ProductMap(this.restaurant.getRestaurantMenu()).keySet()){
            Product product  = ProductMap(this.restaurant.getRestaurantMenu()).get(prod);
            System.out.println(product.getProductName() + ": " +
                    product.getProductPrice() + " (" + product.getProductStock() + ") " + "\n");
        }
    }

    /**
     * Return true if product id is already contained in the restaurant menu, return false if not
     * @param productID The identification number of the product
     * @return True or False
     */
    public boolean containProduct(String productID) {
        return ProductMap(this.restaurant.getRestaurantMenu()).containsKey(productID);
    }

    /**
     * return the list of order which is ready to distribute and empty the readyToDistribute list
     * @return An arraylist of orders.
     */
    public ArrayList<Order> distributeOrder() {
        ArrayList<Order> readyToDistribute = this.readyToDistribute;
        this.readyToDistribute.removeAll(readyToDistribute);
        return readyToDistribute;
    }

    /**
     * Precondition: products in order are all from the restaurant.
     * Receive order and record it. The stock reduces by given quantities in the order
     * @param order The new order that is receiving
     */
    public void receiveOrder(Order order) {
        order.setOrderStatus("preparing");
        this.readyToDistribute.add(order);
        this.orderHistory.add(order);
        HashMap<Product, Integer> hashMap = order.getOrderProducts();
        for (Product key : hashMap.keySet()) {
            key.reduceProductStock(hashMap.get(key));
        }
    }
}



