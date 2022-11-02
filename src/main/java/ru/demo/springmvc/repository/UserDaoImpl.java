package ru.demo.springmvc.repository;


import org.springframework.stereotype.Repository;
import ru.demo.springmvc.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<User> findAll() {
        return entityManager.createQuery("from newUsers").getResultList();
    }

    @Override
    public void save(User user) {
        entityManager.persist(user);
        entityManager.flush();
    }

    @Override
    public User delete(int id) {
        User user = read(id);

        if (null == user) {
            System.out.println("You could paste user id");
        }
        entityManager.remove(id);
        entityManager.flush();

        return user;
    }

    @Override
    public void update(User user) {
        entityManager.merge(user);
        entityManager.flush();
    }

    @Override
    public User read(int id) {
        return entityManager.find(User.class, id);
    }
}
