import Entity.User;

class DeliveryPerson extends User {
    public DeliveryPerson(String name, int id, String phone_num, String password, char type_) {
        super(name, phone_num, password, type_);
    }
}
