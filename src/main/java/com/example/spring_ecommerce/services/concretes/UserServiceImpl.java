package com.example.spring_ecommerce.services.concretes;

import com.example.spring_ecommerce.entities.User;
import com.example.spring_ecommerce.repositories.abstracts.UserRepository;
import com.example.spring_ecommerce.services.abstracts.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAll() {
        return userRepository.getAll();
    }

    @Override
    public User getByID(int id) {
        return userRepository.getByID(id);
    }

    @Override
    public void add(User user) {
        if (user.getName().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be left blank!");
        }
        if (user.getMail().isEmpty() || isExist(user)) {
            throw new IllegalArgumentException("Please provide a unique mail address!");
        }
        userRepository.add(user);
    }

    @Override
    public void update(int id, User user) {
        if (user.getName().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be left blank!");
        }
        if (user.getMail().isEmpty()) {
            throw new IllegalArgumentException("Please provide a unique mail address!");
        }
        userRepository.update(id, user);
    }

    @Override
    public void delete(int id) {
        userRepository.delete(id);
    }

    public boolean isExist(User user) {
        List<User> existingUsers = userRepository.getAll();
        for (User userTemp : existingUsers) {
            if (userTemp.getMail().equals(user.getMail())) {
                return true;
            }
        }
        return false;
    }

}
