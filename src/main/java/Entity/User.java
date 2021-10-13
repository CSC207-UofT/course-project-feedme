package Entity;

import javax.xml.xpath.XPathEvaluationResult;
import java.util.ArrayList;
import java.util.List;

public abstract class User {
    private String phone_num;
    private String name;
    private String password;
    private char type_;

    public User(String name, String phone_num, String password, char type_){
        this.name = name;
        this.phone_num = phone_num;
        this.password = password;
        this.type_ = type_;
    }

    public String getUserName() { return this.name; }
    public String getUserPhone_num() { return this.phone_num; }
    public String getUserPassword() { return this.password; }
    public char getUserType_() { return this.type_; }
}




