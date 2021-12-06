package Controller;


import InOut.SystemInOut;
import UseCases.OrderUseCase;
import UseCases.UserManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

public class OrderController implements SystemInOut {
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

    private final OrderUseCase orderUseCase;

    public OrderController(String customerNum, String restaurantNum, Map<String, Integer> cart) {
        this.orderUseCase = new OrderUseCase(customerNum, restaurantNum, cart);
    }

    public void createOrder(){
        String id = orderUseCase.makeOrder();
        sendOutput("Order has been successfully created! Your order id is: " + id);

    }
}
