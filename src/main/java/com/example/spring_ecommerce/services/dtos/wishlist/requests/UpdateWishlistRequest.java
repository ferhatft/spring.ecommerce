package com.example.spring_ecommerce.services.dtos.wishlist.requests;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
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
    @Min(1)
    private int id;
    @NotNull
    private LocalDateTime editDate;
    @Positive
    private double currentPrice;
    @Min(1)
    private int userId;
    @Min(1)
    private int productId;
}
