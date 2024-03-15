package com.example.spring_ecommerce.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Table(name = "reviews")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Review {

    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;

    @Column(name = "detail")
    private  String detail;

    @ManyToOne()
    @JoinColumn(name = "productid")
    private Product product;

    @ManyToOne()
    @JoinColumn(name = "userid")
    private User user;



}
