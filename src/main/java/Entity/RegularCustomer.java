package Entity;

public class RegularCustomer extends Customer{

    /**
     * Customer is a child class of User. User type 'c' is assigned to Customer class.
     * Construct a Customer, giving the name, phone_num, password, type and address.
     *
     * @param name          The name of Customer
     * @param address       The delivery address of Customer
     * @param phone_num     The phone number of Customer
     * @param password      The password of Customer
     * @param type_         The type of User
     * @param customer_type The type of Customer
     */
    public RegularCustomer(String name, String phone_num, String password, String type_, String customer_type, String address) {
        super(name, phone_num, password, type_, customer_type, address);
    }

    public RegularCustomer(String name, String phone_num, String password, String type_, String address) {
        super(name, phone_num, password, type_, "r", address);
    }

    public RegularCustomer(String name, String phone_num, String password, String address) {
        super(name, phone_num, password,"c", "r", address);
    }
}
