package com.example.spring_ecommerce.controllers;

import com.example.spring_ecommerce.entities.Role;
import com.example.spring_ecommerce.services.abstracts.RoleService;
import com.example.spring_ecommerce.services.dtos.role.requests.AddRoleRequest;
import com.example.spring_ecommerce.services.dtos.role.requests.UpdateRoleRequest;
import com.example.spring_ecommerce.services.dtos.role.responses.GetRoleResponse;
import com.example.spring_ecommerce.services.dtos.role.responses.RoleListResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/api/roles")
@AllArgsConstructor
public class RoleController {
    private RoleService roleService;

    @GetMapping
    public List<RoleListResponse> get() {
        return roleService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<GetRoleResponse> getByID(@PathVariable int id) {
        return roleService.getByID(id);
    }

    @PostMapping
    public void add(@RequestBody @Valid AddRoleRequest addRoleRequest) {
        roleService.add(addRoleRequest);
    }

    @PutMapping
    public void update(@RequestBody @Valid UpdateRoleRequest updateRoleRequest) {
        roleService.update(updateRoleRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        roleService.delete(id);
    }
}

