package Controller;

import InOut.SystemInOut;
import UseCases.UserManager;
import UserInterface.SignupUI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * This class manages to Login process of Feedme.
 */
public class LoginController implements SystemInOut {

    private UserManager userManager = new UserManager();

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

    public String start(){
        boolean verifier = false;
        sendOutput("Welcome to feed me! Enter \"S\" if you do not have a account with us:");
        try {
            String answer = getInput();
            if (answer.equals("S") | answer.equals("s")){
                SignupUI signupUI = new SignupUI();
                signupUI.Signup();
                userManager = new UserManager();
            }
            int attempt = 0;
            while (attempt < 5) {
                sendOutput("Please enter your registered phone number:");
                String phone_input = getInput();
                sendOutput("Please enter your password: ");
                String password_input = getInput();
                if (userManager.verifyUser(phone_input, password_input)) {
                    return phone_input;
                }
                attempt += 1;
            }


        } catch (IOException e) {
            System.out.println("Something went wrong.");
        }
        sendOutput("You have successfully login.");
        return null;
    }
}
