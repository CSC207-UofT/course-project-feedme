package Entity;


import java.io.Serializable;

public class DeliveryPerson extends User implements Serializable {
    private static final long serialVersionUID = 1;

    private final String transport;


    /**
     * DeliveryPerson is a child class of User. User type 'd' is assigned to DeliveryPerson class.
     * Construct a DeliveryPerson, giving the name, phone_num, password, and type.
     *
     * @param name        The name of DeliveryPerson
     * @param phone_num   The phone number of DeliveryPerson
     * @param password    The password of DeliveryPerson
     * @param type_       The type of User
     * @param transport   The transport that DeliveryPerson takes("w" for walk, "b" for bicycle, "v" for vehicle)
     */
    public DeliveryPerson(String name, String phone_num, String password, String type_, String transport) {
        super(name, phone_num, password, type_);
        this.transport = transport;
    }

    public DeliveryPerson(String name, String phone_num, String password, String type_) {
        super(name, phone_num, password, type_);
        this.transport = "w";
    }

    public DeliveryPerson(String name, String phone_num, String password) {
        super(name, phone_num, password, "d");
        this.transport = "w";
    }

    /**
     * Get DeliveryPerson's transport.
     *
     * @return a string of DeliveryPerson's transport.
     */
    public String getTransport() { return transport;}

    @Override
    public String toString() {
        return "DeliveryPerson{" +
                "transport='" + transport + '\'' +
                '}';
    }
}
