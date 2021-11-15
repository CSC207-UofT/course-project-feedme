package UserInterface;

import Controller.LoginController;
import Entity.Customer;
import Entity.User;
import InOut.SystemInOut;

public class LoginUI {
    public User login(){
        SystemInOut inout = new SystemInOut();
        LoginController lc = new LoginController();
        lc.start(inout);
        return new Customer("a", "416", "abc", "c", "19 abc st.");
    }
}
