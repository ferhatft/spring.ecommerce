package com.example.spring_ecommerce.services.dtos.supplier.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SupplierListResponse {
    private int id;
    private String userFirstName;
    private String userLastName;
}
