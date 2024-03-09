package com.example.spring_ecommerce.core.types;

public class BusinessException extends RuntimeException{
    public BusinessException(String message) {
        super(message);
    }
}
