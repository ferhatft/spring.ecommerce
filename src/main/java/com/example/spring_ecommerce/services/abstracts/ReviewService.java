package com.example.spring_ecommerce.services.abstracts;

import com.example.spring_ecommerce.entities.Review;

import java.util.List;
import java.util.Optional;

public interface ReviewService {

    List<Review> getAll();

    Optional<Review> getByID(int id);

    void add(Review review);

    void update(Review review);

    void delete(int id);

}
