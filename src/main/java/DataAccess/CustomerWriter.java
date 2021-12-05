package DataAccess;

import Entity.Customer;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class CustomerWriter {
    public void updateRestaurant(ArrayList<Customer> customer_list){
        try{
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Customers.ser"));
            oos.writeObject(customer_list);
            oos.close();

        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
