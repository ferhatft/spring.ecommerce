package com.example.spring_ecommerce.controllers;

import com.example.spring_ecommerce.entities.User;
import com.example.spring_ecommerce.services.abstracts.UserService;
import com.example.spring_ecommerce.services.dtos.user.requests.AddUserRequest;
import com.example.spring_ecommerce.services.dtos.user.requests.UpdateUserRequest;
import com.example.spring_ecommerce.services.dtos.user.responses.GetUserResponse;
import com.example.spring_ecommerce.services.dtos.user.responses.UserListResponse;
import jakarta.validation.Valid;
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
    public List<UserListResponse> get() {
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<GetUserResponse> getByID(@PathVariable int id) {
        return userService.getByID(id);
    }

    @PostMapping
    public void add(@RequestBody @Valid AddUserRequest addUserRequest) {
        userService.add(addUserRequest);
    }

    @PutMapping
    public void update(@RequestBody @Valid UpdateUserRequest updateUserRequest) {
        userService.update(updateUserRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        userService.delete(id);
    }

    @GetMapping("UsersInIstanbul")
    public List<UserListResponse> findUsersInIstanbul(){
        return userService.findUsersInIstanbul();
    }
    @GetMapping("AdminUsers")
    public List<UserListResponse> findAdminUsers(){
        return userService.findAdminUsers();
    }

    @GetMapping("UsersWithOrdersForAsusProducts")
    public List<UserListResponse> findUsersWithOrdersForAsusProducts(){
        return userService.findUsersWithOrdersForAsusProducts();
    }

}
