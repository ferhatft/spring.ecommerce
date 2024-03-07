package com.example.spring_ecommerce.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Table(name = "users")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<Review> reviews;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<UserRole> userRoles;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<Wishlist> wishlists;

    @OneToOne(mappedBy = "user")
    @JsonIgnore
    private Supplier supplier;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private  List<Addres> addres;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<Likes> likes;

}