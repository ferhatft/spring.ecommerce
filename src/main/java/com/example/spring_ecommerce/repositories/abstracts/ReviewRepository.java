package com.example.spring_ecommerce.repositories.abstracts;
import com.example.spring_ecommerce.entities.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Integer> {
}