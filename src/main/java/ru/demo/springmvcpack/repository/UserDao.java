package ru.demo.springmvcpack.repository;

import ru.demo.springmvcpack.model.User;

import java.util.List;

public interface UserDao<T> {
    List<T> findAll();

    void save(User user);

    User delete(int id);

    void update(User user);

    User read(int id);
}
