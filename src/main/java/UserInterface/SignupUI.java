package UserInterface;

import Controller.SignupController;

/**
 * this is a UI for signup, current job is to call signup controller to start.
 */
public class SignupUI {
    public void Signup(){
        SignupController sc = new SignupController();
        sc.start();
    }
}
