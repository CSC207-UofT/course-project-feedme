package Entity;


import java.io.Serializable;

public class Product {

    private final String name;
    private final Integer id;
    private final double price;
    private int stock;

    // Initialize Product
    public Product(String name, Integer id, double price, int stock){
        this.name = name;
        this.id = id;
        this.price = price;
        this.stock = stock;
    }

    public double getProductPrice(){
        return this.price;
    }

    public String getProductName(){ return this.name;}

    public Integer getProductId() { return this.id; }

    public int getProductStock() { return this.stock; }

    public void addProductStock(int n) { this.stock += n; }

    public void reduceProductStock(int n) { this.stock -= n; }

    public String inStockStatus(){
        if(this.stock > 0){
            return "in Stock";
        }
        return "not in Stock";
    }

    public String toString(){
        return name + price + inStockStatus();
    }

    public void setPrice(double price) {
    }

    public void setName(String name) {
    }

    public void setStock(int stock) {
    }
}
