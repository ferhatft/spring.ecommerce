package com.example.spring_ecommerce.services.dtos.payment.request;

import jakarta.validation.constraints.Max;
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
public class AddPaymentRequest {

    @NotBlank(message = "Payment type connot be blank")
    private  String  payment_type;

    @NotBlank(message = "Payment status connot be blank")
        private  String status;

}
