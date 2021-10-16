package Entity;

import java.util.List;
import java.util.HashMap;

/**
 * This is a controller to our ordering process.
 */
public class Order {
    private String id;
    private HashMap<Product, Integer> listProducts; // key is a Product, value is product number
    private String status;

    //Initialize an order
    public Order(String id){
        this.id = id;
        this.listProducts = new HashMap<Product, Integer>();
        this.status = new String("Order placed");
    }

    public String getOrderId() { return this.id; }

    public HashMap<Product, Integer> getOrderProducts() { return this.listProducts; }

    public String getOrderStatus() { return this.status; }

    public void setOrderStatus(String status) { this.status = status; }

    // Add n number of Product p to listProduct. If there is enough stock for p, update p's stock and listProducts,
    // and return true. If stock is not enough, return false.
    public boolean addProductToOrder(Product p, Integer n) {
        if (listProducts.containsKey(p)) {
            if (p.getProductStock() >= n) {// Check if there is enough stock
                listProducts.put(p, listProducts.get(p) + n);
                p.reduceProductStock(n);
                return true;
            } else {
                return false;
            }
        }
        else {
            if (p.getProductStock() >= n) {// Check if there is enough stock
                listProducts.put(p, n);
                p.reduceProductStock(n);
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
                product.addProductStock(quantity);
                return true;
            }
            else if (quantity < listProducts.get(product)) {
                listProducts.put(product, listProducts.get(product) - quantity);
                product.addProductStock(quantity);
                return true;
            }
            else {
                return false; // Number of product to remove > Product number in listProducts.
            }
        } else {
            return false; // listProduct does not contain Product product.
        }
    }

    public double getOrderPrice(){
        double order_price = 0.00;
        Integer n = null;
        for(Product p: listProducts.keySet()){
            n = listProducts.get(p);
            order_price += p.getProductPrice() * n ;
        }
        return order_price;
    }
}
