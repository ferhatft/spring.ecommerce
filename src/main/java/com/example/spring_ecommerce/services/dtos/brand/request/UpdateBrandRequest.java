package com.example.spring_ecommerce.services.dtos.brand.request;

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
public class UpdateBrandRequest {

    @Min(0)
    private  int id;

    @NotBlank(message = "Brand name con not be empty")
    private  String name;

}
