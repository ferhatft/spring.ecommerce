package com.example.spring_ecommerce.services.dtos.category.requests;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddCategoryRequest {
    @NotBlank(message = "Category name cannot be blank")
    private  String name;
}
