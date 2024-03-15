package com.example.spring_ecommerce.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Table(name = "wishlists")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Wishlist {

    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;

    @Column(name = "edit_date")
    private LocalDateTime editDate;

    @Column(name = "current_price")
    private double currentPrice;

    @ManyToOne()
    @JoinColumn(name = "userid")
    private User user;

    @ManyToOne()
    @JoinColumn(name = "productid")
    private Product product;
}
