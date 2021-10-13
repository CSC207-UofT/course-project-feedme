import javax.xml.xpath.XPathEvaluationResult;
import java.util.ArrayList;
import java.util.List;

abstract class User {
    private int phone_num, id;
    private String name;
    private int password;
    private char type_;

    public User(String name, int id, int phone_num, int password, char type_){
        this.name = name;
        this.phone_num = phone_num;
        this.id = id;
        this.password = password;
        this.type_ = type_;
    }

    public String getUserName() { return this.name; }
    public int getUserPhone_num() { return this.phone_num; }
    public int getUserId() { return this.id; }
    public int getUserPassword() { return this.password; }
    public char getUserType_() { return this.type_; }
}




