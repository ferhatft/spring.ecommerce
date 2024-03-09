package com.example.spring_ecommerce.services.concretes;

import com.example.spring_ecommerce.entities.Category;
import com.example.spring_ecommerce.repositories.abstracts.CategoryRepository;
import com.example.spring_ecommerce.services.abstracts.CategoryService;
import com.example.spring_ecommerce.services.dtos.category.requests.AddCategoryRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;

    @Override
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Optional<Category> getByID(int id) {
        return categoryRepository.findById(id);
    }

    @Override
    public void add(AddCategoryRequest addCategoryRequest) {
        Category category = new Category();
        category.setName(addCategoryRequest.getName());
        categoryRepository.save(category);
    }

    @Override
    public void update(Category category) {
        if (category.getName().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be left blank!");
        }
        categoryRepository.save(category);
    }

    @Override
    public void delete(int id) {
        categoryRepository.deleteById(id);
    }
}
