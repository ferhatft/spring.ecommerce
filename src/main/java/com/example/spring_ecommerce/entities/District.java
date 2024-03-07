package com.example.spring_ecommerce.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "districts")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class District {
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private  int id;


    @Column(name="name")
    private String name;


    @ManyToOne()
    @JoinColumn(name="cityid")
    private City city;

    @OneToMany(mappedBy = "district")
    @JsonIgnore
    private List<Addres> addres;

}
