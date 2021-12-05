package Presenter;

import Entity.Restaurant;
import UseCases.RestaurantManager;

import java.io.IOException;


public class RestaurantSystemPresenter {
    RestaurantManager rm;
    Restaurant res;
    InOut inout;

    public interface InOut {
        String getInput() throws IOException;

        void sendOutput(String output);
    }

    public RestaurantSystemPresenter() {
        this.rm = new RestaurantManager(res);
    }

    public void greeting() {
        inout.sendOutput("Some greeting words! Type receivedOrders, editMenu or orderHistory to begin.");
    }

    public void editOrView(boolean bool) {
        if (bool) {
            inout.sendOutput("Here is your menu, how would you like to edit your menu? Type the id of the selected product:");
        }
        inout.sendOutput("The product is already in the menu. Type 1 to change product name. Type 2 to " +
                "change product stock or delete the product. Type 3 to change the price of product");
    }

    public void editOptions(Integer num) {
        if (num == 1) {
            inout.sendOutput("Type the new product name.");
        }
        if (num == 2) {
            inout.sendOutput("Type the new product stock, where 0 representing deleting of the product.");
        }
        if (num == 3) {
            inout.sendOutput("Type the new product price formatting in a float number.");
        }
    }

    public void notInMenu(){
        inout.sendOutput("The product is not in the menu. We will help you add new product to your menu. ");
        inout.sendOutput("How did you name your new product? Please type below: ");

    }

    public void askNewPrice(){
        inout.sendOutput("Great! Now for each product how much do you wanna charge? Please type below: ");
    }

    public void askNewStock(){
        inout.sendOutput("Excellent! And don't forget type the number of product that are in stock right now below: ");
    }

    public void wrongCommand(){
        inout.sendOutput("wrong command:(");
    }
}
