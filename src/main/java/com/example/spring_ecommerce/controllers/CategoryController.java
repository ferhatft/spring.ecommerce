package com.example.spring_ecommerce.controllers;

import com.example.spring_ecommerce.entities.Category;
import com.example.spring_ecommerce.services.abstracts.CategoryService;
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
    public List<Category> get() {
        return categoryService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Category> getByID(@PathVariable int id) {
        return categoryService.getByID(id);
    }

    @PostMapping
    public void add(@RequestBody Category category) {
        categoryService.add(category);
    }

    @PutMapping
    public void update(@RequestBody Category category) {
        categoryService.update(category);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        categoryService.delete(id);
    }
}
