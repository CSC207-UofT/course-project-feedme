package Controller;

import Entity.User;
import UseCases.UserManager;

// TODO: Consider delete this controller
public class UserSystemController {
    private final UserManager um;

    private UserSystemController(UserManager um) { this.um = um; }

    public void create(String phone_num, User user) { um.addUser(phone_num, user); }

    public boolean verify(String phone_num, String enter_password) {
        return um.verifyUser(phone_num,  enter_password);
    }
}
