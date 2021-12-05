package DataAccess;

import Entity.DeliveryPerson;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

public class DpersonGatherer {
    public List<DeliveryPerson> getDpersonList(){
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Deliveryperson.ser"));
            return (List<DeliveryPerson>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
