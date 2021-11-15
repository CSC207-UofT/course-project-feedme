package Controller;

import UseCases.UserManager;
import UseCases.UserWriter;

import java.io.IOException;

public class SignupController {
    public interface InOut {
        String getInput() throws IOException;

        void sendOutput(String output);
    }

    public void start(InOut inout) {
        try {
            UserManager userManager = new UserManager();
            UserWriter userWriter = new UserWriter();
            inout.sendOutput("Thank you to join Feed Me! May I get your name please?");
            String in_name = inout.getInput();
            inout.sendOutput("Now, I need your phone number, you would need to use phone number to login.");
            String in_phone_num = inout.getInput();
            inout.sendOutput("We have received your phone number, please enter your login password now.");
            String in_password = inout.getInput();
            inout.sendOutput("Would you like to become customer, restaurant partner or deliver man? please enter " +
                    "one character c (customer), r (restaurant), d (deliver man)");
            String in_type = inout.getInput();

            if (in_type.equals("c")) {
                inout.sendOutput("Thanks for becoming our honorable customer, the last steps for us is for you to " +
                        "provide your address.");
                String in_address = inout.getInput();

                userManager.addUser(in_phone_num, userManager.createCustomer(in_name, in_phone_num,
                        in_password, "c", in_address));
//                userWriter.addUser(userManager.createCustomer(in_name, in_phone_num,
//                        in_password, "c", in_address));
                inout.sendOutput("We have created your account, you are now able to sign in!");
            }

            if (in_type.equals("r")) {
                inout.sendOutput(("Thank you for partnering with FeedMe, the last step we would like to know your " +
                        "restaurant location."));
                String in_address = inout.getInput();
                userManager.addUser(in_phone_num, userManager.createRestaurant(in_name, in_phone_num, in_password,
                        "r", in_address));
//                userWriter.addUser(userManager.createRestaurant(in_name, in_phone_num, in_password,
//                        "r", in_address));

                inout.sendOutput("We have created your account! You are now able to sign in to your account!");
            }

            if (in_type.equals("d")) {
                inout.sendOutput("Thank you for delivery for us! We have created your account, please sign in now!");
                userManager.addUser(in_phone_num, userManager.createDeliveryPerson(in_name, in_phone_num,
                        in_password, "d"));
//                userWriter.addUser(userManager.createDeliveryPerson(in_name, in_phone_num,
//                        in_password, "d"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
