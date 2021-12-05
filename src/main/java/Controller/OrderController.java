package Controller;
import UseCases.CartUseCase;
import InOut.SystemInOut;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

/**
 * Controller that controls the process for adding item into cart
 */

public class OrderController implements SystemInOut {

    /**
     * OrderController's InOut interface that is implemented by SymtemInOut
     */

    @Override
    public String getInput() throws IOException {
        BufferedReader reader;
        reader = new BufferedReader(new InputStreamReader(System.in));
        return reader.readLine();
    }

    @Override
    public void sendOutput(String output) {
        System.out.println(output);
    }

    private final CartUseCase cartUseCase;

    /**
     *
     * @param restaurantNum The phone number of selected restaurant which is returned by BrosingUI.
     */

    public OrderController(String restaurantNum) {
        this.cartUseCase = new CartUseCase(restaurantNum);
    }

    /**
     * addToCart method in OrderController which allows user to add things to cart.
     * @return Cart that is ready to be used to generate an Order.
     */
    public Map<String, Integer> addToCart() {
        sendOutput("\n" + cartUseCase.showRestaurantName() + ":");
        boolean orderMore = true;
        // While-loop for checking if the customer wants to add more items into the cart.
        while (orderMore) {
            String tempProduct = null;
            boolean verifyProductName = false;
            // While-loop for verifying if product is in the menu
            while (!verifyProductName) {
                // Show menu
                sendOutput("\n" + cartUseCase.showMenu());
                sendOutput("\nPlease enter the number of the product that you would like to order: ");
                try{
                    String input = getInput();
                    if (!cartUseCase.verifyProductNum(input)){
                        sendOutput("\nInvalid input. please check the menu and re-enter the number.\n");
                    }
                    else {
                        verifyProductName = true;
                        tempProduct = cartUseCase.getProductName(input);
                    }
                } catch (IOException e) {
                    sendOutput("Something went wrong");
                }
            }

            sendOutput("\nPlease enter the quantity you would like to order:");
            try{
                String input = getInput();
                // Check if item has enough stock
                if (cartUseCase.checkStockAvailability(tempProduct, Integer.valueOf(input))){
                    cartUseCase.addToCart(tempProduct, Integer.valueOf(input));
                    sendOutput("\nItem has successfully added to cart");
                    sendOutput("\n" + cartUseCase);

                } else {
                    sendOutput("\nSorry, there isn't enough stock" );
                }

            } catch (IOException e) {
                sendOutput("Something went wrong");
            }
            // Ask customer if they would like to add another item into the cart or if they are ready to confirm order.
            sendOutput("\nPlease type '1' if you would like to order another item, type '2' if you are readly " +
                    "to submit your order");
            try {
                String input = getInput();
                if (input.equals("2")) {
                    orderMore = false;
                }
            } catch (IOException e) {
                sendOutput("Something went wrong");
            }

        }
        // Return a Cart
        return cartUseCase.cartToMap();
    }

}
