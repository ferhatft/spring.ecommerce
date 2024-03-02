package com.example.spring_ecommerce.services.abstracts;

import com.example.spring_ecommerce.entities.User;

import java.util.List;

public interface UserService {
    List<User> getAll();

    User getByID(int id);

    void add(User user);

    void update(int id, User user);

    void delete(int id);

}
