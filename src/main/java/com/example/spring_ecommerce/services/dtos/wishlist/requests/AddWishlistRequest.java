package com.example.spring_ecommerce.services.dtos.wishlist.requests;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddWishlistRequest {
    @NotNull
    private LocalDateTime editDate;
    @Positive
    private double currentPrice;
    @Min(1)
    private int userId;
    @Min(1)
    private int productId;
}
