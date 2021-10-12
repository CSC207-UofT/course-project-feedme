import javax.xml.xpath.XPathEvaluationResult;
import java.util.ArrayList;
import java.util.List;

abstract class User {
    private int phone_num, id;
    private String name;
    private int password;
    private char type_;

    public User(String name, int id, int phone_num, int password, char type_){
        this.name = name;
        this.phone_num = phone_num;
        this.id = id;
        this.password = password;
        this.type_ = type_;
    }

    public String getUserName() { return this.name; }
    public int getUserPhone_num() { return this.phone_num; }
    public int getUserId() { return this.id; }
    public int getUserPassword() { return this.password; }
    public char getUserType_() { return this.type_; }
}

class Customer extends User{
    private String address;
    public Customer(String name, String address, int id, int phone_num, int password, char type_){
        super(name, id, phone_num, password, type_);
        this.address = address;
    }

    public String getCustomerAddress() { return this.address; }
}

class Restaurant extends User{
    private String address;
    private List<Product> list_products;
    public Restaurant(String name, String address, int id, int phone_num, int password, char type_){
        super(name, id, phone_num, password, type_);
        this.address = address;
        this.list_products = new ArrayList<Product>();
    }
    public String getRestaurantAddress() { return this.address; }
    public List<Product> getRestaurantProducts() { return this.list_products; }
    public void addRestaurantProducts(Product p) { this.list_products.add(p); }
    public void removeRestaurantProducts(Product p) {this.list_products.remove(p); }
}

// courier or delivery_man?
class Courier extends User{
    public Courier(String name, int id, int phone_num, int password, char type_){
        super(name, id, phone_num, password, type_);
    }
}