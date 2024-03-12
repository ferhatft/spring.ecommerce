package com.example.spring_ecommerce.core.types;

public class UserRoleNotFoundException extends RuntimeException {
    public UserRoleNotFoundException(int userRoleId) {
        super("UserRole with ID " + userRoleId + " not found");
    }
}
