package Controller;

import Entity.Cart;
import Entity.Product;
import Entity.Restaurant;
import UseCases.CartUseCase;
import java.io.IOException;

public class OrderController {

    public interface InOut {
        String getInput() throws IOException;

        void sendOutput(String output);
    }

    private final CartUseCase cartUseCase;
    private final Restaurant restaurant;

    public OrderController(Restaurant restaurant) {
        this.restaurant = restaurant;
        this.cartUseCase = new CartUseCase(restaurant);
    }

    public Cart addToCart(InOut inOut) {
        boolean confirmOrder = false;
        inOut.sendOutput("\n" + this.restaurant.toString() + ":");
        boolean orderMore = true;
        while (orderMore) {
            Product tempProduct = null;
            boolean verifyProductName = false;
            while (!verifyProductName) {
                inOut.sendOutput("\n" + cartUseCase.showMenu(this.restaurant));
                inOut.sendOutput("\nPlease enter the number of the product that you would like to order: ");
                try{
                    String input = inOut.getInput();
                    if (!cartUseCase.verifyProductNum(input)){
                        inOut.sendOutput("\nInvalid input. please check the menu and re-enter the number.\n");
                        inOut.sendOutput("\n" + cartUseCase.showMenu(this.restaurant));
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
                if (cartUseCase.checkStockAvailability(tempProduct, Integer.valueOf(input))){
                    cartUseCase.addToCart(tempProduct, Integer.valueOf(input));
                    inOut.sendOutput("\nItem has successfully added to cart");
                    inOut.sendOutput("\n" + cartUseCase.toString());

                } else {
                    inOut.sendOutput("\nSorry, there isn't enough stock" );
                }

            } catch (IOException e) {
                inOut.sendOutput("Something went wrong");
            }

            inOut.sendOutput("\nPlease type '1' if you would like to order another item, type '2' if you are readly " +
                    "to submit your order");
            try {
                String input = inOut.getInput();
                if (input.equals("1")) {
                    continue;
                } else {
                    orderMore = false;
                }
            } catch (IOException e) {
                inOut.sendOutput("Something went wrong");
            }

        }
        return cartUseCase.getCart();
    }

}
