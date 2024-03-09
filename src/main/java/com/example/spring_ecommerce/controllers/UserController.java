package com.example.spring_ecommerce.controllers;

import com.example.spring_ecommerce.entities.User;
import com.example.spring_ecommerce.services.abstracts.UserService;
import com.example.spring_ecommerce.services.dtos.user.requests.AddUserRequest;
import com.example.spring_ecommerce.services.dtos.user.requests.UpdateUserRequest;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
public class UserController {
    private UserService userService;

    @GetMapping
    public List<User> get() {
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<User> getByID(@PathVariable int id) {
        return userService.getByID(id);
    }

    @PostMapping
    public void add(@RequestBody AddUserRequest addUserRequest) {
        userService.add(addUserRequest);
    }

    @PutMapping
    public void update(@RequestBody UpdateUserRequest updateUserRequest) {
        userService.update(updateUserRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        userService.delete(id);
    }

}
