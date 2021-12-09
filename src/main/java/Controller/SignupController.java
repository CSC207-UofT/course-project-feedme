package Controller;

import InOut.SystemInOut;
import Presenter.SignupPrompt;
import UseCases.UserManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * This controller in charge of signup process, that included displaying prompt and taking input from the user, call out
 * the UserManager to Create user and store to database.
 */
public class SignupController implements SystemInOut{
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

    public void start() {
        try {
            SignupPrompt sp = new SignupPrompt();
            UserManager userManager = new UserManager();
            sendOutput(sp.askNewName());
            String in_name = getInput();
            sendOutput(sp.askNewPhone());
            String in_phone_num = getInput();
            sendOutput(sp.askNewPassword());
            String in_password = getInput();
            sendOutput(sp.askNewType());
            String in_type = getInput();

            if (in_type.equals("c")) {
                sendOutput(sp.askCustomerAddress());
                String in_address = getInput();
                if (userManager.userLookup(in_phone_num)) {
                    sendOutput(sp.alreadyRegister());
                }
                else {
                    userManager.createUser(in_name, in_phone_num, in_password, in_type, in_address);
                    sendOutput(sp.greetCusRest());
                }
            }
            if (in_type.equals("r")) {
                sendOutput((sp.askRestaurantAddress()));
                String in_address = getInput();
                if (userManager.userLookup(in_phone_num)) {
                    sendOutput(sp.alreadyRegister());
                }
                else{
                    userManager.createUser(in_name, in_phone_num, in_password, in_type, in_address);
                    sendOutput(sp.greetCusRest());
                }
            }
            if (in_type.equals("d")) {
                if (userManager.userLookup(in_phone_num)) {
                    sendOutput(sp.alreadyRegister());
                }
                else{
                    sendOutput(sp.thankDperson());
                    userManager.createUser(in_name, in_phone_num, in_password, in_type, null);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}