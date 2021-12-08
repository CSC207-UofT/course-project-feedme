package Controller;


import InOut.SystemInOut;
import Presenter.OrderPresenter;
import UseCases.OrderUseCase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

/**
 * The controller for generating an order and add it to user's order history
 */
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
    private final OrderPresenter orderPresenter = new OrderPresenter();

    /**
     * Initiate the order controller
     * @param customerNum
     * @param restaurantNum
     * @param cart
     */
    public OrderController(String customerNum, String restaurantNum, Map<String, Integer> cart) {
        this.orderUseCase = new OrderUseCase(customerNum, restaurantNum, cart);
    }

    /**
     * Create Order and add it to user's history
     */
    public void createOrder(){
        String id = orderUseCase.makeOrder();
        sendOutput(orderPresenter.successMessage(id));

    }
}