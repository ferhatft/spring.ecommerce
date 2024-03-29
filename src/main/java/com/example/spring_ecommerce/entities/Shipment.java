package com.example.spring_ecommerce.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "shipment")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Shipment {

    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "estimated_delivery")
    private LocalDateTime  estimateddelivery;

    @OneToOne(mappedBy = "shippmentid")
    @JsonIgnore
    private Order order;

}
