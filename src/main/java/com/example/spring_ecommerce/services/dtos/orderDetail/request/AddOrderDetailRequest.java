package com.example.spring_ecommerce.services.dtos.orderDetail.request;

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
public class AddOrderDetailRequest {

    @NotBlank(message = "Address name con not be empty")
    private  String name;

    @Min(1)
    private int districtId;

    @Min(1)
    private int userId;

    @Max(300)
    private String address_detail;
}
