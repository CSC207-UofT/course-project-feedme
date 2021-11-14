package UseCases;

import Entity.Product;
import Entity.Restaurant;
import Entity.Order;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;


public class RestaurantManager {
    Restaurant restaurant;
    ArrayList<Order> orderHistory;
    ArrayList<Order> readyToDistribute;
    List<Product> productList;
    int prod_id;


    public RestaurantManager(Restaurant restaurant) {
        this.restaurant = restaurant;
        this.orderHistory = new ArrayList<Order>();
        this.readyToDistribute = new ArrayList<Order>();
        prod_id = 0;

    }

    public HashMap<Integer, Product> ProductMap(List<Product> prodList){
        HashMap<Integer, Product> map = new HashMap<>();
        for (Product prod : prodList){
            map.put(prod.getProductId(), prod);
        }
        return map;
    }

    public Product createProduct(String name, double price, int stock) {
        Product product = new Product(name, prod_id, price, stock);
        this.prod_id += 1;
        return product;
    }

    public Product findProduct(int productID){
        return ProductMap(this.restaurant.getRestaurantProducts()).get(productID);
    }

    public void editPrice(int productID, double price) {
        findProduct(productID).setPrice(price);
    }

    public void editName(int productID, String name) {
        findProduct(productID).setName(name);
    }

    //Add product to restaurant menu if boolean is true, vice versa.
    public void editRestaurantMenu(int productID, int stock) {
        Product product = ProductMap(this.restaurant.getRestaurantProducts()).get(productID);
        if(stock > 0){
            product.setStock(stock);
        }
        this.restaurant.removeRestaurantProduct(product);
    }


    //TODO: override toString.
    public void getOrderHistory() {
        System.out.println(orderHistory.toString());
    }

    //TODO: override toString.
    public void getReadyToDistribute() {
        System.out.println(readyToDistribute.toString());
    }

    public void getMenu(){
        for(Integer prod : ProductMap(this.restaurant.getRestaurantProducts()).keySet()){
            Product product  = this.restaurant.getRestaurantProducts().get(prod);
            System.out.println(product.getProductName() + ": " +
                    product.getProductPrice() + " (" + product.inStockStatus() + ") " + "\n");
        }
    }



    public boolean containProduct(int productID) {
        return ProductMap(this.restaurant.getRestaurantProducts()).containsKey(productID);
    }

    //return the list of order which is ready to distribute and empty the readyToDistribute list.
    public ArrayList<Order> distributeOrder() {
        ArrayList<Order> readyToDistribute = this.readyToDistribute;
        this.readyToDistribute.removeAll(readyToDistribute);
        return readyToDistribute;
    }

    //Precondition: products in order are all from the restaurant.
    //Receive order and record it. The stock reduces by given quantities in the order.
    public void receiveOrder(Order order) {
        order.setOrderStatus("preparing");
        this.readyToDistribute.add(order);
        this.orderHistory.add(order);
        HashMap<Product, Integer> hashMap = order.getOrderProducts();
        for (Product key : hashMap.keySet()) {
            key.reduceProductStock(hashMap.get(key));
        }
    }

    public void readCsvFile(String csv_file) {

        Scanner scanner = new Scanner(csv_file);
        String[] sin_prod;
        Product product;

        while (scanner.hasNextLine()) {
            sin_prod = scanner.nextLine().split(",");
            product = new Product(sin_prod[0], Integer.parseInt(sin_prod[1]), Double.parseDouble(sin_prod[2]),
                    Integer.parseInt(sin_prod[3]));
            productList.add(product);
        }
        scanner.close();

    }

    public static void writeCsvFile(Product sin_prod, String csv_file) throws IOException {

        FileWriter fw = new FileWriter(csv_file, true);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter pw = new PrintWriter(bw);

        pw.println(sin_prod);
        pw.flush();
        pw.close();


    }

}



