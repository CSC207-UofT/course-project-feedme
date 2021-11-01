package Entity;


public class Product {

    private final String name;
    private final String id;
    private final double price;
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

    public String inStockStatus(){
        if(this.stock > 0){
            return "in Stock";
        };
        return "not in Stock";
    }

}
