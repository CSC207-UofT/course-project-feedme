package DataAccess;

import Entity.Customer;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

public class CustomerGatherer {
    public List<Customer> getCustomerList(){
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Customers.ser"));
            return (List<Customer>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
