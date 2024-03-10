package com.example.spring_ecommerce.services.dtos.user.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetUserResponse {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
}
