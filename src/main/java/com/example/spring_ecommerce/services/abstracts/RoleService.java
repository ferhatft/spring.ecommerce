package com.example.spring_ecommerce.services.abstracts;

import com.example.spring_ecommerce.entities.Role;

import java.util.List;
import java.util.Optional;

public interface RoleService {

    List<Role> getAll();

    Optional<Role> getByID(int id);

    void add(Role role);

    void update(Role role);

    void delete(int id);

}
