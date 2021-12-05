package Controller;


import Presenter.RestaurantSystemPresenter;
import UseCases.RestaurantManager;

import java.io.IOException;
import java.util.Objects;

public class RestaurantSystemController{

    RestaurantSystemPresenter rp;

    public interface InOut {
        String getInput() throws IOException;

        void sendOutput(String output);
    }

    public RestaurantManager resManager;

    public RestaurantSystemController(RestaurantManager resManager) {
        this.resManager = resManager;
    }

    public void run(InOut inout) throws IOException {

        while(true){

            rp.greeting();
            String command = inout.getInput();
            if(Objects.equals(command, "editMenu")){
                this.resManager.getMenu();
                rp.editOrView(true);
                String numStr = inout.getInput();

                if (this.resManager.containProduct(numStr)) {
                    rp.editOrView(false);
                    String type = inout.getInput();
                    if (Objects.equals(type, "1")) {
                        rp.editOptions(1);
                        String newName = inout.getInput();
                        this.resManager.editName(numStr, newName);
                    }

                    if (Objects.equals(type, "2")) {
                        rp.editOptions(2);
                        String stockString = inout.getInput();
                        int newStock = Integer.parseInt(stockString);
                        this.resManager.editRestaurantMenu(numStr, newStock);
                    }

                    if (Objects.equals(type, "3")) {
                        rp.editOptions(3);
                        double newPrice = Double.parseDouble(inout.getInput());
                        this.resManager.editPrice(numStr, newPrice);
                    } else {
                        rp.notInMenu();
                        String prod_name = inout.getInput();
                        rp.askNewPrice();
                        String prod_price = inout.getInput();
                        rp.askNewStock();
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
            rp.wrongCommand();
        }
    }
}