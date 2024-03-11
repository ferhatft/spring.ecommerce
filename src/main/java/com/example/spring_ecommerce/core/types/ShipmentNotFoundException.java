package com.example.spring_ecommerce.core.types;

public class ShipmentNotFoundException extends  RuntimeException{
    public ShipmentNotFoundException(String message){
        super(message);
    }
}
