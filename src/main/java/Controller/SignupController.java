package Controller;

import InOut.SystemInOut;
import Presenter.SignupPrompt;
import UseCases.UserManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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

                userManager.addUser(in_phone_num, userManager.createCustomer(in_name, in_phone_num,
                        in_password, "c", in_address));

                sendOutput(sp.greetCusRest());
            }

            if (in_type.equals("r")) {
                sendOutput((sp.askRestaurantAddress()));
                String in_address = getInput();
                userManager.addUser(in_phone_num, userManager.createRestaurant(in_name, in_phone_num, in_password,
                        "r", in_address));


                sendOutput(sp.greetCusRest());
            }

            if (in_type.equals("d")) {
                sendOutput(sp.thankDperson());
                userManager.addUser(in_phone_num, userManager.createDeliveryPerson(in_name, in_phone_num,
                        in_password, "d"));

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
