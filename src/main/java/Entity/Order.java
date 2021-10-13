package Entity;

import java.util.List;

/**
 * This is a controller to our ordering process.
 */
public class Order {
    private String id;
    private List<Product> list_products;
    private String status;

    //Initialize a order
    public Order(String id, List<Product> list_products){
        this.id = id;
        this.list_products = list_products;
        this.status = new String("Order placed");
    }

    public String getOrderId() { return this.id; }

    public List<Product> getOrderProducts() { return this.list_products; }

    public String getOrderStatus() { return this.status; }

    public void setOrderStatus(String status) { this.status = status; }

    public double getOrderPrice(){
        double order_price = 0;
        for(Product p: list_products){
            order_price += p.getProductPrice();
        }
        return order_price;
    }
}
