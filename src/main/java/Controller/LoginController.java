package Controller;

import InOut.SystemInOut;
import UseCases.UserManager;
import UserInterface.SignupUI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * This class manages to Log in process of FeedMe.
 */
public class LoginController implements SystemInOut {

    @Override
    public String getInput() throws IOException {
        BufferedReader reader;
        reader = new BufferedReader(new InputStreamReader(System.in));
        return reader.readLine();
    }

    @Override
    public void sendOutput(String output) {
        System.out.println(output);
    }
    private UserManager userManager = new UserManager();

    public String start(){
        boolean verifier = false;
        boolean validLetter = false;
        sendOutput("Welcome to FeedMe! Please enter \"S\" if you do not have a account; enter \"L\" if you already have a account:");
        try {
            while (!validLetter) {
                String answer = getInput();
                if (answer.equalsIgnoreCase("S")) {
                    SignupUI signupUI = new SignupUI();
                    signupUI.signup();
                    validLetter = true;
                } else if (answer.equalsIgnoreCase("L")) {
                    validLetter = true;
                } else {
                    sendOutput("Please enter a valid letter");
                }
            }
            UserManager userManager = new UserManager();
            while (!verifier) {
                sendOutput("Please enter your registered phone number:");
                String phone_input = getInput();
                sendOutput("Please enter your password:");
                String password_input = getInput();
                if (userManager.verifyUser(phone_input, password_input)) {
                    verifier = true;
                } else {
                    sendOutput("Your phone number or password is incorrect. Please try again");
                }
            }

        } catch (IOException e) {
            System.out.println("Something went wrong.");
        }
        sendOutput("You have successfully login.");
        return null;
    }
}