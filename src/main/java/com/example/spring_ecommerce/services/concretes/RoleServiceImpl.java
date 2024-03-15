package com.example.spring_ecommerce.services.concretes;

import com.example.spring_ecommerce.core.types.RoleNotFoundException;
import com.example.spring_ecommerce.entities.Role;
import com.example.spring_ecommerce.repositories.abstracts.RoleRepository;
import com.example.spring_ecommerce.services.abstracts.RoleService;
import com.example.spring_ecommerce.services.dtos.role.requests.AddRoleRequest;
import com.example.spring_ecommerce.services.dtos.role.requests.UpdateRoleRequest;
import com.example.spring_ecommerce.services.dtos.role.responses.GetRoleResponse;
import com.example.spring_ecommerce.services.dtos.role.responses.RoleListResponse;
import com.example.spring_ecommerce.services.mappers.RoleMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    @Override
    public List<RoleListResponse> getAll() {
        List<Role> roles = roleRepository.findAll();
        List<RoleListResponse> response = new ArrayList<>();

        for (Role role : roles) {
            RoleListResponse dto = new RoleListResponse(
                    role.getId(),
                    role.getName());
            response.add(dto);
        }

        return response;
    }

    @Override
    public Optional<GetRoleResponse> getByID(int id) {
        Role role = findRoleById(id);
        GetRoleResponse response = RoleMapper.INSTANCE.getRoleResponseFromRole(role);
        return Optional.of(response);
    }

    @Override
    public void add(AddRoleRequest addRoleRequest) {
        Role role = RoleMapper.INSTANCE.roleFromAddRequest(addRoleRequest);
        roleRepository.save(role);
    }

    @Override
    public void update(UpdateRoleRequest updateRoleRequest) {
        Role role = findRoleById(updateRoleRequest.getId());
        role.setName(updateRoleRequest.getName());
        roleRepository.save(role);
    }

    @Override
    public void delete(int id) {
        if (!roleRepository.existsById(id)) {
            throw new RoleNotFoundException(id);
        }
        roleRepository.deleteById(id);
    }

    private Role findRoleById(int id) {
        return roleRepository.findById(id)
                .orElseThrow(() -> new RoleNotFoundException(id));
    }
}


