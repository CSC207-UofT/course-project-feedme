package Entity;
import java.util.ArrayList;
import java.util.List;

/**
 * Restaurant is a child class of User. User type 'r' is assigned to Restaurant class.
 */

public class Restaurant extends User {
    private String address;
    private List<Product> productList;

    // Initiate a Restaurant
    public Restaurant(String name, String address, String phone_num, String password, char type_){
        super(name, phone_num, password, type_);
        this.address = address;
        this.productList = new ArrayList<Product>();
    }

    public String getRestaurantAddress() { return this.address; }

    public List<Product> getRestaurantProducts() { return this.productList; }

    public boolean addRestaurantProduct(Product p) {
        if (this.productList.contains(p)) {
            return false;
        } else {
            this.productList.add(p);
            return true;
        }
    }

    public boolean removeRestaurantProduct(Product p) {
            if (!this.productList.contains(p)) {
                return false;
            } else {
                this.productList.remove(p);
                return true;
            }
    }
}