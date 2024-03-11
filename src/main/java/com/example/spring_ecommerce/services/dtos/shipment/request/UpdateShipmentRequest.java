package com.example.spring_ecommerce.services.dtos.shipment.request;

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
public class UpdateShipmentRequest {

    @Min(0)
    private  int id;

    @NotBlank(message = "Address name con not be empty")
    private  String name;


    private LocalDateTime estimateddelivery;

}
