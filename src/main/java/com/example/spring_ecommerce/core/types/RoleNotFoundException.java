package com.example.spring_ecommerce.core.types;

public class RoleNotFoundException extends RuntimeException {
    public RoleNotFoundException(int roleId) {
        super("Role with ID " + roleId + " not found");
    }
}
