import javax.xml.xpath.XPathEvaluationResult;

abstract class User {
    private int phone_num, id;
    private String name;

    public User(String name, int id, int phone_num){
        this.name = name;
        this.phone_num = phone_num;
        this.id = id;
    }
}

class Customer extends User{
    private char type_;
    private String address;
    public Customer(char name, String address, int id, int phone_num){
        super(name, id, phone_num);
        this.address = address;
        this.type_ = 'c';
    }
}

class Restaurant extends User{
    private char type_;
    private String address;
    public Restaurant(String name, String address, int id, int phone_num){
        super(name, id,  phone_num);
        this.address = address;
        this.type_ = 'r';
    }
}

// courier or delivery_man?
class Courier extends User{
    private char type_;
    public Courier(String name, int id, int phone_num){
        super(name, id, phone_num);
        this.type_ = 'd';
    }
}