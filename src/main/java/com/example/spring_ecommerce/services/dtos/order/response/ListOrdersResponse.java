package com.example.spring_ecommerce.services.dtos.order.response;

import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ListOrdersResponse {

    private LocalDateTime orderDate;

    @Min(1)
    private int paymentId;

    @Min(1)
    private int shippmentId;

    @Min(1)
    private int userId;




}
