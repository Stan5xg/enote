package com.epam.enote.services;

import com.epam.enote.entities.User;

import java.util.List;

public interface UserService {

    void create(User user);

    void update(User user);

    void delete(User user);

    void deleteById(int id);

    User getById(int id);

    User getByName(int id);

    List<User> getAll();
}
