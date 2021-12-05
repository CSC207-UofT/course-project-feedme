package UserInterface;

import Controller.LoginController;
import Entity.Customer;
import Entity.User;
import InOut.SystemInOut;

public class LoginUI {
    public String login(){
        LoginController lc = new LoginController();
        return lc.start();
    }
}