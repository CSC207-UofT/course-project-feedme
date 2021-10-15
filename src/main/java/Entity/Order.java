package Entity;

import java.util.ArrayList;
import java.util.List;

/**
 * This is a controller to our ordering process.
 */
public class Order {
    private String id;
    private List<Product> list_products;
    private String status;

    //Initialize a order
    public Order(String id){
        this.id = id;
        this.list_products = new ArrayList<>();
        this.status = new String("Order placed");
    }

    public String getOrderId() { return this.id; }

    public List<Product> getOrderProducts() { return this.list_products; }

    public String getOrderStatus() { return this.status; }

    public void setOrderStatus(String status) { this.status = status; }

    public boolean addProduct(Product product) {
        if (!list_products.contains(product)) {
            list_products.add(product);
            return true;
        }
        return false;
    }

    public boolean removeProduct(Product product) {
        if (list_products.contains(product)) {
            this.list_products.remove(product);
            return true;
        }
        return false;
    }

    public double getOrderPrice(){
        double order_price = 0.0;
        for(Product p: list_products){
            order_price += p.getProductPrice();
        }
        return order_price;
    }
}
