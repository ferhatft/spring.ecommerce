package com.example.spring_ecommerce.services.abstracts;

import com.example.spring_ecommerce.entities.UserRole;
import com.example.spring_ecommerce.services.dtos.userrole.requests.AddUserRoleRequest;

import java.util.List;
import java.util.Optional;

public interface UserRoleService {

    List<UserRole> getAll();

    Optional<UserRole> getByID(int id);

    void add(AddUserRoleRequest addUserRoleRequest);

    void update(UserRole userRole);

    void delete(int id);

}
