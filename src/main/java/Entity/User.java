package Entity;

import java.io.Serializable;

public abstract class User implements Serializable {
    private final String name;
    private final String phone_num;
    private final String password;
    private final String type_;

    /**
     * Construct a User, giving the name, phone_num, password, and type.
     *
     * @param name        The name of User
     * @param phone_num   The phone number of User
     * @param password    The password of User
     * @param type_       The type of User
     */
    public User(String name, String phone_num, String password, String type_){
        this.name = name;
        this.phone_num = phone_num;
        this.password = password;
        this.type_ = type_;
    }

    public String getUserName() { return this.name; }

    public String getUserPhone_num() { return this.phone_num; }

    public String getUserPassword() { return this.password; }

    public String getUserType() { return this.type_; }
}




