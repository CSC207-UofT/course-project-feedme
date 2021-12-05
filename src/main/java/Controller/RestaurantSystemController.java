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
            if(Objects.equals(command, "editMenu")){
                this.resManager.getMenu();
                inout.sendOutput(rp.askId());
                String numStr = inout.getInput();

                if (this.resManager.containProduct(numStr)) {
                    inout.sendOutput(rp.askChange());
                    String type = inout.getInput();
                    if (Objects.equals(type, "1")) {
                        inout.sendOutput(rp.askName());
                        String newName = inout.getInput();
                        this.resManager.editName(numStr, newName);
                    }

                    if (Objects.equals(type, "2")) {
                        inout.sendOutput(rp.askStock());
                        String stockString = inout.getInput();
                        int newStock = Integer.parseInt(stockString);
                        this.resManager.editRestaurantMenu(numStr, newStock);
                    }

                    if (Objects.equals(type, "3")) {
                        inout.sendOutput(rp.askPrice());
                        double newPrice = Double.parseDouble(inout.getInput());
                        this.resManager.editPrice(numStr, newPrice);
                    }
                    else {
                        inout.sendOutput(rp.notInMenu());
                        inout.sendOutput(rp.askName());
                        String prod_name = inout.getInput();
                        inout.sendOutput(rp.askPrice());
                        String prod_price = inout.getInput();
                        inout.sendOutput(rp.askStock());
                        String prod_stock = inout.getInput();
                        this.resManager.createProduct(prod_name, Double.parseDouble(prod_price), Integer.parseInt(prod_stock));
                        break;
                    }
                }

                if (Objects.equals(command, "orderHistory")){
                    this.resManager.getOrderHistory();
                    break;
                }

                if (Objects.equals(command, "receiveOrders")) {
                    this.resManager.distributeOrder();
                    break;
                }}
        }
        {
            inout.sendOutput(rp.wrongCommand());
        }
    }
}
