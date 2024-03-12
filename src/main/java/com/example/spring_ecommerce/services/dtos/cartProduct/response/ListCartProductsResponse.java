package com.example.spring_ecommerce.services.dtos.cartProduct.response;

import com.example.spring_ecommerce.entities.Product;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ListCartProductsResponse {

    @Min(0)
    private int products;

    @Min(0)
    private int carts;


}
