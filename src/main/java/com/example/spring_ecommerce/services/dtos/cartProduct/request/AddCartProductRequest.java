package com.example.spring_ecommerce.services.dtos.cartProduct.request;

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
public class AddCartProductRequest {
    @Min(1)
    private  int id ;

    @Min(1)
    private int products;

    @Min(1)
    private int carts;

}
