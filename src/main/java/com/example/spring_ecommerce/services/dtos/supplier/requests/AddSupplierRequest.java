package com.example.spring_ecommerce.services.dtos.supplier.requests;

import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddSupplierRequest {
    @Min(1)
    private int userId;
}
