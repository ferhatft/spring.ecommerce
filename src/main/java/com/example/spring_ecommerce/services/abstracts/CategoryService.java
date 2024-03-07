package com.example.spring_ecommerce.services.abstracts;

import com.example.spring_ecommerce.entities.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    List<Category> getAll();

    Optional<Category> getByID(int id);

    void add(Category category);

    void update(Category category);

    void delete(int id);

}
