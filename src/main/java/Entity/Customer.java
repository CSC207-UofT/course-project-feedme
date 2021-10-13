package Entity;

class Customer extends User {
    private String address;
    public Customer(String name, String address, int id, int phone_num, int password, char type_){
        super(name, id, phone_num, password, type_);
        this.address = address;
    }

    public String getCustomerAddress() { return this.address; }g
}