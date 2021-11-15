package Controller;

import UseCases.UserManager;

import java.util.Scanner;

/**
 * This class manages to Login process of Feedme.
 */
public class Login {
    public void output(){
        UserManager userManager = new UserManager();
        Scanner sc = new Scanner(System.in);
        userManager.initUserMap();
        boolean verifier = false;
        while (!verifier) {
            System.out.println("Please enter your registered phone number:");
            String phone_input = sc.nextLine();
            System.out.println("Please enter your password: ");
            String password_input = sc.nextLine();
            if (userManager.verifyUser(phone_input, password_input)){
                verifier = true;
            }
        }
        System.out.println("You have successfully login.");
    }
}
