package com.example.spring_ecommerce.services.dtos.role.requests;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddRoleRequest {
    @NotBlank(message = "Role name cannot be blank")
    private String name;
}
