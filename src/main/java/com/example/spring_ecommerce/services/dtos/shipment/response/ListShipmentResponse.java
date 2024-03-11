package com.example.spring_ecommerce.services.dtos.shipment.response;

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
public class ListShipmentResponse {

    @NotBlank(message = "product name con not be empty")
    private  String name;


    private LocalDateTime estimateddelivery;

}
