package Entity;


import java.io.Serializable;

public class Product implements Serializable {
    private static final long serialVersionUID = 3151319034129838294L;


    private String name;
    private final String id;
    private double price;
    private int stock;


    /**
     * Construct a Product, giving the name, id, price and stock.
     *
     * @param name      The name of Product
     * @param id        The id of Product
     * @param price     The price of Product
     * @param stock     The stock of Product
     */
    public Product(String name, String id, double price, int stock){
        this.name = name;
        this.id = id;
        this.price = price;
        this.stock = stock;
    }

    public double getProductPrice(){
        return this.price;
    }

    public String getProductName(){ return this.name;}

    public String getProductId() { return this.id; }

    public int getProductStock() { return this.stock; }

    public void updateStock(int n) { this.stock += n; }
    
    public void setPrice(double price){this.price = price; }

    public void setName(String name){this.name = name; }

    public void setStock(int stock) {this.stock = stock; }

    public void reduceProductStock(int num) {this.stock -= num;}
    
    @Override
    public String toString(){
        return this.getProductName() + "\t" + "$" + this.getProductPrice();
    }

}
