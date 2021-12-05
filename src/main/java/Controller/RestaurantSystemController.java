package Controller;


import Presenter.RestaurantSystemPresenter;
import UseCases.RestaurantManager;

import java.io.IOException;
import java.util.Objects;

public class RestaurantSystemController{

    public RestaurantManager resManager;
    RestaurantSystemPresenter rp;

    public interface InOut {
        String getInput() throws IOException;

        void sendOutput(String output);
    }
    public RestaurantSystemController(RestaurantManager resManager) {
        this.resManager = resManager;
    }
    public void run(InOut inout) throws IOException {

        while(true){


            inout.sendOutput(rp.greeting());
            String command = inout.getInput();
            if(verifyQuit(command)){
                break;
            }
            while(Objects.equals(command, "editMenu")) {
                this.resManager.getMenu();
                inout.sendOutput(rp.askId());
                String numStr = inout.getInput();
                if (verifyQuit(numStr)) {
                    break;
                }

                if (this.resManager.containProduct(numStr)) {
                    inout.sendOutput(rp.askChange());
                    String type = inout.getInput();
                    if (verifyQuit(type)) {
                        break;
                    }
                    if (Objects.equals(type, "1")) {
                        inout.sendOutput(rp.askName());
                        String newName = inout.getInput();
                        if (verifyQuit(newName)) {
                            break;
                        }
                        this.resManager.editName(numStr, newName);
                    }

                    if (Objects.equals(type, "2")) {
                        inout.sendOutput(rp.askStock());
                        String stockString = inout.getInput();
                        if (verifyQuit(stockString)) {
                            break;
                        }
                        int newStock = Integer.parseInt(stockString);
                        this.resManager.editRestaurantMenu(numStr, newStock);
                    }

                    if (Objects.equals(type, "3")) {
                        inout.sendOutput(rp.askPrice());
                        String priceStr = inout.getInput();
                        if (verifyQuit(priceStr)) {
                            break;
                        }
                        double newPrice = Double.parseDouble(priceStr);
                        this.resManager.editPrice(numStr, newPrice);
                    } else {
                        inout.sendOutput(rp.notInMenu());
                        inout.sendOutput(rp.askName());
                        String prodName = inout.getInput();
                        if (verifyQuit(prodName)) {
                            break;
                        }
                        inout.sendOutput(rp.askPrice());
                        String prodPrice = inout.getInput();
                        if (verifyQuit(prodPrice)) {
                            break;
                        }
                        inout.sendOutput(rp.askStock());
                        String prodStock = inout.getInput();
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
