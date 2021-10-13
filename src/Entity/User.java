package Entity;

public abstract class User {
    private int phone_num, id;
    private String name;

    public User(String name, int id, int phone_num){
        this.name = name;
        this.phone_num = phone_num;
        this.id = id;
    }
}