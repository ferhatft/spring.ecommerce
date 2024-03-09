package com.example.spring_ecommerce.services.concretes;

import com.example.spring_ecommerce.entities.*;
import com.example.spring_ecommerce.repositories.abstracts.UserRoleRepository;
import com.example.spring_ecommerce.services.abstracts.UserRoleService;
import com.example.spring_ecommerce.services.dtos.userrole.requests.AddUserRoleRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class UserRoleServiceImpl implements UserRoleService {

    private UserRoleRepository userRoleRepository;

    @Override
    public List<UserRole> getAll() {
        return userRoleRepository.findAll();
    }

    @Override
    public Optional<UserRole> getByID(int id) {
        return userRoleRepository.findById(id);
    }

    @Override
    public void add(AddUserRoleRequest addUserRoleRequest) {
        User user = new User();
        user.setId(addUserRoleRequest.getUserId());
        Role role = new Role();
        role.setId(addUserRoleRequest.getRoleId());
        UserRole userRole= new UserRole();
        userRole.setUser(user);
        userRole.setRole(role);
        userRoleRepository.save(userRole);
    }

    @Override
    public void update(UserRole userRole) {
        userRoleRepository.save(userRole);
    }

    @Override
    public void delete(int id) {
        userRoleRepository.deleteById(id);
    }
}