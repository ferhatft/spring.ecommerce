package com.example.spring_ecommerce.services.dtos.wishlist.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateWishlistRequest {
    private int id;
    private LocalDateTime editDate;
    private double currentPrice;
    private int userId;
    private int productId;
}
