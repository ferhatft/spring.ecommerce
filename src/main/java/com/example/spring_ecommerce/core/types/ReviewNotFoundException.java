package com.example.spring_ecommerce.core.types;

public class ReviewNotFoundException extends RuntimeException {
    public ReviewNotFoundException(int reviewId) {
        super("Review with ID " + reviewId + " not found");
    }
}

