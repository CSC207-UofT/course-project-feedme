package InOut;
import java.io.IOException;

public interface SystemInOut {

    /**
     * Input and output boundary that implements InOut in each controller. SystemInOut collect client's input from UI
     * and sent input to controller. It also returns desired output from controller to UI.
     */

    // Get client's input form UI and sent to controller.
     String getInput() throws IOException;
    // Return desired output from controller to UI.
     void sendOutput(String output);
}
