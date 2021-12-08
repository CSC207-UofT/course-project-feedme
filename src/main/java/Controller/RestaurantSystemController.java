package Controller;


import Entity.Restaurant;
import InOut.SystemInOut;
import Presenter.RestaurantSystemPresenter;
import UseCases.RestaurantManager;
import UseCases.BrowsingUseCase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

/**
 * Controls the process for editing menu, checking out the order history and receiving orders.
 */

public class RestaurantSystemController implements SystemInOut {

    public RestaurantManager resManager;
    public RestaurantSystemPresenter rp;
    protected BrowsingUseCase browsingUseCase;


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
     * Method that allows restaurant owner to edit, view on the restaurant menus.
     */

    public RestaurantSystemController(String resNUm) {
        assert false;
        this.resManager = new RestaurantManager(browsingUseCase.findRestaurant(resNUm));
        this.rp = new RestaurantSystemPresenter();
    }


    public boolean verifyQuit(String command){
        return command.equals("quit");
    }

    public void run() throws IOException {
        while(true){
            sendOutput(rp.greeting());
            String command = getInput();
            if(verifyQuit(command)){
                break;
            }
            while(Objects.equals(command, "editMenu")) {
                this.resManager.getMenu();
                sendOutput(rp.askId());
                String numStr = getInput();
                if (verifyQuit(numStr)) {
                    System.out.println("quit detected");
                    break;
                }
                System.out.println("result:"+ this.resManager.containProduct(numStr));

                if (this.resManager.containProduct(numStr)) {
                    sendOutput(rp.askChange());
                    String type = getInput();
                    if (verifyQuit(type)) {
                        break;
                    }
                    if (Objects.equals(type, "1")) {
                        sendOutput(rp.askName());
                        String newName = getInput();
                        if (verifyQuit(newName)) {
                            break;
                        }
                        this.resManager.editName(numStr, newName);
                    }

                    if (Objects.equals(type, "2")) {
                        sendOutput(rp.askStock());
                        String stockString = getInput();
                        if (verifyQuit(stockString)) {
                            break;
                        }
                        int newStock = Integer.parseInt(stockString);
                        this.resManager.editRestaurantMenu(numStr, newStock);
                    }

                    if (Objects.equals(type, "3")) {
                        sendOutput(rp.askPrice());
                        String priceStr = getInput();
                        if (verifyQuit(priceStr)) {
                            break;
                        }
                        double newPrice = Double.parseDouble(priceStr);
                        this.resManager.editPrice(numStr, newPrice);
                    }
                    else {
                        sendOutput(rp.notInMenu());
                        sendOutput(rp.askName());
                        String prodName = getInput();
                        if (verifyQuit(prodName)) {
                            break;
                        }
                        sendOutput(rp.askPrice());
                        String prodPrice = getInput();
                        if (verifyQuit(prodPrice)) {
                            break;
                        }
                        sendOutput(rp.askStock());
                        String prodStock = getInput();
                        if (verifyQuit(prodStock)) {
                            break;
                        }
                        this.resManager.createProduct(prodName, Double.parseDouble(prodPrice), Integer.parseInt(prodStock));
                        break;
                    }
                }
            }
            if (Objects.equals(command, "orderHistory")){
                this.resManager.getOrderHistory();
            }

            if (Objects.equals(command, "receiveOrders")) {
                this.resManager.distributeOrder();
            }
        }
    }

}