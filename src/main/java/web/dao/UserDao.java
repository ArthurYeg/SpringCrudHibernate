package web.dao;

import web.model.User;
import java.util.List;

public interface UserDao {

    List<User> listUsers();
    
    User getUser(Long id);
    void editUser(Long id, User user);
    void deleteUser(Long id);
    void addUser(User user);
}
