package ru.demo.springmvc.repository;

import ru.demo.springmvc.model.User;

import java.util.List;

public interface UserDao<T> {
    List<T> findAll();

    void save(User user);

    User delete(int id);

    void update(User user);

    User read(int id);
}
