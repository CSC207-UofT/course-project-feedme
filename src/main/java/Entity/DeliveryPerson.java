package Entity;

import java.util.Set;

public class DeliveryPerson extends User {


    private Order currentOrder;
    private Set orderHistory;

    public Order getCurrentOrder() {
        return currentOrder;
    }

    public void setCurrentOrder(Order currentOrder) {
        this.currentOrder = currentOrder;
    }

    public Set getOrderHistory() {
        return orderHistory;
    }

    public void setOrderHistory(Set orderHistory) {
        this.orderHistory = orderHistory;
    }
    /**
     * DeliveryPerson is a child class of User. User type 'd' is assigned to DeliveryPerson class.
     * Construct a DeliveryPerson, giving the name, phone_num, password, and type.
     *
     * @param name        The name of DeliveryPerson
     * @param phone_num   The phone number of DeliveryPerson
     * @param password    The password of DeliveryPerson
     * @param type_       The type of User
     */
    public DeliveryPerson(String name, String phone_num, String password, char type_) {
        super(name, phone_num, password, type_);
    }
}
