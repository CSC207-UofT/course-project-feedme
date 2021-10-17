package Entity;
import java.util.ArrayList;
import java.util.List;

public class Restaurant extends User {
    private final String address;
    private List<Product> productList;  //Since restaurant can add and remove products from productList, the field may
                                        //not be final.


    /**
     * Restaurant is a child class of User. User type 'r' is assigned to Restaurant class.
     * Construct a Restaurant, giving the name, phone_num, password, type and address.
     *
     * @param name        The name of Restaurant
     * @param phone_num   The phone number of Restaurant
     * @param password    The password of Restaurant
     * @param type_       The type of User
     * @param address     The delivery address of Restaurant
     */
    public Restaurant(String name, String address, String phone_num, String password, char type_){
        super(name, phone_num, password, type_);
        this.address = address;
        this.productList = new ArrayList<>();
    }


    /**
     * Get Restaurant's address.
     *
     * @return a string of the address.
     */
    public String getRestaurantAddress() { return this.address; }


    /**
     * Get Restaurant's product.
     *
     * @return a list of Product.
     */
    public List<Product> getRestaurantProducts() { return this.productList; }


    /**
     * Attempt to add new Product to the Restaurant's productList, if the product
     * hasn't added in the productList. Otherwise, return False.
     *
     * @return True if Product is added in the productList successfully.
     */
    public boolean addRestaurantProduct(Product product) {
        if (this.productList.contains(product)) {
            return false;
        }
        this.productList.add(product);
        return true;
    }


    /**
     * Attempt to remove an existing Product from the Restaurant's productList, if the product
     * is in the productList. Otherwise, return False.
     *
     * @return True if Product removes from the productList successfully.
     */
    public boolean removeRestaurantProduct(Product product) {
        if (!this.productList.contains(product)) {
            return false;
        }
        this.productList.remove(product);
        return true;
    }
}