package com.example.spring_ecommerce.services.dtos.review.requests;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddReviewRequest {
    @NotBlank(message = "Review detail cannot be blank")
    private String detail;
    @Min(1)
    private int productId;
    @Min(1)
    private int userId;
}
