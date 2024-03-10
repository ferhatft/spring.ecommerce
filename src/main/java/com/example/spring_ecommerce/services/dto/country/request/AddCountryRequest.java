package com.example.spring_ecommerce.services.dto.country.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddCountryRequest {

    @NotBlank(message = "Country name con not be empty")
    private  String name;


}
