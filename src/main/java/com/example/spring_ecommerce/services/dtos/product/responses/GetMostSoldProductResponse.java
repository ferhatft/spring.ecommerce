package com.example.spring_ecommerce.services.dtos.product.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetMostSoldProductResponse {
    private String name;
    private LocalDateTime orderDate;
    private long soldProductCount;

}
