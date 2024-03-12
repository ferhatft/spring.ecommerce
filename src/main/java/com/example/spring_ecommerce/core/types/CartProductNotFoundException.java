package com.example.spring_ecommerce.core.types;

public class CartProductNotFoundException extends RuntimeException{
    public CartProductNotFoundException(String message){
        super(message);
    }
}
