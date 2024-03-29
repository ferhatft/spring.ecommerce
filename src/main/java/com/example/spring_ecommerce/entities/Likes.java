package com.example.spring_ecommerce.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "likes")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Likes {
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;

    @ManyToOne()
    @JoinColumn(name = "userid")
    private User user;


    @ManyToOne()
    @JoinColumn(name = "productid")
    private Product product;

}
