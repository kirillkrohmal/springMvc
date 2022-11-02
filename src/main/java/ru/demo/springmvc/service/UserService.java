package ru.demo.springmvc.service;

import ru.demo.springmvc.model.User;

import java.util.List;

public interface UserService<T> {

    List<T> findAll();

    void save(User user);

    User delete(int id);

    void update(User user);

    User read(int id);


}
