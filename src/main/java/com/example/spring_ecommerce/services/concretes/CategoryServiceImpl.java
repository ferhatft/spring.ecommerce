package com.example.spring_ecommerce.services.concretes;

import com.example.spring_ecommerce.core.types.CategoryNotFoundException;
import com.example.spring_ecommerce.entities.Category;
import com.example.spring_ecommerce.repositories.abstracts.CategoryRepository;
import com.example.spring_ecommerce.services.abstracts.CategoryService;
import com.example.spring_ecommerce.services.dtos.category.requests.AddCategoryRequest;
import com.example.spring_ecommerce.services.dtos.category.requests.UpdateCategoryRequest;
import com.example.spring_ecommerce.services.dtos.category.responses.CategoryListResponse;
import com.example.spring_ecommerce.services.dtos.category.responses.GetCategoryResponse;
import com.example.spring_ecommerce.services.mappers.CategoryMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public List<CategoryListResponse> getAll() {
        List<Category> categories = categoryRepository.findAll();
        List<CategoryListResponse> response = new ArrayList<>();

        for (Category category : categories) {
            CategoryListResponse dto = new CategoryListResponse(
                    category.getId(),
                    category.getName());
            response.add(dto);
        }

        return response;
    }

    @Override
    public Optional<GetCategoryResponse> getByID(int id) {
        Category category = findCategoryById(id);
        GetCategoryResponse response = CategoryMapper.INSTANCE.getCategoryResponseFromCategory(category);
        return Optional.of(response);
    }

    @Override
    public void add(AddCategoryRequest addCategoryRequest) {
        Category category = CategoryMapper.INSTANCE.categoryFromAddRequest(addCategoryRequest);
        categoryRepository.save(category);
    }

    @Override
    public void update(UpdateCategoryRequest updateCategoryRequest) {
        Category category = findCategoryById(updateCategoryRequest.getId());
        category.setName(updateCategoryRequest.getName());
        categoryRepository.save(category);
    }

    @Override
    public void delete(int id) {
        if (!categoryRepository.existsById(id)) {
            throw new CategoryNotFoundException(id);
        }
        categoryRepository.deleteById(id);
    }

    @Override
    public List<CategoryListResponse> searchCategoriesWithProducts() {
        List<Category> categories = categoryRepository.findAllCategoriesWithProducts();
        List<CategoryListResponse> response = new ArrayList<>();

        for (Category category : categories) {
            CategoryListResponse dto = new CategoryListResponse(
                    category.getId(),
                    category.getName());
            response.add(dto);
        }

        return response;

    }

    private Category findCategoryById(int id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new CategoryNotFoundException(id));
    }
}
