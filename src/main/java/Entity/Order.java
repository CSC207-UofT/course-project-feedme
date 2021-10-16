package Entity;

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
        this.listProducts = new HashMap<>();
        this.status = "Order placed";
    }

    public String getOrderId() { return this.id; }

    public HashMap<Product, Integer> getOrderProducts() { return this.listProducts; }

    public String getOrderStatus() { return this.status; }

    public void setOrderStatus(String status) { this.status = status; }

    // Add quantity number of Product product to listProduct. If there is enough stock for product, update product's
    // stock and listProducts, and return true. If stock is not enough, return false.
    public boolean addProductToOrder(Product product, Integer quantity) {
        if (listProducts.containsKey(product)) {
            if (product.getProductStock() >= quantity) {// Check if there is enough stock
                listProducts.put(product, listProducts.get(product) + quantity);
                product.reduceProductStock(quantity);
                return true;
            } else {

                return false;
            }
        }
        else {
            if (product.getProductStock() >= quantity) {// Check if there is enough stock
                listProducts.put(product, quantity);
                product.reduceProductStock(quantity);
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
        Integer quantity;
        for(Product product: listProducts.keySet()){
            quantity = listProducts.get(product);
            order_price += product.getProductPrice() * quantity ;
        }
        return order_price;
    }
}
