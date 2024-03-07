package com.example.spring_ecommerce.services.abstracts;

import com.example.spring_ecommerce.entities.UserRole;

import java.util.List;
import java.util.Optional;

public interface UserRoleService {

    List<UserRole> getAll();

    Optional<UserRole> getByID(int id);

    void add(UserRole userRole);

    void update(UserRole userRole);

    void delete(int id);

}
