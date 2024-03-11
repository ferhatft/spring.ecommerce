package com.example.spring_ecommerce.services.dtos.review.requests;

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
public class UpdateReviewRequest {
    @Min(1)
    private int id;
    @NotBlank(message = "Review detail cannot be blank")
    private String detail;
    @Min(1)
    private int productId;
    @Min(1)
    private int userId;
}
