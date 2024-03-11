package com.example.spring_ecommerce.services.dtos.payment.response;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ListPaymentResponse {
    @NotBlank(message = "Payment type connot be blank")
    private  String  payment_type;

    @NotBlank(message = "Payment status connot be blank")
    private  String status;


}
