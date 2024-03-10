package com.example.spring_ecommerce.services.dtos.user.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddUserRequest {
    private String firstName;
    private String lastName;
    private String email;
}
