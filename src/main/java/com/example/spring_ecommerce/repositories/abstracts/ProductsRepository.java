package com.example.spring_ecommerce.repositories.abstracts;

import com.example.spring_ecommerce.entities.Product;
import com.example.spring_ecommerce.entities.Review;
import jdk.jfr.Category;

import java.util.List;

public interface ProductsRepository {

    List<Product> getAll();

    Product getByID(int id);

    Product update(int id, Product product, Category category, Review review);

    void delete(int id);

    void add(Category category);
}
