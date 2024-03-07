package com.example.spring_ecommerce.services.concretes;

import com.example.spring_ecommerce.entities.UserRole;
import com.example.spring_ecommerce.repositories.abstracts.UserRoleRepository;
import com.example.spring_ecommerce.services.abstracts.UserRoleService;
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
    public void add(UserRole userRole) {
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