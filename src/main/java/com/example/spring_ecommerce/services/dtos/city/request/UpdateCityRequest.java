package com.example.spring_ecommerce.services.dtos.city.request;

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
public class UpdateCityRequest {

    @Min(0)
    private  int id;

    @NotBlank(message = "City name con not be empty")
    private  String name;

    @Min(1)
    private int countryId;
}
