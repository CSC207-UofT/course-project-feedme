package UseCases;

import Entity.Customer;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class CustomerGatherer {
    public ArrayList<Customer> getCustomerArray(){
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("customers.txt"));
            return (ArrayList<Customer>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
