package com.example.spring_ecommerce.repositories.abstracts;

import com.example.spring_ecommerce.entities.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleRepository extends JpaRepository<UserRole, Integer> {
}