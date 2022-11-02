package ru.demo.springmvc.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.demo.springmvc.model.User;
import ru.demo.springmvc.repository.UserDao;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl<T> implements UserService{

    @Autowired
    private UserDao userDao;

    @Override
    public List findAll() {
        return userDao.findAll();
    }

    @Override
    public void save(User user) {
        userDao.save(user);
    }

    @Override
    public User delete(int id) {
        return userDao.delete(id);
    }

    @Override
    public void update(User user) {
        userDao.update(user);
    }

    @Override
    public User read(int id) {
        return null;
    }
}
