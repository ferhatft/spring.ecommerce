package com.example.spring_ecommerce.services.abstracts;

import com.example.spring_ecommerce.entities.UserRole;
import com.example.spring_ecommerce.services.dtos.userrole.requests.AddUserRoleRequest;
import com.example.spring_ecommerce.services.dtos.userrole.requests.UpdateUserRoleRequest;
import com.example.spring_ecommerce.services.dtos.userrole.responses.GetUserRoleResponse;
import com.example.spring_ecommerce.services.dtos.userrole.responses.UserRoleListResponse;

import java.util.List;
import java.util.Optional;

public interface UserRoleService {

    List<UserRoleListResponse> getAll();

    Optional<GetUserRoleResponse> getByID(int id);

    void add(AddUserRoleRequest addUserRoleRequest);

    void update(UpdateUserRoleRequest updateUserRoleRequest);

    void delete(int id);

}
