package UserInterface;

import Controller.LoginController;
import Entity.Customer;
import Entity.User;
import InOut.SystemInOut;

public class LoginUI {
    public String login(){
        LoginController lc = new LoginController();
        lc.start();
        Customer c = new Customer("a", "416", "abc", "c", "19 abc st.");
        return c.getUserPhone_num();
    }
}
