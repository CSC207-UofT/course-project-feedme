package Controller;

import UseCases.UserManager;

import java.util.Scanner;

public class Signup {
    public void output(){
        UserManager userManager = new UserManager();
        Scanner sc = new Scanner(System.in);
        System.out.println("Thank you to join Feed Me! May I get your name please?");
        String in_name = sc.nextLine();
        System.out.println("Now, I need your phone number, you would need to use phone number to login.");
        String in_phone_num = sc.nextLine();
        System.out.println("We have received your phone number, please enter your login password now.");
        String in_password = sc.nextLine();
        System.out.println("Would you like to become customer, restaurant partner or deliver man? please enter " +
                "one character c (customer), r (restaurant), d (deliver man)");
        String in_type = sc.nextLine();

        if (in_type.equals("c")){
            System.out.println("Thanks for becoming our honorable customer, the last steps for us is for you to " +
                    "provide your address.");
            String in_address = sc.nextLine();

            userManager.addUser(in_phone_num, userManager.createCustomer(in_name, in_phone_num,
                    in_password, 'c', in_address));
            System.out.println("We have created your account, you are now able to sign in!");
        }

        if (in_type.equals("r")){
            System.out.println(("Thank you for partnering with FeedMe, the last step we would like to know your " +
                    "restaurant location."));
            String in_address = sc.nextLine();
            userManager.addUser(in_phone_num, userManager.createRestaurant(in_name, in_phone_num, in_password,
                            'r', in_address));

            System.out.println("We have created your account! You are now able to sign in to your account!");
        }

        if (in_type.equals("d")){
            System.out.println("Thank you for delivery for us! We have created your account, please sign in now!");
        }
    }
}
