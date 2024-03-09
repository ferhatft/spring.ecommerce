package com.example.spring_ecommerce.services.abstracts;

import com.example.spring_ecommerce.entities.Review;
import com.example.spring_ecommerce.services.dtos.review.requests.AddReviewRequest;
import com.example.spring_ecommerce.services.dtos.review.requests.UpdateReviewRequest;

import java.util.List;
import java.util.Optional;

public interface ReviewService {

    List<Review> getAll();

    Optional<Review> getByID(int id);

    void add(AddReviewRequest addReviewRequest);

    void update(UpdateReviewRequest updateReviewRequest);

    void delete(int id);

}
