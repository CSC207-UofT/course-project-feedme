package UserInterface;

import Controller.RestaurantSystemController;
import UseCases.RestaurantManager;

import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

public class RestaurantInterface{
    public static RestaurantSystemController resys;


    public static void main(String[] args){

        RestaurantManager resManager;

        Scanner scanner = new Scanner(System.in);

        while(true){

            System.out.println("Some greeting words! Type receivedOrders, editMenu or orderHistory to begin.");
            String command = scanner.nextLine();
            if(Objects.equals(command, "editMenu")){
                resys.getMenu();
                System.out.println("Here is your menu, how would you like to edit your menu? Type the id of the selected product:");
                String numStr = scanner.nextLine();
                int pid = -1;
                try{
                    pid = Integer.parseInt(numStr);
                } catch (NumberFormatException e) {
                    System.out.println("Wrong input, please enter an valid integer.");
                }

                if (resys.contain(pid)) {
                    System.out.println("The product is already in the menu. Type 1 to change product name. Type 2 to " +
                            "change product stock or delete the product. Type 3 to change the price of product");
                    String type = scanner.nextLine();
                    if (Objects.equals(type, "1")) {
                        System.out.println("Type the new product name.");
                        String newName = scanner.nextLine();
                        resys.editname(pid, newName);
                    }

                    if (Objects.equals(type, "2")) {
                        System.out.println("Type the new product stock, where 0 representing deleting of the product.");
                        String stockString = scanner.nextLine();
                        int newStock = Integer.parseInt(stockString);
                        resys.editRestaurantMenu(pid, newStock);
                    }

                    if (Objects.equals(type, "3")) {
                        System.out.println("Type the new product price formatting in a float number.");
                        double newPrice = Double.parseDouble(scanner.nextLine());
                        resys.editprice(pid, newPrice);
                    } else {
                        System.out.println("The product is not in the menu. We will help you add new product to your menu. ");
                        System.out.println("How did you name your new product? Please type below: ");
                        String prod_name = scanner.nextLine();
                        System.out.println("Great! Now for each product how much do you wanna charge? Please type below: ");
                        String prod_price = scanner.nextLine();
                        System.out.println("Excellent! And don't forget type the number of product that are in stock right now below: ");
                        String prod_stock = scanner.nextLine();
                        resys.create(prod_name, Double.parseDouble(prod_price), Integer.parseInt(prod_stock));
                        break;
                    }
                }

                if (Objects.equals(command, "orderHistory")){
                    resys.OrderHistory();
                    break;
                }

                if (Objects.equals(command, "receiveOrders")) {
                    resys.Distributed();
                    break;
                }}
    }
        {
            System.out.println("wrong command:(");
        }
}
}
