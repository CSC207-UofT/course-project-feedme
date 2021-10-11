/**
 * This is a controller to our ordering process.
 */
public class Order {
    private int o_id;
    private List<Product>  list_products;
    private String status;
    public Order(int o_id, List<Product> list_products, String status){
        this.o_id = o_id;
        this.list_products = list_products;
        this.status = status;
    }
}
