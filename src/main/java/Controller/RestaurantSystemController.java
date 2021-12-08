package Controller;


import InOut.SystemInOut;
import Presenter.RestaurantSystemPresenter;
import UseCases.RestaurantManager;

import java.io.IOException;
import java.util.Objects;

public class RestaurantSystemController implements SystemInOut {

    public RestaurantManager resManager;
    public RestaurantSystemPresenter rp;

    @Override
    public String getInput() throws IOException {
        return null;
    }

    @Override
    public void sendOutput(String output) {

    }

    public RestaurantSystemController(RestaurantManager resManager) {
        this.resManager = resManager;
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