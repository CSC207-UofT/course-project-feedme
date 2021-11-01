package Controller;

import Entity.*;
import UseCases.CartManager;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public class OrderSystem {
    private Restaurant restaurant;

    public void orderSystem() {
        CartManager cartManager = new CartManager();
        Scanner scan = new Scanner(System.in);
        //TODO: Show menu

        //While loop or order another item.
        boolean orderAgain = true;
        while (orderAgain) {
            boolean verifyProductName = false;
            String productNameIn = null;
            Product productIn = null;
            Integer quantityIn = null;
            while (!verifyProductName) {
                System.out.println("Please enter the name of the product that you would like to order:");
                productNameIn = scan.nextLine();
                //TODO: Check if product name is input correctly if not ask client to input again.
                if (!cartManager.verifyProductName(restaurant, productNameIn)) {
                    System.out.println("The product you entered is not in the menu, please check the menu and entered " +
                            "again:");
                    //TODO: Show menu
                } else {
                    verifyProductName = true;
                    productIn = cartManager.productNameToProduct(restaurant, productNameIn);
                }
            }

            System.out.println("Please enter the quantity you would like to order:");
            quantityIn = Integer.valueOf(scan.nextLine());
            //TODO: Check if there is enough stock. If there isn't enough stock, print stock number.
            if (cartManager.checkStockAvailability(productIn, quantityIn)) {
                cartManager.addToCart(productIn, quantityIn);
                System.out.println(productNameIn + " has added to your cart");
                //TODO: Show cart
            } else {
                System.out.println("Sorry, " + productNameIn + " does not have enough stock");
            }

            //TODO: Ask if customer would like to add another product.
            System.out.println("Please press ENTER if you like to order another item, and press other keys if you " +
                    "would like to review your other:");
            String moreItem = scan.nextLine();
            if (!moreItem.equals("")) {
                orderAgain = false;
            }

            //TODO: Review order
            //TODO: Show cart


        }
    }
}
