package Entity;

import java.util.HashMap;

/**
 * This is a controller to our ordering process.
 */
public class Order {
    private final String id;
    private HashMap<Product, Integer> productList; // key is a Product, value is product number. Since we are adding
    // Products to listProducs, we wil not make listProducts final.
    private String status;

    //Initialize an order
    public Order(String id){
        this.id = id;
        this.productList = new HashMap<>();
        this.status = "Order placed";
    }

    public String getOrderId() { return this.id; }

    public HashMap<Product, Integer> getOrderProducts() { return this.productList; }

    public String getOrderStatus() { return this.status; }

    public void setOrderStatus(String status) { this.status = status; }

    // Add quantity number of Product product to listProduct. If there is enough stock for product, update product's
    // stock and listProducts, and return true. If stock is not enough, return false.
    public boolean addProductToOrder(Product product, Integer quantity) {
        if (productList.containsKey(product)) {
            if (product.getProductStock() >= quantity) {// Check if there is enough stock
                productList.put(product, productList.get(product) + quantity);
                product.updateStock(-quantity);
                return true;
            } else {

                return false;
            }
        }
        else {
            if (product.getProductStock() >= quantity) {// Check if there is enough stock
                productList.put(product, quantity);
                product.updateStock(-quantity);
                return true;
            } else {
                return false;
            }
        }
    }

    public boolean removeProductFromOrder(Product product, Integer quantity) {
        if (productList.containsKey(product)) {
            if (quantity.equals(productList.get(product))) {
                productList.remove(product);
                product.updateStock(quantity);
                return true;
            }
            else if (quantity < productList.get(product)) {
                productList.put(product, productList.get(product) - quantity);
                product.updateStock(quantity);
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
        for(Product product: productList.keySet()){
            quantity = productList.get(product);
            order_price += product.getProductPrice() * quantity ;
        }
        return order_price;
    }
}
