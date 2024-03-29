package com.example.spring_ecommerce.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Table(name = "countries")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Country {

    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;

    @Column(name = "name")
    private String name;


    @OneToMany(mappedBy = "country")
    @JsonIgnore // TODO: remove after dto
    private List<City> cities;

}
