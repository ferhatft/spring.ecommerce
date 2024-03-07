package com.example.spring_ecommerce.repositories.abstracts;

import com.example.spring_ecommerce.entities.Likes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikesRepository extends JpaRepository<Likes, Integer> {
}