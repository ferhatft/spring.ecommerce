package com.example.spring_ecommerce.services.dtos.product.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetProductResponse {
    private int id;
    private String name;
    private int stock;
    private double unitPrice;
    private String categoryName;
    private String brandName;
}
