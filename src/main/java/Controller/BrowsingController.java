package Controller;

import UseCases.BrowsingUseCase;

import java.io.IOException;

/**
 * Controls the process for browsing restaurants menu and decide which restaurant to order.
 */

public class BrowsingController{

    /**
     * The input and output boundary fo the browsing use case.
     */

    public interface InOut {
        String getInput() throws IOException;

        void sendOutput(String output);
    }

    private final BrowsingUseCase browsingUsecase = new BrowsingUseCase();

    public void viewRestaurants(InOut inOut) {
        inOut.sendOutput(browsingUsecase.showRestaurants());

        try{
            String input = inOut.getInput();

            while (!browsingUsecase.verifyRestautantSeleciton(input)){
                inOut.sendOutput("The number you entered is not in the list. Please check and re-enter the number.");
                inOut.sendOutput(browsingUsecase.showRestaurants());
                input = inOut.getInput();
            }

            if (browsingUsecase.verifyRestautantSeleciton(input)){
                inOut.sendOutput("Here is the menu:");
            }


        } catch (IOException e) {
            inOut.sendOutput("Invaid input!");
        }

    }




}
