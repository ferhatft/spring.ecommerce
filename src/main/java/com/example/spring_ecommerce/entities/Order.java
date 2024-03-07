package com.example.spring_ecommerce.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "orders")
@Data
public class Order{

    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;


    @Column(name = "order_date")
    private LocalDateTime orderDate;


    @Column(name = "userid")
    private int userId;

    @Column(name = "shippmentid")
    private int shippmentid;

    @OneToOne()
    @JoinColumn(name="paymentid")
    private Payment paymentid;


}
