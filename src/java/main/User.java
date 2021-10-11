import javax.xml.xpath.XPathEvaluationResult;

abstract class User {
    private int phone_num;
    private String name, id;

    public  User(String name, String id, int phone_num){
        this.name = name;
        this.phone_num = phone_num;
        this.id = id;
    }
}

 class Customer extends User{
    public Customer(String name, String address, String c_id, int phone_num){
        super(name, c_id, phone_num);
    }
}

class Resturant extends User{
    public Resturant()
}

class Courier extends User{
    public Customer(String name, String q_id, int phone_num){

    }
}