package com.example.spring_ecommerce.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "addresses")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Addres{
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
