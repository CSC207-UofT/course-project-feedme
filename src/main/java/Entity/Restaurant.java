package Entity;

import java.util.ArrayList;
import java.util.List;

public class Restaurant extends User {
    private String address;
    private List<Product> list_products;
    public Restaurant(String name, String address, String phone_num, String password, char type_){
        super(name, phone_num, password, type_);
        this.address = address;
        this.list_products = new ArrayList<>();
    }

    public String getRestaurantAddress() { return this.address; }

    public List<Product> getRestaurantProducts() { return this.list_products; }

    public void removeRestaurantProducts(Product product) {this.list_products.remove(product); }

    public boolean addProduct(Product product) {
        if (!list_products.contains(product)) {
            list_products.add(product);
            return true;
        }
        return false;
    }
}

