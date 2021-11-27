package Entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class User implements Serializable {
    private static final long serialVersionUID = -8540439868375423480L;

    private final String name;
    private final String phone_num;
    private final String password;
    private final String type_;
    private final List<Order> orderHistory;

    /**
     * Construct a User, giving the name, phone_num, password, and type.
     *
     * @param name        The name of User
     * @param phone_num   The phone number of User
     * @param password    The password of User
     * @param type_       The type of User
     */
    public User(String name, String phone_num, String password, String type_){
        this.name = name;
        this.phone_num = phone_num;
        this.password = password;
        this.type_ = type_;
        this.orderHistory = new ArrayList<>();
    }

    /**
     * The user's name.
     *
     * @return the user's name.
     */
    public String getUserName() { return this.name; }

    /**
     * The user's phone number.
     *
     * @return the user's phone number.
     */
    public String getUserPhone_num() { return this.phone_num; }

    /**
     * The user's password.
     *
     * @return the user's password.
     */
    public String getUserPassword() { return this.password; }

    /**
     * The user's type.
     * @return the user's type.
     */
    public String getUserType() { return this.type_; }

    /**
     * Add an order to user's order history.
     */
    public void addOrderToOrderHistory(Order order) { this.orderHistory.add(order);}

    /**
     * The user's order history.
     *
     * @return user's order history.
     */
    public List<Order> getOrderHistory() {return this.orderHistory;}
}




