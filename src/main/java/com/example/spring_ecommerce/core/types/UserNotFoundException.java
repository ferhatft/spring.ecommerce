package com.example.spring_ecommerce.core.types;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(int userId) {
        super("User with ID " + userId + " not found");
    }
}
