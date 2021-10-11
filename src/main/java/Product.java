/**
 * Products name, id and types will store in here.
 */
public class Product {
    public String name;
    public int u_id;
    public float price;
    public int stock;

    public Product(String name, int u_id, float price, int stock){
        this.name = name;
        this.u_id = u_id;
        this.price = price;
        this.stock = stock;
    }

}
