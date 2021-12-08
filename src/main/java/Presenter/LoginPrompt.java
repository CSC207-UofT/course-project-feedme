package Presenter;

public class LoginPrompt {
    private String language = "English";
    public String askAcc(){
        return "Welcome to feed me! Enter \"S\" if you do not have a account. If you already have an account, press enter to login:";
    }

    public String askPhone(){
        return "Please enter your registered phone number:";
    }

    public String askPassword(){
        return "Please enter your password: ";
    }
}