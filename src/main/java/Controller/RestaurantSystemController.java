package Controller;


import Presenter.RestaurantSystemPresenter;
import UseCases.RestaurantManager;
import InOut.SystemInOut;

import java.io.IOException;
import java.util.Objects;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class RestaurantSystemController implements SystemInOut{

    RestaurantSystemPresenter rp;

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
                rp.askId();
                String numStr = inout.getInput();

                if (this.resManager.containProduct(numStr)) {
                    sendOutput(p.askChange());
                    String type = inout.getInput();
                    if (Objects.equals(type, "1")) {
                        sendOutput(rp.askName());
                        String newName = inout.getInput();
                        this.resManager.editName(numStr, newName);
                    }

                    if (Objects.equals(type, "2")) {
                        sendOutput(rp.askStock());
                        String stockString = inout.getInput();
                        int newStock = Integer.parseInt(stockString);
                        this.resManager.editRestaurantMenu(numStr, newStock);
                    }

                    if (Objects.equals(type, "3")) {
                        sendOutput((rp.askPeice());
                        double newPrice = Double.parseDouble(inout.getInput());
                        this.resManager.editPrice(numStr, newPrice);
                    } else {
                        sendOutput(rp.notInMenu());
                        sendOutput(rp.askName());
                        String prod_name = inout.getInput();
                        sendOutput(rp.askPrice());
                        String prod_price = inout.getInput();
                        sendOutput(rp.askStock());
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
