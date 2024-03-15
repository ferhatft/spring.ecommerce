package com.example.spring_ecommerce.services.dtos.supplier.requests;

import jakarta.validation.constraints.Min;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddSupplierRequest {
    @Min(1)
    private int userId;
}
