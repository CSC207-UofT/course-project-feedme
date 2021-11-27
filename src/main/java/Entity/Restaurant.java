package Entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Restaurant extends User implements Serializable {

    private static final long serialVersionUID = -2191481848339591142L;

    private final String address;
    private final List<Product> menu;

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
    public Restaurant(String name, String phone_num, String password, String type_, String address){
        super(name, phone_num, password, type_);
        this.address = address;
        this.menu = new ArrayList<>();
    }

    public Restaurant(String name, String phone_num, String password, String type_, String address, List<Product> menu){
        super(name, phone_num, password, type_);
        this.address = address;
        this.menu = menu;
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

    // TODO: Consider ignore this method?
    @Override
    public String toString() {
        return this.getUserName();
    }
}
