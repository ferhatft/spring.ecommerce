package com.example.spring_ecommerce.repositories.abstracts;

import com.example.spring_ecommerce.entities.Category;
import com.example.spring_ecommerce.services.dtos.category.responses.CategoryListResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

    @Query("SELECT c FROM Category c RIGHT JOIN Product p ON c.id = p.category.id WHERE p.category.id IS NOT NULL")
    List<Category> findAllCategoriesWithProducts();
}
