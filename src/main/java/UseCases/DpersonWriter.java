package UseCases;

import Entity.DeliveryPerson;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class DpersonWriter {
    public void updateRestaurant(ArrayList<DeliveryPerson> d_person_list) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Deliveryperson.txt"));
            oos.writeObject(d_person_list);
            oos.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
