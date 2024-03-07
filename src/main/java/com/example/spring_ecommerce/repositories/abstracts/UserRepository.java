package com.example.spring_ecommerce.repositories.abstracts;

import com.example.spring_ecommerce.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}