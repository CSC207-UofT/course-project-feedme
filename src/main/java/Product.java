package java;

import java.util.List;

/**
 * Products name, id, price, and stock will store in here.
 */
public class Product {

    private String name;
    private int p_id;
    private float price;
    private int stock;

    // Initialize Product
    public Product(String name, int p_id, float price, int stock){
        this.name = name;
        this.p_id = p_id;
        this.price = price;
        this.stock = stock;
    }

    public double getProductPrice(){
        return this.price;
    }

    public String getProductName(){ return this.name;}

    public int getProductId() { return this.p_id; }

    public int getProductStock() { return this.stock; }

    public void addProductStock(int n) { this.stock += n; }

    public void reduceProductStock(int n) { this.stock -= n; }

}
