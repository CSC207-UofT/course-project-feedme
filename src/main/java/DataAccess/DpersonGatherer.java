package UseCases;

import Entity.DeliveryPerson;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class DpersonGatherer {
    public ArrayList<DeliveryPerson> getCustomerArray(){
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Deliveryperson.txt"));
            return (ArrayList<DeliveryPerson>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
