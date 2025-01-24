package web.service;

import web.model.User;
import java.util.List;

public interface UserService1 {

    List<User> listUsers();
    void addUser (User user);
    void editUser (int id, User user);
    void deleteUser (int id);
    User getUser (int id);
}