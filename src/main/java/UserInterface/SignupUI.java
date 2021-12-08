package UserInterface;

import Controller.SignupController;
import InOut.SystemInOut;

public class SignupUI {
    public void Signup(){
        SignupController sc = new SignupController();
        sc.start();
    }
}
