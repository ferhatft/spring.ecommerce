package com.example.spring_ecommerce.services.concretes;

import com.example.spring_ecommerce.core.types.UserRoleNotFoundException;
import com.example.spring_ecommerce.entities.*;
import com.example.spring_ecommerce.repositories.abstracts.UserRoleRepository;
import com.example.spring_ecommerce.services.abstracts.UserRoleService;
import com.example.spring_ecommerce.services.dtos.userrole.requests.AddUserRoleRequest;
import com.example.spring_ecommerce.services.dtos.userrole.requests.UpdateUserRoleRequest;
import com.example.spring_ecommerce.services.dtos.userrole.responses.GetUserRoleResponse;
import com.example.spring_ecommerce.services.dtos.userrole.responses.UserRoleListResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class UserRoleServiceImpl implements UserRoleService {

    private UserRoleRepository userRoleRepository;

    @Override
    public List<UserRoleListResponse> getAll() {
        List<UserRole> userRoles = userRoleRepository.findAll();
        List<UserRoleListResponse> response = new ArrayList<>();

        for (UserRole userRole: userRoles) {
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
        UserRole userRole = userRoleRepository.findById(id).orElse(null);

        assert userRole!= null;
        return Optional.of(new GetUserRoleResponse(
                userRole.getId(),
                userRole.getUser().getFirstName(),
                userRole.getUser().getLastName(),
                userRole.getRole().getName()));
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
    public void update(UpdateUserRoleRequest updateUserRoleRequest) {
        UserRole userRole = userRoleRepository.findById(updateUserRoleRequest.getId()).orElse(null);

        if (userRole == null) {
            throw new UserRoleNotFoundException(updateUserRoleRequest.getId());
        }

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
        userRoleRepository.deleteById(id);
    }
}