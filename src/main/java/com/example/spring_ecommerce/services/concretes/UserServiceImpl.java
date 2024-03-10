package com.example.spring_ecommerce.services.concretes;

import com.example.spring_ecommerce.entities.User;
import com.example.spring_ecommerce.repositories.abstracts.UserRepository;
import com.example.spring_ecommerce.services.abstracts.UserService;
import com.example.spring_ecommerce.services.dtos.user.requests.AddUserRequest;
import com.example.spring_ecommerce.services.dtos.user.requests.UpdateUserRequest;
import com.example.spring_ecommerce.services.dtos.user.responses.GetUserResponse;
import com.example.spring_ecommerce.services.dtos.user.responses.UserListResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Override
    public List<UserListResponse> getAll() {
        List<User> users = userRepository.findAll();
        List<UserListResponse> response = new ArrayList<>();

        for (User user: users) {
            UserListResponse dto = new UserListResponse(
                    user.getId(),
                    user.getFirstName(),
                    user.getLastName(),
                    user.getEmail());
            response.add(dto);
        }

        return response;
    }

    @Override
    public Optional<GetUserResponse> getByID(int id) {
        User user = userRepository.findById(id).orElse(null);

        assert user != null;
        return Optional.of(new GetUserResponse(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail()));
    }

    @Override
    public void add(AddUserRequest addUserRequest) {
        User user = new User();
        user.setFirstName(addUserRequest.getFirstName());
        user.setLastName(addUserRequest.getLastName());
        user.setEmail(addUserRequest.getEmail());
        userRepository.save(user);
    }

    @Override
    public void update(UpdateUserRequest updateUserRequest) {
        User user = userRepository.findById(updateUserRequest.getId()).orElse(null);

        if (user == null) {
            // TODO Handle user not found (e.g., log a warning or throw a custom exception later)
            return;
        }

        user.setFirstName(updateUserRequest.getFirstName());
        user.setLastName(updateUserRequest.getLastName());
        user.setEmail(updateUserRequest.getEmail());

        userRepository.save(user);
    }


    @Override
    public void delete(int id) {
        userRepository.deleteById(id);
    }
}
