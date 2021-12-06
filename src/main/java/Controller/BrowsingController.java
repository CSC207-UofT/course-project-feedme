package Controller;
import Presenter.BrowsingPrensenter;
import UseCases.BrowsingUseCase;
import InOut.SystemInOut;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * Controls the process for browsing restaurants menu and decide which restaurant to order.
 */

public class BrowsingController implements SystemInOut{


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



    /**
     * Initiate a new BrowsingUseCase which will read restaurant serialization file.
     */

    private final BrowsingUseCase browsingUsecase = new BrowsingUseCase();
    private final BrowsingPrensenter browsingPrensenter = new BrowsingPrensenter();

    /**
     * Method that allows customer to view and select restaurants.
     * @return The phone number of selected restaurants
     */

    public String selectRestaurant() {

        boolean confirmSelection = false;
        String restaurant = null;
        // While-loop for viewing restaurants' menu
        while (!confirmSelection) {
            // Show a list of restaurants
            sendOutput(browsingPrensenter.showRestaurantsList());
            try {
                String input = getInput();
                // While loop for checking valid input
                while (!browsingUsecase.verifyRestautantSeleciton(input)) {
                    sendOutput(browsingPrensenter.invalidMessage());
                    sendOutput(browsingUsecase.showRestaurants());
                    input = getInput();
                }
                // Save selected restaurant
                restaurant = browsingUsecase.getRestaurant(input);
                // Show menu
                sendOutput(browsingPrensenter.showRestaurantName(input));
                sendOutput(browsingUsecase.showMenu(input));

            } catch (IOException e) {
                sendOutput(browsingPrensenter.showError());
            }

            // Ask customer to confirm selection or exit.
            sendOutput(browsingPrensenter.askSelection());
            try {
                String input = getInput();
                if (input.equals("1")){
                    confirmSelection = true;
                    break;
                } else if (input.equals("3")) {
                    return null;
                }

            } catch (IOException e) {
                sendOutput(browsingPrensenter.showError());
            }
        }
    // Return the selected restaurant
        return restaurant;

    }
}
