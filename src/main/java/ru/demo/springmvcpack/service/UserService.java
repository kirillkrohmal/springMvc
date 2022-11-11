package ru.demo.springmvcpack.service;

import ru.demo.springmvcpack.model.User;

import java.util.List;

public interface UserService {

    List<User> findAll();

    void save(User user);

    User delete(int id);

    void update(User user);

    User read(int id);


}
