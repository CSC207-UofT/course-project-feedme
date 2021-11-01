package Entity;

public class DeliveryPerson extends User {


    /**
     * DeliveryPerson is a child class of User. User type 'd' is assigned to DeliveryPerson class.
     * Construct a DeliveryPerson, giving the name, phone_num, password, and type.
     *
     * @param name        The name of DeliveryPerson
     * @param phone_num   The phone number of DeliveryPerson
     * @param password    The password of DeliveryPerson
     * @param type_       The type of User
     */
    public DeliveryPerson(String name, String phone_num, String password, String type_) {
        super(name, phone_num, password, type_);
    }
}
