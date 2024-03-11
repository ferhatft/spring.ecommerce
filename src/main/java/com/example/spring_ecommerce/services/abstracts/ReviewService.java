package com.example.spring_ecommerce.services.abstracts;

import com.example.spring_ecommerce.services.dtos.review.requests.AddReviewRequest;
import com.example.spring_ecommerce.services.dtos.review.requests.UpdateReviewRequest;
import com.example.spring_ecommerce.services.dtos.review.responses.GetReviewResponse;
import com.example.spring_ecommerce.services.dtos.review.responses.ReviewCountResponse;
import com.example.spring_ecommerce.services.dtos.review.responses.ReviewListResponse;

import java.util.List;
import java.util.Optional;

public interface ReviewService {

    List<ReviewListResponse> getAll();

    Optional<GetReviewResponse> getByID(int id);

    void add(AddReviewRequest addReviewRequest);

    void update(UpdateReviewRequest updateReviewRequest);

    void delete(int id);

    List<ReviewCountResponse> findUsersByReviewCountLessThanTwo();

}
