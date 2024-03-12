package com.example.spring_ecommerce.services.concretes;

import com.example.spring_ecommerce.core.types.RoleNotFoundException;
import com.example.spring_ecommerce.entities.Role;
import com.example.spring_ecommerce.repositories.abstracts.RoleRepository;
import com.example.spring_ecommerce.services.abstracts.RoleService;
import com.example.spring_ecommerce.services.dtos.role.requests.AddRoleRequest;
import com.example.spring_ecommerce.services.dtos.role.requests.UpdateRoleRequest;
import com.example.spring_ecommerce.services.dtos.role.responses.GetRoleResponse;
import com.example.spring_ecommerce.services.dtos.role.responses.RoleListResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class RoleServiceImpl implements RoleService {

    private RoleRepository roleRepository;

    @Override
    public List<RoleListResponse> getAll() {
        List<Role> roles = roleRepository.findAll();
        List<RoleListResponse> response = new ArrayList<>();

        for (Role role: roles) {
            RoleListResponse dto = new RoleListResponse(
                    role.getId(),
                    role.getName());
            response.add(dto);
        }

        return response;
    }

    @Override
    public Optional<GetRoleResponse> getByID(int id) {
        Role role = roleRepository.findById(id).orElse(null);

        assert role != null;
        return Optional.of(new GetRoleResponse(
                role.getId(),
                role.getName()));
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
            throw new RoleNotFoundException(updateRoleRequest.getId());
        }

        role.setName(updateRoleRequest.getName());
        roleRepository.save(role);
    }

    @Override
    public void delete(int id) {
        roleRepository.deleteById(id);
    }
}


