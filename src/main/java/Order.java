import java.util.List;
/**
 * This is a controller to our ordering process.
 */
public class Order {
    private int o_id;
    private double total_price;
    private List<Product>  list_products;
    private String status;
    public Order(int o_id, List<Product> list_products, String status){
        int total_price = 0;
        this.o_id = o_id;
        this.list_products = list_products;
        this.status = status;
        for(Product p: list_products){
            total_price += get_price(p);
        }
        this.total_price = total_price;
    }
}
