package InOut;

import Controller.BrowsingController;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;


public class SystemInOut implements BrowsingController.InOut {

    /**
     * Read system input
     */
    BufferedReader reader;

    public SystemInOut() { reader = new BufferedReader(new InputStreamReader(System.in));}

    @Override
    public String getInput() throws IOException {
        return reader.readLine();
    }

    @Override
    public void sendOutput(String output) {
        System.out.println(output);
    }
}
