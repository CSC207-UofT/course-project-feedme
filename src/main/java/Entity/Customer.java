package Entity;

public class Customer extends User {
    private String address;
    public Customer(String name, String address, String phone_num, String password, char type_){
        super(name, phone_num, password, type_);
        this.address = address;
    }

    public String getCustomerAddress() { return this.address; }
}