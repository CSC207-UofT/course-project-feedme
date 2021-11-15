package Entity;
import java.util.ArrayList;
import java.util.List;

public class Restaurant extends User {
    private final String address;
    private final List<Product> menu;  //Since restaurant can add and remove products from productList, the field may
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
    public Restaurant(String name, String address, String phone_num, String password, String type_){
        super(name, phone_num, password, type_);
        this.address = address;
        this.menu = new ArrayList<>();
    }

    public Restaurant(String name, String address, String phone_num, String password){
        super(name, phone_num, password, "r");
        this.address = address;
        this.menu = new ArrayList<>();
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
    public List<Product> getRestaurantMenu() { return this.menu; }


    /**
     * Attempt to add new Product to the Restaurant's productList, if the product
     * hasn't added in the productList. Otherwise, return False.
     *
     * @return True if Product is added in the productList successfully.
     */
    public boolean addProductToMenu(Product product) {
        if (this.menu.contains(product)) {
            return false;
        }
        this.menu.add(product);
        return true;
    }


    /**
     * Attempt to remove an existing Product from the Restaurant's productList, if the product
     * is in the productList. Otherwise, return False.
     *
     * @return True if Product removes from the productList successfully.
     */
    public boolean removeProductFromMenu(Product product) {
        if (!this.menu.contains(product)) {
            return false;
        }
        this.menu.remove(product);
        return true;
    }
}