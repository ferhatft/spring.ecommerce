package com.example.spring_ecommerce.services.abstracts;

import com.example.spring_ecommerce.entities.Category;
import com.example.spring_ecommerce.services.dtos.category.requests.AddCategoryRequest;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    List<Category> getAll();

    Optional<Category> getByID(int id);

    void add(AddCategoryRequest addCategoryRequest);

    void update(Category category);

    void delete(int id);

}
