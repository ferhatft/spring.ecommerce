package com.example.spring_ecommerce.services.abstracts;

import com.example.spring_ecommerce.entities.Role;
import com.example.spring_ecommerce.services.dtos.role.requests.AddRoleRequest;
import com.example.spring_ecommerce.services.dtos.role.requests.UpdateRoleRequest;
import com.example.spring_ecommerce.services.dtos.role.responses.GetRoleResponse;
import com.example.spring_ecommerce.services.dtos.role.responses.RoleListResponse;

import java.util.List;
import java.util.Optional;

public interface RoleService {

    List<RoleListResponse> getAll();

    Optional<GetRoleResponse> getByID(int id);

    void add(AddRoleRequest addRoleRequest);

    void update(UpdateRoleRequest updateRoleRequest);

    void delete(int id);

}
