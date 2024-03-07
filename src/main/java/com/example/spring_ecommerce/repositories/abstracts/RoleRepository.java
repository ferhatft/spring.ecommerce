package com.example.spring_ecommerce.repositories.abstracts;

import com.example.spring_ecommerce.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
}