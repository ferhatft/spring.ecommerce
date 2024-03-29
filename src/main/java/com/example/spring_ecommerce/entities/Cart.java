package com.example.spring_ecommerce.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "cart")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Cart {

    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;


    @Column(name = "cart_date")
    private LocalDateTime cartdate;


    @OneToMany(mappedBy = "carts")
    @JsonIgnore
    private List<CartProducts> cartProducts;
}
