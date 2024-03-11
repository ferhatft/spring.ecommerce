package com.example.spring_ecommerce.services.dtos.category.requests;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddCategoryRequest {
    @NotBlank(message = "Category name cannot be blank")
    private  String name;
}
