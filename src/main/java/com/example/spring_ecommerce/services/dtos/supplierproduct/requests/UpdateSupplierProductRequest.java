package com.example.spring_ecommerce.services.dtos.supplierproduct.requests;

import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateSupplierProductRequest {
    @Min(1)
    private int id;
    @Min(1)
    private int supplierId;
    @Min(1)
    private int productId;
}
