package UserInterface;

import Controller.LoginController;


public class LoginUI {
    public String login(){
        LoginController lc = new LoginController();
        return lc.start();
    }
}
