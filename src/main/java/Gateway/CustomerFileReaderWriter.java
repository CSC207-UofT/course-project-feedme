package Gateway;

import java.io.*;
import java.util.ArrayList;

public class CustomerFileReaderWriter {
    public void saveCustomerToFile(ArrayList customerList) {
        try
        {
            FileOutputStream fos = new FileOutputStream("customer.csv");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(customerList);
            oos.close();
            fos.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public ArrayList readUserFromFile() {
        ArrayList customerList = new ArrayList<>();
        try
        {
            File file = new File("customer.csv");
            file.createNewFile();
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);

            customerList = (ArrayList) ois.readObject();
            ois.close();
            fis.close();
        }
        catch(EOFException e) {
            customerList = new ArrayList<>();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return customerList;
    }
}
