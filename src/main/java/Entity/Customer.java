package Entity;

import java.util.ArrayList;

public class Customer extends User {
    private final String address;

    /**
     * Customer is a child class of User. User type 'c' is assigned to Customer class.
     * Construct a Customer, giving the name, phone_num, password, type and address.
     *
     * @param name        The name of Customer
     * @param phone_num   The phone number of Customer
     * @param password    The password of Customer
     * @param type_       The type of User
     * @param address     The delivery address of Customer
     */
    public Customer(String name, String address, String phone_num, String password, String type_){
        super(name, phone_num, password, type_);
        this.address = address;
    }

    public Customer(String name, String address, String phone_num, String password){
        super(name, phone_num, password, "c");
        this.address = address;
    }

    /**
     * Get Customer's address.
     *
     * @return a string of the address.
     */
    public String getCustomerAddress() { return this.address; }

    public void matchDeliveryMan() {}
}
