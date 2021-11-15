import Controller.Login;
import Controller.Signup;
import Entity.DeliveryPerson;
import UseCases.UserWriter;

import java.util.Scanner;

public class Systemoutput {
    public static void hello() {
        System.out.println("Welcome to Feed Me! Do you have a account? Type Y or N. If no, I will direct you to sign" +
                " up page!");
        Scanner sc = new Scanner(System.in);
        String y_or_n = sc.nextLine();
        Login login = new Login();
        if (y_or_n.equals("N")){
            Signup signup = new Signup();
            signup.output();
            login.output();
        }

        if (y_or_n.equals("Y")) {
            login.output();
        }
    }

    public static void main(String[] args) {
        UserWriter userWriter = new UserWriter();
        userWriter.addUser("pauline", "416", "abc", "c", "11 abc st.");
        userWriter.addUser(new DeliveryPerson("ian", "437", "ddddd", "d"));
    }
}
