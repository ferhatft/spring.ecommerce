package com.example.spring_ecommerce.controllers;

import com.example.spring_ecommerce.entities.Category;
import com.example.spring_ecommerce.services.abstracts.CategoryService;
import com.example.spring_ecommerce.services.dtos.category.requests.AddCategoryRequest;
import com.example.spring_ecommerce.services.dtos.category.requests.UpdateCategoryRequest;
import com.example.spring_ecommerce.services.dtos.category.responses.CategoryListResponse;
import com.example.spring_ecommerce.services.dtos.category.responses.GetCategoryResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/categories")
@AllArgsConstructor
public class CategoryController {
    private CategoryService categoryService;

    @GetMapping
    public List<CategoryListResponse> get() {
        return categoryService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<GetCategoryResponse> getByID(@PathVariable int id) {
        return categoryService.getByID(id);
    }

    @PostMapping
    public void add(@RequestBody AddCategoryRequest addCategoryRequest) {
        categoryService.add(addCategoryRequest);
    }

    @PutMapping
    public void update(@RequestBody UpdateCategoryRequest updateCategoryRequest) {
        categoryService.update(updateCategoryRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        categoryService.delete(id);
    }

    @GetMapping("CategoriesWithProducts")
    List<CategoryListResponse> searchCategoriesWithProducts() {
        return categoryService.searchCategoriesWithProducts();
    }
}
