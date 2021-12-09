package Presenter;

/**
 * This is a presenter class for Login Controller to give out all dialog in login phase.
 * (future change is very easy and do not require changing lots of code or finding it in the controller)
 */
public class LoginPrompt {
    private String language = "English"; //for future implementation.
    public String askAcc(){
        return "Welcome to feed me! Enter \"S\" if you do not have a account. If you already have an account," +
                " press enter to login:";
    }

    public String askPhone(){
        return "Please enter your registered phone number:";
    }

    public String askPassword(){
        return "Please enter your password: ";
    }
}