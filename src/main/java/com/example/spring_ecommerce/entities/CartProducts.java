package com.example.spring_ecommerce.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "cart_products")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CartProducts {


    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;

    @ManyToOne()
    @JoinColumn(name = "productid")
    private Product products;

    @ManyToOne
    @JoinColumn(name = "cartid")
    private Cart carts;
}
