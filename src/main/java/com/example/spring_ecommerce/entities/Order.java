package com.example.spring_ecommerce.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

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

    @OneToOne()
    @JoinColumn(name="paymentid")
    private Payment paymentid;

    @OneToOne
    @JoinColumn(name = "shippmentid")
    private Shipment shippmentid;


    @OneToMany(mappedBy = "order")
    @JsonIgnore
    private List<OrderDetails>  orderDetails;


    @ManyToOne()
    @JoinColumn(name = "userid" )
    private User user;
}
