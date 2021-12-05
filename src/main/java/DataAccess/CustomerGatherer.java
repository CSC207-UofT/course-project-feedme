package DataAccess;

import Entity.Customer;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class CustomerGatherer {
    public ArrayList<Customer> getCustomerArray(){
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Customers.ser"));
            return (ArrayList<Customer>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
