package com.example.spring_ecommerce.services.dtos.supplier.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateSupplierRequest {
    private int id;
    private int userId;
}
