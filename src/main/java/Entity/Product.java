package Entity;


public class Product {
    private final String name;
    private final String id;
    private final double price;
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

    public String toString() {
        String content = new String("Product name: " + getProductName() + ", ");
        content += "id: " + getProductId() + ", " + "price: " + getProductPrice();
        return content;
    }

}
