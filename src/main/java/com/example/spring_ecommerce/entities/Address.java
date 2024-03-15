package com.example.spring_ecommerce.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "addresses")
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Address {
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private  int id;

    @ManyToOne()
    @JoinColumn(name = "districtid")
    private  District district;

    @ManyToOne()
    @JoinColumn(name = "userid")
    private  User user;

    @Column(name = "address_detail")
    private String address_detail;
}
