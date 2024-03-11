package com.example.spring_ecommerce.services.dtos.review.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReviewCountResponse {
    private int userId;
    private Long reviewCount;
}
