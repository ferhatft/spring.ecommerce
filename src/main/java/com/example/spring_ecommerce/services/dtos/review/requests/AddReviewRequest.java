package com.example.spring_ecommerce.services.dtos.review.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddReviewRequest {
    private String detail;
    private int productId;
    private int userId;
}
