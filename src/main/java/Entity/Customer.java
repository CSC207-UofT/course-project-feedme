package Entity;

public class Customer extends User {
    private final String address;
    private final String customer_type;

    /**
     * Customer is a child class of User. User type 'c' is assigned to Customer class.
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
        this.customer_type = "n";
    }

    public Customer(String name, String phone_num, String password, String address){
        super(name, phone_num, password, "c");
        this.address = address;
        this.customer_type = "n";
    }

    /**
     * Get Customer's address.
     *
     * @return a string of the address.
     */
    public String getCustomerAddress() { return this.address; }

    /**
     * Get Customer's type.
     *
     * @return a string of the type.
     */
    public String getCustomerType() { return this.customer_type; }
}