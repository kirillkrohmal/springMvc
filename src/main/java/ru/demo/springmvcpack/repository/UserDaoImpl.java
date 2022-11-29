package ru.demo.springmvcpack.repository;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.demo.springmvcpack.model.User;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    private final SessionFactory sessionFactory;

    @Autowired
    public UserDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public List findAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from User").getResultList();
    }

    @Override
    @Transactional(readOnly = true)
    public void save(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.save(user);
    }

    @Override
    @Transactional
    public User delete(int id) {
        User user = read(id);
        Session session = sessionFactory.getCurrentSession();

        if (null == user) {
            System.out.println("You could paste user id");
        }
        session.remove(session.get(User.class, id));

        return user;
    }


    @Override
    @Transactional
    public void update(User user, int id) {
        Session session = sessionFactory.getCurrentSession();

        User userToBeUpdate = session.get(User.class, id);

        userToBeUpdate.setName(user.getName());
        userToBeUpdate.setAddress(user.getAddress());
        userToBeUpdate.setEmail(user.getEmail());

    }

    @Override
    @Transactional(readOnly = true)
    public User read(int id) {
        Session session = sessionFactory.getCurrentSession();

        return session.get(User.class, id);
    }
}
