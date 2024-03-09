package com.example.spring_ecommerce.services.dtos.supplierproduct.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddSupplierProductRequest {
    private int supplierId;
    private int productId;
}
