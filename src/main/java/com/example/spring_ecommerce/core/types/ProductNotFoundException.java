package com.example.spring_ecommerce.core.types;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(int productId) {
        super("Product with ID " + productId + " not found");
    }
}
