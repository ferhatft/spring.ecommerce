package com.example.spring_ecommerce.services.abstracts;

import com.example.spring_ecommerce.services.dtos.user.requests.AddUserRequest;
import com.example.spring_ecommerce.services.dtos.user.requests.UpdateUserRequest;
import com.example.spring_ecommerce.services.dtos.user.responses.GetUserResponse;
import com.example.spring_ecommerce.services.dtos.user.responses.UserListResponse;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<UserListResponse> getAll();

    Optional<GetUserResponse> getByID(int id);

    void add(AddUserRequest addUserRequest);

    void update(UpdateUserRequest updateUserRequest);

    void delete(int id);

    List<UserListResponse> findUsersInIstanbul();

    List<UserListResponse> findAdminUsers();

    List<UserListResponse> findUsersWithOrdersForAsusProducts();

}
