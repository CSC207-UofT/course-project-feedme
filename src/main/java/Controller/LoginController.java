package Controller;

import Entity.User;
import UseCases.UserManager;
import UserInterface.SignupUI;

import java.io.IOException;

/**
 * This class manages to Login process of Feedme.
 */
public class LoginController {

    public interface InOut {
        String getInput() throws IOException;

        void sendOutput(String output);
    }
    private UserManager userManager = new UserManager();


    public User start(InOut inout){
        boolean verifier = false;
        inout.sendOutput("Welcome to feed me! Enter \"S\" if you do not have a account with us:");
        try {
           String answer = inout.getInput();
           if (answer.equals("S") | answer.equals("s")){
               SignupUI signupUI = new SignupUI();
               signupUI.Signup();
               userManager = new UserManager();
           }
            while (!verifier) {
                inout.sendOutput("Please enter your registered phone number:");
                String phone_input = inout.getInput();
                inout.sendOutput("Please enter your password: ");
                String password_input = inout.getInput();
                if (userManager.verifyUser(phone_input, password_input)) {
                    verifier = true;
                    inout.sendOutput("You have successfully login.");

                    return userManager.getUserByPhoneNumber(phone_input);
                }
            }

        } catch (IOException e) {
            System.out.println("Something went wrong.");
        }
        //inout.sendOutput("You have successfully login.");
        return null;
    }
}
