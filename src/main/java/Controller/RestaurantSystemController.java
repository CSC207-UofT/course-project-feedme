package Controller;


import Presenter.RestaurantSystemPresenter;
import UseCases.RestaurantManager;
import InOut.SystemInOut;

import java.io.IOException;
import java.util.Objects;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class RestaurantSystemController implements SystemInOut{

    public RestaurantManager resManager;
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

    public RestaurantSystemController(RestaurantManager resManager) {
        this.resManager = resManager;
    }

    public void run() throws IOException {

        while(true){

            sendOutput(rp.greeting());
            String command = getInput();
            if(Objects.equals(command, "editMenu")){
                this.resManager.getMenu();
                sendOutput(rp.askId());
                String numStr = getInput();

                if (this.resManager.containProduct(numStr)) {
                    sendOutput(rp.askChange());
                    String type = getInput();
                    if (Objects.equals(type, "1")) {
                        sendOutput(rp.askName());
                        String newName = getInput();
                        this.resManager.editName(numStr, newName);
                    }

                    if (Objects.equals(type, "2")) {
                        sendOutput(rp.askStock());
                        String stockString = getInput();
                        int newStock = Integer.parseInt(stockString);
                        this.resManager.editRestaurantMenu(numStr, newStock);
                    }

                    if (Objects.equals(type, "3")) {
                        sendOutput(rp.askPrice());
                        double newPrice = Double.parseDouble(getInput());
                        this.resManager.editPrice(numStr, newPrice);
                    } else {
                        sendOutput(rp.notInMenu());
                        sendOutput(rp.askName());
                        String prod_name = getInput();
                        sendOutput(rp.askPrice());
                        String prod_price = getInput();
                        sendOutput(rp.askStock());
                        String prod_stock = getInput();
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
            sendOutput(rp.wrongCommand());
        }
    }
}
