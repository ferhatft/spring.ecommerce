package com.example.spring_ecommerce.controllers;

import com.example.spring_ecommerce.entities.UserRole;
import com.example.spring_ecommerce.services.abstracts.UserRoleService;
import com.example.spring_ecommerce.services.dtos.userrole.requests.AddUserRoleRequest;
import com.example.spring_ecommerce.services.dtos.userrole.requests.UpdateUserRoleRequest;
import com.example.spring_ecommerce.services.dtos.userrole.responses.GetUserRoleResponse;
import com.example.spring_ecommerce.services.dtos.userrole.responses.UserRoleListResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/api/userRoles")
@AllArgsConstructor
public class UserRoleController {
    private UserRoleService userRoleService;

    @GetMapping
    public List<UserRoleListResponse> get() {
        return userRoleService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<GetUserRoleResponse> getByID(@PathVariable int id) {
        return userRoleService.getByID(id);
    }

    @PostMapping
    public void add(@RequestBody AddUserRoleRequest addUserRoleRequest) {
        userRoleService.add(addUserRoleRequest);
    }

    @PutMapping
    public void update(@RequestBody UpdateUserRoleRequest updateUserRoleRequest) {
        userRoleService.update(updateUserRoleRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        userRoleService.delete(id);
    }
}

