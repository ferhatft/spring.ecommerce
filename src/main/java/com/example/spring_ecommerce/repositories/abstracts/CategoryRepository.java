package com.example.spring_ecommerce.repositories.abstracts;

import com.example.spring_ecommerce.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
