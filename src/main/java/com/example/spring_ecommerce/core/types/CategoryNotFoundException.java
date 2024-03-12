package com.example.spring_ecommerce.core.types;

public class CategoryNotFoundException extends RuntimeException {
    public CategoryNotFoundException(int categoryId) {
        super("Category with ID " + categoryId + " not found");
    }
}
