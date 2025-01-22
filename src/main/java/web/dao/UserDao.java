package web.dao;

import web.model.User;
import java.util.List;

public interface UserDao {

    List<User> listUsers();

    User getUser(int id);
    void editUser(int id, User user);
    void deleteUser(int id);
    void addUser(User user);
}
