package com.example.spring_ecommerce.services.dtos.wishlist.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetWishlistResponse {
    private int id;
    private LocalDateTime editDate;
    private double currentPrice;
    private String userFirstName;
    private String userLastName;
    private String productName;
}
