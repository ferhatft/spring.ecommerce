package com.example.spring_ecommerce.services.concretes;

import com.example.spring_ecommerce.entities.Product;
import com.example.spring_ecommerce.entities.Review;
import com.example.spring_ecommerce.entities.User;
import com.example.spring_ecommerce.services.abstracts.ReviewService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService
{


    @Override
    public List<Review> getAll() {
        return null;
    }

    @Override
    public Review getByID(int id) {
        return null;
    }

    @Override
    public Review update(int id, Review review, Product product, User user) {
        return null;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void add(Review review, Product product, User user) {

    }
}
