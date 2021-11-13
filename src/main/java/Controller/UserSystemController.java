package Controller;

import Entity.User;
import UseCases.UserManager;

// Since we have not decided how to use this class, the class and its methods are never used
public class UserSystemController {
    private UserManager um;

    private UserSystemController(UserManager um) { this.um = um; }

    public void create(String phone_num, User user) { um.createUser(phone_num, user); }

    public boolean verify(String phone_num, String enter_password) {
        return um.verifyUser(phone_num,  enter_password);
    }
}
