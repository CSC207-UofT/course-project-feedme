package UserInterface;

import Controller.LoginController;
import Entity.Customer;
import Entity.User;
import InOut.SystemInOut;
import UseCases.UserManager;

public class LoginUI {
    public User login(){
        SystemInOut inout = new SystemInOut();
        LoginController lc = new LoginController();
        return lc.start(inout);
        //return new Customer("a", "416", "abc", "c", "19 abc st.");
    }
}
