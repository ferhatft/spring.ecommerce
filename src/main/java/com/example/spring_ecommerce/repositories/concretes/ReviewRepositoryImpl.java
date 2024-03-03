package com.example.spring_ecommerce.repositories.concretes;

import com.example.spring_ecommerce.entities.Product;
import com.example.spring_ecommerce.entities.Review;
import com.example.spring_ecommerce.entities.User;
import com.example.spring_ecommerce.repositories.abstracts.ReviewRepository;

import java.util.ArrayList;
import java.util.List;

public class ReviewRepositoryImpl implements ReviewRepository
{

    private List<Review> reviews = new ArrayList<>();

    @Override
    public List<Review> getAll() {
        return reviews;
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
