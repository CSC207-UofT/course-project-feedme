package UserInterface;

import Entity.User;
import UseCases.Usermanager;

import java.util.Scanner;

/**
 * This class manages to Login process of Feedme.
 */
public class Login {
    public void output(){
        Usermanager usermanager = new Usermanager();
        Scanner sc = new Scanner(System.in);

        boolean verifier = false;
        while (!verifier) {
            System.out.println("Please enter your registered phone number:");
            String phone_input = sc.nextLine();
            System.out.println("Please enter your password: ");
            String password_input = sc.nextLine();
            if (usermanager.check_password(phone_input, password_input)){
                verifier = true;
            }
        }
        System.out.println("You have successfully login.");
    }
}
