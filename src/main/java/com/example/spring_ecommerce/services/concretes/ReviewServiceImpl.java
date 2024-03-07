package com.example.spring_ecommerce.services.concretes;

import com.example.spring_ecommerce.entities.Review;
import com.example.spring_ecommerce.repositories.abstracts.ReviewRepository;
import com.example.spring_ecommerce.services.abstracts.ReviewService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ReviewServiceImpl implements ReviewService {

    private ReviewRepository reviewRepository;

    @Override
    public List<Review> getAll() {
        return reviewRepository.findAll();
    }

    @Override
    public Optional<Review> getByID(int id) {
        return reviewRepository.findById(id);
    }

    @Override
    public void add(Review review) {
        if (review.getDetail().isEmpty()) {
            throw new IllegalArgumentException("Review text cannot be left blank!");
        }
        reviewRepository.save(review);
    }

    @Override
    public void update(Review review) {
        if (review.getDetail().isEmpty()) {
            throw new IllegalArgumentException("Review text cannot be left blank!");
        }
        reviewRepository.save(review);
    }

    @Override
    public void delete(int id) {
        reviewRepository.deleteById(id);
    }
}
