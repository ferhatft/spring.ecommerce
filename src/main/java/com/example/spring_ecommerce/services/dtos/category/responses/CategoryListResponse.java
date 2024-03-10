package com.example.spring_ecommerce.services.dtos.category.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategoryListResponse {
    private int id;
    private String name;
}
