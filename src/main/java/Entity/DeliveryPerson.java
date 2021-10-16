package Entity;

/**
 * DeliveryPerson is a child class of User. User type 'd' is assigned to DeliveryPerson class.
 */

public class DeliveryPerson extends User {
    //Initiate a DeliveryPerson
    public DeliveryPerson(String name, String phone_num, String password, char type_) {
        super(name, phone_num, password, type_);
    }
}
