package com.example.spring_ecommerce.models;


import jakarta.persistence.*;

@Entity
@Table(name = "products")
public class Products{
    private long id;
    private String name;
    private String created;
    private String price;
    private String description;
    private ProductCategory categoryid;
    private Review reviewid;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }




}
