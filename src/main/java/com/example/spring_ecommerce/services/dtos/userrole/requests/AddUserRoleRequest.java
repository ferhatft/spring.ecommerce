package com.example.spring_ecommerce.services.dtos.userrole.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddUserRoleRequest {
    private int userId;
    private int roleId;
}
