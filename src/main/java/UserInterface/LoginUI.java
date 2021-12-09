package UserInterface;

import Controller.LoginController;

import java.util.List;

/**
 * this is a UI for login, current job is to call login controller to start.
 */
public class LoginUI {
    public List<String> login(){
        LoginController lc = new LoginController();

        return lc.start();
    }
}