package Entity;

/**
 * Customer is a child class of User. User type 'c' is assigned to Customer class.
 */

public class Customer extends User {
    private String address;

    //Initiate a customer.
    public Customer(String name, String address, String phone_num, String password, char type_){
        super(name, phone_num, password, type_);
        this.address = address;
    }
    //Get customer's address. Return a string of address
    public String getCustomerAddress() { return this.address; }
}