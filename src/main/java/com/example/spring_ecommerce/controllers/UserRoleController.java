package com.example.spring_ecommerce.controllers;

import com.example.spring_ecommerce.entities.UserRole;
import com.example.spring_ecommerce.services.abstracts.UserRoleService;
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
    public List<UserRole> get() {
        return userRoleService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<UserRole> getByID(@PathVariable int id) {
        return userRoleService.getByID(id);
    }

    @PostMapping
    public void add(@RequestBody UserRole userRole) {
        userRoleService.add(userRole);
    }

    @PutMapping
    public void update(@RequestBody UserRole userRole) {
        userRoleService.update(userRole);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        userRoleService.delete(id);
    }
}
