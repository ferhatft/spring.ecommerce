package com.example.spring_ecommerce.services.concretes;

import com.example.spring_ecommerce.core.types.ReviewNotFoundException;
import com.example.spring_ecommerce.entities.*;
import com.example.spring_ecommerce.repositories.abstracts.ReviewRepository;
import com.example.spring_ecommerce.services.abstracts.ReviewService;
import com.example.spring_ecommerce.services.dtos.review.requests.AddReviewRequest;
import com.example.spring_ecommerce.services.dtos.review.requests.UpdateReviewRequest;
import com.example.spring_ecommerce.services.dtos.review.responses.GetReviewResponse;
import com.example.spring_ecommerce.services.dtos.review.responses.ReviewCountResponse;
import com.example.spring_ecommerce.services.dtos.review.responses.ReviewListResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ReviewServiceImpl implements ReviewService {

    private ReviewRepository reviewRepository;

    @Override
    public List<ReviewListResponse> getAll() {
        List<Review> reviews = reviewRepository.findAll();
        List<ReviewListResponse> response = new ArrayList<>();

        for (Review review: reviews) {
            ReviewListResponse dto = new ReviewListResponse(
                    review.getId(),
                    review.getDetail(),
                    review.getProduct().getName(),
                    review.getUser().getFirstName(),
                    review.getUser().getLastName());
            response.add(dto);
        }

        return response;
    }

    @Override
    public Optional<GetReviewResponse> getByID(int id) {
        Review review = reviewRepository.findById(id).orElse(null);

        assert review != null;
        return Optional.of(new GetReviewResponse(
                review.getId(),
                review.getDetail(),
                review.getProduct().getName(),
                review.getUser().getFirstName(),
                review.getUser().getLastName()));
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
            throw new ReviewNotFoundException(updateReviewRequest.getId());
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

    @Override
    public List<ReviewCountResponse> findUsersByReviewCountLessThanTwo() {
        return reviewRepository.findUsersByReviewCountLessThanTwo();
    }
}
