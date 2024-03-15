package com.example.spring_ecommerce.services.dtos.district.request;

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
public class AddDistrictRequest {

    @NotBlank(message = "District name con not be empty")
    private  String name;


    @Min(0)
    private  int cityid;



}
