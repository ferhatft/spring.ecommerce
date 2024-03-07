package com.example.spring_ecommerce.services.concretes;

import com.example.spring_ecommerce.entities.Role;
import com.example.spring_ecommerce.repositories.abstracts.RoleRepository;
import com.example.spring_ecommerce.services.abstracts.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class RoleServiceImpl implements RoleService {

    private RoleRepository roleRepository;

    @Override
    public List<Role> getAll() {
        return roleRepository.findAll();
    }

    @Override
    public Optional<Role> getByID(int id) {
        return roleRepository.findById(id);
    }

    @Override
    public void add(Role role) {
        if (role.getName().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be left blank!");
        }
        roleRepository.save(role);
    }

    @Override
    public void update(Role role) {
        if (role.getName().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be left blank!");
        }
        roleRepository.save(role);
    }

    @Override
    public void delete(int id) {
        roleRepository.deleteById(id);
    }
}
