// courier or delivery_man?
class Courier extends User{
    private char type_;
    public Courier(String name, int u_id, int phone_num){
        super(name, u_id, phone_num);
        this.type_ = 'd';
    }
}