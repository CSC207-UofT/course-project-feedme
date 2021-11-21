package Controller;

import Entity.*;
import UseCases.CartUseCase;
import UseCases.OrderManager;

import java.io.IOException;

/**
 * Controller that controls the process for adding item into cart
 */

public class OrderController {

    /**
     * OrderController's InOut interface that is implemented by SymtemInOut
     */

    public interface InOut {
        String getInput() throws IOException;

        void sendOutput(String output);
    }

    private final CartUseCase cartUseCase;
    private final Restaurant restaurant;

    /**
     *
     * @param restaurant selected restaurant which is returned by BrosingUI.
     */

    public OrderController(Restaurant restaurant) {
        this.restaurant = restaurant;
        this.cartUseCase = new CartUseCase(restaurant);
    }

    /**
     * addToCart method in OrderController which allows user to add things to cart.
     * @param inOut input and output boundary.
     * @return Cart that is ready to be used to generate an Order.
     */
    public Cart addToCart(InOut inOut) {
        inOut.sendOutput("\n" + this.restaurant + ":");
        boolean orderMore = true;
        // While-loop for checking if the customer wants to add more items into the cart.
        while (orderMore) {
            Product tempProduct = null;
            boolean verifyProductName = false;
            // While-loop for verifying if product is in the menu
            while (!verifyProductName) {
                // Show menu
                inOut.sendOutput("\n" + cartUseCase.showMenu(this.restaurant));
                inOut.sendOutput("\nPlease enter the number of the product that you would like to order: ");
                try{
                    String input = inOut.getInput();
                    if (!cartUseCase.verifyProductNum(input)){
                        inOut.sendOutput("\nInvalid input. please check the menu and re-enter the number.\n");
                    }
                    else {
                        verifyProductName = true;
                        tempProduct = cartUseCase.getProduct(input);
                    }
                } catch (IOException e) {
                    inOut.sendOutput("Something went wrong");
                }
            }

            inOut.sendOutput("\nPlease enter the quantity you would like to order:");
            try{
                String input = inOut.getInput();
                // Check if item has enough stock
                if (cartUseCase.checkStockAvailability(tempProduct, Integer.valueOf(input))){
                    cartUseCase.addToCart(tempProduct, Integer.valueOf(input));
                    inOut.sendOutput("\nItem has successfully added to cart");
                    inOut.sendOutput("\n" + cartUseCase);

                } else {
                    inOut.sendOutput("\nSorry, there isn't enough stock" );
                }

            } catch (IOException e) {
                inOut.sendOutput("Something went wrong");
            }
            // Ask customer if they would like to add another item into the cart or if they are ready to confirm order.
            inOut.sendOutput("\nPlease type '1' if you would like to order another item, type '2' if you are readly " +
                    "to submit your order");
            try {
                String input = inOut.getInput();
                if (input.equals("2")) {
                    orderMore = false;
                }
            } catch (IOException e) {
                inOut.sendOutput("Something went wrong");
            }

        }
        // Return a Cart
        return cartUseCase.getCart();
    }
}
