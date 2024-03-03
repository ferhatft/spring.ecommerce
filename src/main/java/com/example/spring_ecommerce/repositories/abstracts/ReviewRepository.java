package com.example.spring_ecommerce.repositories.abstracts;

import com.example.spring_ecommerce.entities.Product;
import com.example.spring_ecommerce.entities.Review;
import com.example.spring_ecommerce.entities.User;

import java.util.List;

public interface ReviewRepository {

    List<Review> getAll();

    Review getByID(int id);

    Review update(int id, Review review, Product product, User user);

    void delete(int id);

    void add(Review review, Product product, User user);
}
