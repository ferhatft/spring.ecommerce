package com.example.spring_ecommerce.services.concretes;

import com.example.spring_ecommerce.entities.User;
import com.example.spring_ecommerce.repositories.abstracts.UserRepository;
import com.example.spring_ecommerce.services.abstracts.UserService;
import com.example.spring_ecommerce.services.dtos.user.requests.AddUserRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getByID(int id) {
        return userRepository.findById(id);
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
    public void update(User user) {
        if (user.getFirstName().isEmpty() || user.getLastName().isEmpty() || user.getEmail().isEmpty()) {
            throw new IllegalArgumentException("Name, surname and email cannot be left blank!");
        }
        userRepository.save(user);
    }

    @Override
    public void delete(int id) {
        userRepository.deleteById(id);
    }
}
