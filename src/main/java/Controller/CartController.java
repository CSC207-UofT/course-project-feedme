package Controller;
import Presenter.CartPresenter;
import UseCases.CartUseCase;
import InOut.SystemInOut;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

/**
 * Controller that controls the process for adding item into cart
 */

public class CartController implements SystemInOut {

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
    private final CartPresenter cartPresenter;


    /**
     * Initiate a CartController
     * @param restaurantNum The phone number of selected restaurant which is returned by BrowsingUI.
     */

    public CartController(String restaurantNum) {
        this.cartUseCase = new CartUseCase(restaurantNum);
        this.cartPresenter = new CartPresenter(restaurantNum);
    }

    /**
     * addToCart method in OrderController which allows user to add things to cart.
     * @return Map<String, Integer> which contains the product name and quantity and will be used by orderUI to
     * generate order.
     */
    public Map<String, Integer> addToCart() {
        sendOutput(cartPresenter.showRestaurantName());
        boolean orderMore = true;
        // While-loop for checking if the customer wants to add more items into the cart.
        while (orderMore) {
            String tempProduct = null;
            boolean verifyProductName = false;
            // While-loop for verifying if product is in the menu
            while (!verifyProductName) {
                // Show menu
                sendOutput(cartPresenter.showRestaurantMenu());
                sendOutput(cartPresenter.askProductSelection());
                try{
                    String input = getInput();
                    if (!cartUseCase.verifyProductNum(input)){
                        sendOutput(cartPresenter.invalidMessage());
                    }
                    else {
                        verifyProductName = true;
                        tempProduct = cartUseCase.getProductName(input);
                    }
                } catch (IOException e) {
                    sendOutput(cartPresenter.errorMessage());
                }
            }

            sendOutput(cartPresenter.askQuantity());
            try{
                String input = getInput();
                // Check if item has enough stock
                if (cartUseCase.checkStockAvailability(tempProduct, Integer.valueOf(input))){
                    cartUseCase.addToCart(tempProduct, Integer.valueOf(input));
                    sendOutput(cartPresenter.showSuccess());
                    sendOutput("\n" + cartUseCase);

                } else {
                    sendOutput(cartPresenter.noStock());
                }

            } catch (IOException e) {
                sendOutput(cartPresenter.errorMessage());
            }
            // Ask customer if they would like to add another item into the cart or if they are ready to confirm order.
            sendOutput(cartPresenter.askSubmitOrder());
            try {
                String input = getInput();
                if (input.equals("2")) {
                    orderMore = false;
                }
            } catch (IOException e) {
                sendOutput(cartPresenter.errorMessage());
            }

        }
        return cartUseCase.cartToMap();
    }


}
