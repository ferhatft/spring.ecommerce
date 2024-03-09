package com.example.spring_ecommerce.services.concretes;

import com.example.spring_ecommerce.entities.Role;
import com.example.spring_ecommerce.repositories.abstracts.RoleRepository;
import com.example.spring_ecommerce.services.abstracts.RoleService;
import com.example.spring_ecommerce.services.dtos.role.requests.AddRoleRequest;
import com.example.spring_ecommerce.services.dtos.role.requests.UpdateRoleRequest;
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
    public void add(AddRoleRequest addRoleRequest) {
        Role role = new Role();
        role.setName(addRoleRequest.getName());
        roleRepository.save(role);
    }

    @Override
    public void update(UpdateRoleRequest updateRoleRequest) {
        Role role = roleRepository.findById(updateRoleRequest.getId()).orElse(null);

        if (role == null) {
            // TODO Handle role not found (e.g., log a warning or throw a custom exception later)
            return;
        }

        role.setName(updateRoleRequest.getName());
        roleRepository.save(role);
    }

    @Override
    public void delete(int id) {
        roleRepository.deleteById(id);
    }
}
