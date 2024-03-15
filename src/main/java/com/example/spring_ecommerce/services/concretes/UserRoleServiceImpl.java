package com.example.spring_ecommerce.services.concretes;

import com.example.spring_ecommerce.core.types.UserRoleNotFoundException;
import com.example.spring_ecommerce.entities.*;
import com.example.spring_ecommerce.repositories.abstracts.UserRoleRepository;
import com.example.spring_ecommerce.services.abstracts.UserRoleService;
import com.example.spring_ecommerce.services.dtos.userrole.requests.AddUserRoleRequest;
import com.example.spring_ecommerce.services.dtos.userrole.requests.UpdateUserRoleRequest;
import com.example.spring_ecommerce.services.dtos.userrole.responses.GetUserRoleResponse;
import com.example.spring_ecommerce.services.dtos.userrole.responses.UserRoleListResponse;
import com.example.spring_ecommerce.services.mappers.UserRoleMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class UserRoleServiceImpl implements UserRoleService {

    private final UserRoleRepository userRoleRepository;

    @Override
    public List<UserRoleListResponse> getAll() {
        List<UserRole> userRoles = userRoleRepository.findAll();
        List<UserRoleListResponse> response = new ArrayList<>();

        for (UserRole userRole : userRoles) {
            UserRoleListResponse dto = new UserRoleListResponse(
                    userRole.getId(),
                    userRole.getUser().getFirstName(),
                    userRole.getUser().getLastName(),
                    userRole.getRole().getName());
            response.add(dto);
        }

        return response;
    }

    @Override
    public Optional<GetUserRoleResponse> getByID(int id) {
        UserRole userRole = findUserRoleById(id);
        GetUserRoleResponse response = UserRoleMapper.INSTANCE.getUserRoleResponseFromUserRole(userRole);
        return Optional.of(response);
    }

    @Override
    public void add(AddUserRoleRequest addUserRoleRequest) {
        UserRole userRole = UserRoleMapper.INSTANCE.userRoleFromAddRequest(addUserRoleRequest);
        userRoleRepository.save(userRole);
    }

    @Override
    public void update(UpdateUserRoleRequest updateUserRoleRequest) {
        UserRole userRole = findUserRoleById(updateUserRoleRequest.getId());
        User user = new User();
        user.setId(updateUserRoleRequest.getUserId());
        Role role = new Role();
        role.setId(updateUserRoleRequest.getRoleId());
        userRole.setUser(user);
        userRole.setRole(role);
        userRoleRepository.save(userRole);
    }

    @Override
    public void delete(int id) {
        if (!userRoleRepository.existsById(id)) {
            throw new UserRoleNotFoundException(id);
        }
        userRoleRepository.deleteById(id);
    }

    private UserRole findUserRoleById(int id) {
        return userRoleRepository.findById(id)
                .orElseThrow(() -> new UserRoleNotFoundException(id));
    }
}