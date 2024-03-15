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
import com.example.spring_ecommerce.services.mappers.ReviewMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;

    @Override
    public List<ReviewListResponse> getAll() {
        List<Review> reviews = reviewRepository.findAll();
        List<ReviewListResponse> response = new ArrayList<>();

        for (Review review : reviews) {
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
        Review review = findReviewById(id);
        GetReviewResponse response = ReviewMapper.INSTANCE.getReviewResponseFromReview(review);
        return Optional.of(response);
    }

    @Override
    public void add(AddReviewRequest addReviewRequest) {
        Review review = ReviewMapper.INSTANCE.reviewFromAddRequest(addReviewRequest);
        reviewRepository.save(review);
    }

    @Override
    public void update(UpdateReviewRequest updateReviewRequest) {
        Review review = findReviewById(updateReviewRequest.getId());
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
        if (!reviewRepository.existsById(id)) {
            throw new ReviewNotFoundException(id);
        }
        reviewRepository.deleteById(id);
    }

    @Override
    public List<ReviewCountResponse> findUsersByReviewCountLessThanTwo() {
        return reviewRepository.findUsersByReviewCountLessThanTwo();
    }

    private Review findReviewById(int id) {
        return reviewRepository.findById(id)
                .orElseThrow(() -> new ReviewNotFoundException(id));
    }
}
