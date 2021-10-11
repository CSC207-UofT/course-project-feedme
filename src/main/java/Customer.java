class Customer extends User{
    private char type_;
    private String address;
    public Customer(String name, String address, int u_id, int phone_num){
        super(name, u_id, phone_num);
        this.address = address;
        this.type_ = 'c';
    }
}
