package Controller;

import UseCases.UserManager;
import UserInterface.SignupUI;

import java.io.IOException;

/**
 * This class manages to Log in process of FeedMe.
 */
public class LoginController {

    public interface InOut {
        String getInput() throws IOException;

        void sendOutput(String output);
    }

    public void start(InOut inout){
        boolean verifier = false;
        inout.sendOutput("Welcome to FeedMe! Please enter \"S\" if you do not have a account; enter \"L\" if you already have a account:");
        try {
            String answer = inout.getInput();
            if (answer.equalsIgnoreCase("S")){
                SignupUI signupUI = new SignupUI();
                signupUI.signup();
           }
            UserManager userManager = new UserManager();
            while (!verifier) {
                inout.sendOutput("Please enter your registered phone number:");
                String phone_input = inout.getInput();
                inout.sendOutput("Please enter your password:");
                String password_input = inout.getInput();
                if (userManager.verifyUser(phone_input, password_input)) {
                    verifier = true;
                }
            }

        } catch (IOException e) {
            System.out.println("Something went wrong.");
        }
        inout.sendOutput("You have successfully login.");
    }
}
