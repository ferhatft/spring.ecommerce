package com.example.spring_ecommerce.controllers;

import com.example.spring_ecommerce.entities.Review;
import com.example.spring_ecommerce.services.abstracts.ReviewService;
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
    public List<Review> get() {
        return reviewService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Review> getByID(@PathVariable int id) {
        return reviewService.getByID(id);
    }

    @PostMapping
    public void add(@RequestBody Review review) {
        reviewService.add(review);
    }

    @PutMapping
    public void update(@RequestBody Review review) {
        reviewService.update(review);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        reviewService.delete(id);
    }
}

