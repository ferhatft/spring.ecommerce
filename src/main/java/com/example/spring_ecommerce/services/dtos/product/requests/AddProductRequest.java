package com.example.spring_ecommerce.services.dtos.product.requests;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddProductRequest {
    @NotBlank(message = "product name con not be empty")
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
