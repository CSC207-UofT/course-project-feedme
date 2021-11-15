package Controller;


import UseCases.RestaurantManager;

import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

public class RestaurantSystemController{

    public interface InOut {
        String getInput() throws IOException;

        void sendOutput(String output);
    }

    public RestaurantManager resManager;

    public RestaurantSystemController(RestaurantManager resManager) {
        this.resManager = resManager;
    }

    public void run(InOut inout) throws IOException {

        while(true){

            inout.sendOutput("Some greeting words! Type receivedOrders, editMenu or orderHistory to begin.");
            String command = inout.getInput();
            if(Objects.equals(command, "editMenu")){
                this.resManager.getMenu();
                inout.sendOutput("Here is your menu, how would you like to edit your menu? Type the id of the selected product:");
                String numStr = inout.getInput();
                int pid = -1;
                try{
                    pid = Integer.parseInt(numStr);
                } catch (NumberFormatException e) {
                    inout.sendOutput("Wrong input, please enter an valid integer.");
                }

                if (this.resManager.containProduct(pid)) {
                    inout.sendOutput("The product is already in the menu. Type 1 to change product name. Type 2 to " +
                            "change product stock or delete the product. Type 3 to change the price of product");
                    String type = inout.getInput();
                    if (Objects.equals(type, "1")) {
                        inout.sendOutput("Type the new product name.");
                        String newName = inout.getInput();
                        this.resManager.editName(pid, newName);
                    }

                    if (Objects.equals(type, "2")) {
                        inout.sendOutput("Type the new product stock, where 0 representing deleting of the product.");
                        String stockString = inout.getInput();
                        int newStock = Integer.parseInt(stockString);
                        this.resManager.editRestaurantMenu(pid, newStock);
                    }

                    if (Objects.equals(type, "3")) {
                        inout.sendOutput("Type the new product price formatting in a float number.");
                        double newPrice = Double.parseDouble(inout.getInput());
                        this.resManager.editPrice(pid, newPrice);
                    } else {
                        inout.sendOutput("The product is not in the menu. We will help you add new product to your menu. ");
                        inout.sendOutput("How did you name your new product? Please type below: ");
                        String prod_name = inout.getInput();
                        inout.sendOutput("Great! Now for each product how much do you wanna charge? Please type below: ");
                        String prod_price = inout.getInput();
                        inout.sendOutput("Excellent! And don't forget type the number of product that are in stock right now below: ");
                        String prod_stock = inout.getInput();
                        this.resManager.createProduct(prod_name, Double.parseDouble(prod_price), Integer.parseInt(prod_stock));
                        break;
                    }
                }

                if (Objects.equals(command, "orderHistory")){
                    this.resManager.getOrderHistory();
                    break;
                }

                if (Objects.equals(command, "receiveOrders")) {
                    this.resManager.distributeOrder();
                    break;
                }}
        }
        {
            inout.sendOutput("wrong command:(");
        }
    }
}