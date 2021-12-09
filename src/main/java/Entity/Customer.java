package Entity;

import java.io.Serializable;

/**
 * Customer is a type of user that can browse restaurants and make an order. It is a child class of User and is
 * assigned with type 'c'.
 */
public class Customer extends User implements Serializable {
    private static final long serialVersionUID = 1;

    private final String address;
    private final String customer_type;

    /**
     * Construct a Customer, giving the name, phone_num, password, type and address.
     *
     * @param name        The name of Customer
     * @param phone_num   The phone number of Customer
     * @param password    The password of Customer
     * @param type_       The type of User
     * @param address     The delivery address of Customer
     * @param customer_type The type of Customer
     */
    public Customer(String name, String phone_num, String password, String type_, String address, String customer_type){
        super(name, phone_num, password, type_);
        this.address = address;
        this.customer_type = customer_type;
    }


    public Customer(String name, String phone_num, String password, String type_, String address){
        super(name, phone_num, password, type_);
        this.address = address;
        this.customer_type = "r";
    }

    public Customer(String name, String phone_num, String password, String address){
        super(name, phone_num, password, "c");
        this.address = address;
        this.customer_type = "r";
    }

    /**
     * Get Customer's address.
     *
     * @return a string of the Customer's address.
     */
    public String getCustomerAddress() { return this.address; }

    /**
     * Get Customer's type.
     *
     * @return a string of the Customer type.
     */
    public String getCustomerType() { return this.customer_type; }

    @Override
    public String toString() {
        return "Customer{" +
                "address='" + address + '\'' +
                ", customer_type='" + customer_type + '\'' +
                '}';
    }
}