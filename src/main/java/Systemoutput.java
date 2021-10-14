import UseCases.Usermanager;

import java.util.Objects;
import java.util.Scanner;

public class Systemoutput {
    public static void main(String[] args){
        Usermanager usermanager = new Usermanager();
        System.out.println("Welcome to Feed Me! Do you have a account? Type Y or N. If no, I will direct you to sign" +
                " up page!");

        Scanner sc=new Scanner(System.in);

        String y_or_n = sc.nextLine();

        if (y_or_n.equals("N")){
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

                usermanager.add_user(in_phone_num, usermanager.customer_signup(in_name, in_phone_num,
                                                                    in_password, 'c', in_address));
            }
            System.out.println(usermanager.user_lookup(in_phone_num));
        }

    }
}
