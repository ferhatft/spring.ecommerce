package com.example.spring_ecommerce.services.dtos.order.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateOrderRequest {

    @Min(1)
    private int userId;

    @Min(1)
    private int paymentId;

    @Min(1)
    private int shippmentId;

    private LocalDateTime orderDate;

    @Min(1)
    private int orderDetails;
}
