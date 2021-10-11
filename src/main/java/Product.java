/**
 * Products name, id and types will store in here.
 */
public class Product {
    private String name;
    private int u_id;
    private float price;
    private int stock;

    public Product(String name, int u_id, float price, int stock){
        this.name = name;
        this.u_id = u_id;
        this.price = price;
        this.stock = stock;
    }

}
