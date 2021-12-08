package UserInterface;

import Controller.LoginController;

import java.util.List;


public class LoginUI {
    public List<String> login(){
        LoginController lc = new LoginController();

        return lc.start();
    }
}