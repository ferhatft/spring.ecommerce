package com.example.spring_ecommerce.services.abstracts;

import com.example.spring_ecommerce.entities.Product;
import com.example.spring_ecommerce.entities.Review;
import com.example.spring_ecommerce.entities.User;
import jdk.jfr.Category;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ReviewService {
    List<Review> getAll();

    Review getByID(int id);

    Review update(int id, Review review, Product product, User user);

    void delete(int id);

    void add(Review review, Product product, User user);
}
