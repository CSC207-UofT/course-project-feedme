package UserInterface;

import Controller.SignupController;
import InOut.SystemInOut;

public class SignupUI {
    public void Signup(){
        SystemInOut inout = new SystemInOut();
        SignupController sc = new SignupController();
        sc.start(inout);
    }
}
