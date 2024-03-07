package com.example.spring_ecommerce.services.abstracts;

import com.example.spring_ecommerce.entities.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> getAll();

    Optional<User> getByID(int id);

    void add(User user);

    void update(User user);

    void delete(int id);

}
