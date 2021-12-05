package UserInterface;

import Controller.SignupController;
import InOut.SystemInOut;

public class SignupUI {
    public void signup(){
        SignupController sc = new SignupController();
        sc.start();
    }
}
