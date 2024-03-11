package com.example.spring_ecommerce.repositories.abstracts;
import com.example.spring_ecommerce.entities.Review;
import com.example.spring_ecommerce.services.dtos.review.responses.ReviewCountResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Integer> {
    @Query(value = "Select new com.example.spring_ecommerce.services.dtos.review.responses.ReviewCountResponse " +
            "(r.user.id, COUNT(r.user.id) AS reviewCount)" +
            " FROM Review r" +
            " GROUP BY r.user.id"+
            " HAVING COUNT(r.user.id) <= 1"
    )
    List<ReviewCountResponse> findUsersByReviewCountLessThanTwo();
}