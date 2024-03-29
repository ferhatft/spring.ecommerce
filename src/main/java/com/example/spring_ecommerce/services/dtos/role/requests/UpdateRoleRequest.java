package com.example.spring_ecommerce.services.dtos.role.requests;

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
public class UpdateRoleRequest {
    @Min(1)
    private int id;
    @NotBlank(message = "Role name cannot be blank")
    private String name;
}
