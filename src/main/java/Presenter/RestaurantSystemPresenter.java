package Presenter;

import Entity.Restaurant;
import UseCases.RestaurantManager;

import java.io.IOException;


public class RestaurantSystemPresenter {

    public String greeting() {
        return "Welcome! Type receivedOrders, editMenu or orderHistory to begin.";
    }

    public String askId() {
        return "Here is your menu, how would you like to edit your menu? Type the id of the selected product:";
    }
    public String askChange() {
        return "The product is already in the menu. Type 1 to change product name. Type 2 to " +
                "change product stock or delete the product. Type 3 to change the price of product";
    }

    public String askName() {
        return "Type the new product name.";
    }
    public String askStock() {
        return "Type the new product stock, where 0 representing deleting of the product.";
    }
    public String askPrice() {
        return "Type the new product price formatting in a float number.";
    }

    public String notInMenu(){
        return "The product is not in the menu. We will help you add new product to your menu. ";
    }

    public String wrongCommand(){
        return "wrong command:";
    }
}
