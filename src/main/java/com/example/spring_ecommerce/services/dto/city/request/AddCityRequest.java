package com.example.spring_ecommerce.services.dto.city.request;

import com.example.spring_ecommerce.entities.Country;
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
public class AddCityRequest {

    @NotBlank(message = "City name con not be empty")
    private  String name;

    @Min(1)
    private int countryId;
}
