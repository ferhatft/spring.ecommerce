package com.example.spring_ecommerce.services.dtos.supplierproduct.requests;

import jakarta.validation.constraints.Min;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddSupplierProductRequest {
    @Min(1)
    private int supplierId;
    @Min(1)
    private int productId;
}
