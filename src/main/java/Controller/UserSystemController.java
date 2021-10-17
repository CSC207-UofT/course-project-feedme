package Controller;

import Entity.User;
import UseCases.Usermanager;

public class UserSystemController {
    private Usermanager um;

    private UserSystemController(Usermanager um) { this.um = um; }

    public void create(String phone_num, User user) { um.createUser(phone_num, user); }

    public boolean verify(String phone_num, String enter_password) {
        return um.verifyUser(phone_num,  enter_password);
    }
}
