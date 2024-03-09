package com.example.spring_ecommerce.services.concretes;

import com.example.spring_ecommerce.entities.*;
import com.example.spring_ecommerce.repositories.abstracts.ReviewRepository;
import com.example.spring_ecommerce.services.abstracts.ReviewService;
import com.example.spring_ecommerce.services.dtos.review.requests.AddReviewRequest;
import com.example.spring_ecommerce.services.dtos.review.requests.UpdateReviewRequest;
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
    public void add(AddReviewRequest addReviewRequest) {
        Product product = new Product();
        product.setId(addReviewRequest.getProductId());
        User user = new User();
        user.setId(addReviewRequest.getUserId());
        Review review = new Review();
        review.setDetail(addReviewRequest.getDetail());
        review.setProduct(product);
        review.setUser(user);
        reviewRepository.save(review);
    }

    @Override
    public void update(UpdateReviewRequest updateReviewRequest) {
        Review review = reviewRepository.findById(updateReviewRequest.getId()).orElse(null);

        if (review == null) {
            // TODO Handle review not found (e.g., log a warning or throw a custom exception later)
            return;
        }

        Product product = new Product();
        product.setId(updateReviewRequest.getProductId());
        User user = new User();
        user.setId(updateReviewRequest.getUserId());
        review.setDetail(updateReviewRequest.getDetail());
        review.setProduct(product);
        review.setUser(user);
        reviewRepository.save(review);
    }

    @Override
    public void delete(int id) {
        reviewRepository.deleteById(id);
    }
}
