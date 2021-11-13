package Entity;

public class RegularCustomer extends Customer{
    private final String customer_type;

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
    public RegularCustomer(String name, String address, String phone_num, String password, String type_, String customer_type) {
        super(name, address, phone_num, password, type_);
        this.customer_type = customer_type;
    }

    public RegularCustomer(String name, String address, String phone_num, String password) {
        super(name, address, phone_num, password);
        this.customer_type = "r";
    }

    public String getCustomerType() { return this.customer_type; }

    @Override
    public void matchDeliveryMan() {
        super.matchDeliveryMan();
    }
}
