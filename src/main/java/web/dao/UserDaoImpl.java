package web.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;
import web.model.User;
@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager; // Инъекция EntityManager

    @Override
    @Transactional
    public void addUser (User user) {
        entityManager.persist(user);
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> listUsers() {
        return entityManager.createQuery("FROM User", User.class).getResultList();
    }

    @Override
    @Transactional(readOnly = true)
    public User getUser (int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    @Transactional
    public void editUser (int id, User user) {
        User edit = entityManager.find(User.class, id); // Найти пользователя по ID
        if (edit != null) { // Проверяем, существует ли пользователь
            // Обновляем поля пользователя
            edit.setName(user.getName());
            edit.setSurname(user.getSurname());
            edit.setEmail(user.getEmail());
            edit.setAge(user.getAge());

            // Сохраняем изменения
            entityManager.merge(edit); // Обеспечиваем сохранение изменений
        }
    }

    @Override
    @Transactional
    public void deleteUser (int id) {
        User user = entityManager.find(User.class, id);
        if (user != null) {
            entityManager.remove(user);
        }
    }
}
