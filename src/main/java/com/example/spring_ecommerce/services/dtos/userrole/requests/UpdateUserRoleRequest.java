package com.example.spring_ecommerce.services.dtos.userrole.requests;

import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateUserRoleRequest {
    @Min(1)
    private int id;
    @Min(1)
    private int userId;
    @Min(1)
    private int roleId;
}
