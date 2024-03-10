package com.example.spring_ecommerce.controllers;

import com.example.spring_ecommerce.entities.Review;
import com.example.spring_ecommerce.services.abstracts.ReviewService;
import com.example.spring_ecommerce.services.dtos.review.requests.AddReviewRequest;
import com.example.spring_ecommerce.services.dtos.review.requests.UpdateReviewRequest;
import com.example.spring_ecommerce.services.dtos.review.responses.GetReviewResponse;
import com.example.spring_ecommerce.services.dtos.review.responses.ReviewListResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/reviews")
@AllArgsConstructor
public class ReviewController {
    private ReviewService reviewService;

    @GetMapping
    public List<ReviewListResponse> get() {
        return reviewService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<GetReviewResponse> getByID(@PathVariable int id) {
        return reviewService.getByID(id);
    }

    @PostMapping
    public void add(@RequestBody AddReviewRequest addReviewRequest) {
        reviewService.add(addReviewRequest);
    }

    @PutMapping
    public void update(@RequestBody UpdateReviewRequest updateReviewRequest) {
        reviewService.update(updateReviewRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        reviewService.delete(id);
    }
}

