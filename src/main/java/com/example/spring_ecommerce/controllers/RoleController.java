package com.example.spring_ecommerce.controllers;

import com.example.spring_ecommerce.entities.Role;
import com.example.spring_ecommerce.services.abstracts.RoleService;
import com.example.spring_ecommerce.services.dtos.role.requests.AddRoleRequest;
import com.example.spring_ecommerce.services.dtos.role.requests.UpdateRoleRequest;
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
    public List<Role> get() {
        return roleService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Role> getByID(@PathVariable int id) {
        return roleService.getByID(id);
    }

    @PostMapping
    public void add(@RequestBody AddRoleRequest addRoleRequest) {
        roleService.add(addRoleRequest);
    }

    @PutMapping
    public void update(@RequestBody UpdateRoleRequest updateRoleRequest) {
        roleService.update(updateRoleRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        roleService.delete(id);
    }
}

