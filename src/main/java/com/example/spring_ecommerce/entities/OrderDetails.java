package com.example.spring_ecommerce.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "order_details")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderDetails {
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;

    @ManyToOne()
    @JoinColumn(name = "productid")
    private Product product;

    @ManyToOne()
    @JoinColumn(name = "orderid")
    private Order order;

    @Column(name = "price")
    private double price;
}
