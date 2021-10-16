package Entity;


public class Product {

    private String name;
    private String id;
    private double price;
    private int stock;

    // Initialize Product
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

    public void addProductStock(int n) { this.stock += n; }

    public void reduceProductStock(int n) { this.stock -= n; }

}
