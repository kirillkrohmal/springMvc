package ru.demo.springmvcpack.repository;

import ru.demo.springmvcpack.model.User;

import java.util.List;

public interface UserDao {
    List<User> findAll();

    void save(User user);

    User delete(int id);

    void update(User user, int id);

    User read(int id);
}
