package com.example.spring_ecommerce.services.abstracts;

import com.example.spring_ecommerce.entities.Category;
import com.example.spring_ecommerce.services.dtos.category.requests.AddCategoryRequest;
import com.example.spring_ecommerce.services.dtos.category.requests.UpdateCategoryRequest;
import com.example.spring_ecommerce.services.dtos.category.responses.CategoryListResponse;
import com.example.spring_ecommerce.services.dtos.category.responses.GetCategoryResponse;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    List<CategoryListResponse> getAll();

    Optional<GetCategoryResponse> getByID(int id);

    void add(AddCategoryRequest addCategoryRequest);

    void update(UpdateCategoryRequest updateCategoryRequest);

    void delete(int id);

}
