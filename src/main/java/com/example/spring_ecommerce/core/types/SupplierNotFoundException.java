package com.example.spring_ecommerce.core.types;

public class SupplierNotFoundException extends RuntimeException {
    public SupplierNotFoundException(int supplierId) {
        super("Supplier with ID " + supplierId + " not found");
    }
}
