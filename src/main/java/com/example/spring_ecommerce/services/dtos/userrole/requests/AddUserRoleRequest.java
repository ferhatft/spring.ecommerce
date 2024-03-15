package com.example.spring_ecommerce.services.dtos.userrole.requests;

import jakarta.validation.constraints.Min;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddUserRoleRequest {
    @Min(1)
    private int userId;
    @Min(1)
    private int roleId;
}
