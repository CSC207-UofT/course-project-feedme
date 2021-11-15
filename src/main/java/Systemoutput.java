import Controller.Login;
import Controller.Signup;
import Entity.Product;
import Entity.Restaurant;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Systemoutput implements Serializable {
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
    @SuppressWarnings("Unchecked")
    public static void main(String[] args) {
        Product p1 = new Product("fish", "001", 30.2, 10);
        Product p2 = new Product("chicken", "002", 21.1, 2);
        Restaurant r1 = new Restaurant("Edward's resturant","647", "abc", "r"
                , "12 abc st.");
        r1.addProductToMenu(p1);
        Restaurant r2 = new Restaurant("Pig's resturant","416", "abc", "r"
                , "15 abc st.");
        r2.addProductToMenu(p2);
        try{
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("restaurants.txt", true));
            ArrayList<Restaurant> restaurants = new ArrayList<>();
            restaurants.add(r1);
            restaurants.add(r2);
            oos.writeObject(restaurants);
            oos.close();
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("restaurants.txt"));
            ArrayList<Restaurant> rArr = (ArrayList<Restaurant>) ois.readObject();
            for (Restaurant restaurant: rArr){
                List<Product> menu = restaurant.getRestaurantProducts();
                for (Product p: menu){
                    System.out.println(p.getProductName());
                }
            }
            ois.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
