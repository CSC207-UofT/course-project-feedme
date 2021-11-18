package InOut;

import Controller.BrowsingController;
import Controller.LoginController;
import Controller.OrderController;
import Controller.SignupController;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;


public class SystemInOut implements BrowsingController.InOut, OrderController.InOut
                                    , LoginController.InOut, SignupController.InOut {

    /**
     * Input and output boundary that implements InOut in each controller. SystemInOut collect client's input from UI
     * and sent input to controller. It also returns desired output from controller to UI.
     */
    BufferedReader reader;

    public SystemInOut() { reader = new BufferedReader(new InputStreamReader(System.in));}

    // Get client's input form UI and sent to controller.
    @Override
    public String getInput() throws IOException {
        return reader.readLine();
    }
    // Return desired output from controller to UI.
    @Override
    public void sendOutput(String output) {
        System.out.println(output);
    }
}
