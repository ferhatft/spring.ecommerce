package com.example.spring_ecommerce.services.dtos.review.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetReviewResponse {
    private int id;
    private String detail;
    private String productName;
    private String userFirstName;
    private String userLastName;
}
