package com.example.spring_ecommerce.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Table(name = "categories")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Category {

    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "category")
    @JsonIgnore
    private List<Product> products;

}
