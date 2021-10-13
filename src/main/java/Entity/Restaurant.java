package Entity;

import java.util.ArrayList;
import java.util.List;

class Restaurant extends User {
    private String address;
    private List<Product> list_products;
    public Restaurant(String name, String address, String phone_num, String password, char type_){
        super(name, phone_num, password, type_);
        this.address = address;
        this.list_products = new ArrayList<Product>();
    }
    public String getRestaurantAddress() { return this.address; }
    public List<Product> getRestaurantProducts() { return this.list_products; }
    public void addRestaurantProducts(Product p) { this.list_products.add(p); }
    public void removeRestaurantProducts(Product p) {this.list_products.remove(p); }
}