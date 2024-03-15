package com.example.spring_ecommerce.services.dtos.order.request;

import com.example.spring_ecommerce.entities.OrderDetails;
import com.example.spring_ecommerce.entities.Payment;
import com.example.spring_ecommerce.entities.Shipment;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddOrderRequest {

    @Min(1)
    private int userId;

    @Min(1)
    private int paymentId;

    @Min(1)
    private int shippmentId;

    private LocalDateTime orderDate;

    List<OrderDetails> orderDetails ;


//    @Min(1)
//    private int orderDetails;

}
