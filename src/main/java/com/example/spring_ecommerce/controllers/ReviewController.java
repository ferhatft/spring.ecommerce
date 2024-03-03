package com.example.spring_ecommerce.controllers;

import com.example.spring_ecommerce.entities.Order;
import com.example.spring_ecommerce.entities.Product;
import com.example.spring_ecommerce.entities.Review;
import com.example.spring_ecommerce.entities.User;
import com.example.spring_ecommerce.services.abstracts.OrderService;
import com.example.spring_ecommerce.services.abstracts.ProductService;
import com.example.spring_ecommerce.services.abstracts.ReviewService;
import jdk.jfr.Category;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews/")
public class ReviewController {

    private ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping(value = "/create/")
    public void add(@RequestBody Review review, Product product, User user) {
        reviewService.add(review, product,user);
    }

    @GetMapping
    public List<Review> get()
    {
        return reviewService.getAll();
    }

    @PutMapping(value = "/update/{id}")
    public Review update(@PathVariable("id") int id, @RequestBody Review review, Product product,User user) {

        Review updatedReview;
        updatedReview = reviewService.update(id, review, product,user);

        return updatedReview;
    }


    @DeleteMapping("{id}")
    public void delete(@PathVariable int id) {
        reviewService.delete(id);
    }
}
