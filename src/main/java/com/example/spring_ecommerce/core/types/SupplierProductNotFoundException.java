package com.example.spring_ecommerce.core.types;

public class SupplierProductNotFoundException extends RuntimeException {
    public SupplierProductNotFoundException(int supplierProductId) {
        super("SupplierProduct with ID " + supplierProductId + " not found");
    }
}
