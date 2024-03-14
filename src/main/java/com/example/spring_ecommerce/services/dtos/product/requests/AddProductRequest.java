package com.example.spring_ecommerce.services.dtos.product.requests;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddProductRequest {
    @NotBlank(message = "Product name cannot be blank")
    private String name;
    @Min(0)
    private int stock;
    @Min(0)
    private double unitPrice;
    @Min(1)
    private int categoryId;
    @Min(1)
    private int brandId;
}
