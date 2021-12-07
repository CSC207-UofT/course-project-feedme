package Controller;

import InOut.SystemInOut;
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
            UserManager userManager = new UserManager();
            sendOutput("Thank you for joining Feed Me! May I have your name please?");
            String in_name = getInput();
            sendOutput("Now, I need your phone number, you will need to use the phone number to login.");
            String in_phone_num = getInput();
            sendOutput("We have received your phone number, please enter your login password.");
            String in_password = getInput();
            sendOutput("Would you like to become customer, restaurant partner or deliver man? please enter " +
                    "one character c (customer), r (restaurant), d (deliver man).");
            String in_type = getInput();

            if (in_type.equals("c")) {
                sendOutput("Thanks for becoming our honorable customer, the last step is to provide your address.");
                String in_address = getInput();
                if (userManager.createCustomer(in_name, in_phone_num, in_password, "c", in_address)) {
                    userManager.createCustomer(in_name, in_phone_num, in_password, "c", in_address);
                    sendOutput("We have created your account, you are now able to login!");
                }
                else {
                    sendOutput("You've already registered with this phone number, please login.");
                }
//                userWriter.addUser(userManager.createCustomer(in_name, in_phone_num,
//                        in_password, "c", in_address));
            }

            if (in_type.equals("r")) {
                sendOutput(("Thanks for partnering with Feed Me, the last step is to provide your restaurant's location."));
                String in_address = getInput();
                if (userManager.createRestaurant(in_name, in_phone_num, in_password, "r", in_address)) {
                    userManager.createRestaurant(in_name, in_phone_num, in_password, "r", in_address);
                    sendOutput("We have created your account! You are now able to login!");
                } else {
                    sendOutput("You've already registered with this phone number, please login");
                }
//                userWriter.addUser(userManager.createRestaurant(in_name, in_phone_num, in_password,
//                        "r", in_address));
            }

            if (in_type.equals("d")) {
                if (userManager.createDeliveryPerson(in_name, in_phone_num, in_password, "d")) {
                    userManager.createDeliveryPerson(in_name, in_phone_num, in_password, "d");
                    sendOutput("Thank you for delivering for us! We have created your account, you are now able to login!");
                }
                else {
                    sendOutput("You've already registered with this phone number, please login");
                }
//                userWriter.addUser(userManager.createDeliveryPerson(in_name, in_phone_num,
//                        in_password, "d"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
