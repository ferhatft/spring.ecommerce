package com.example.spring_ecommerce.Entities;





public class Product {
    private long id;
    private String name;
    private String created;
    private String price;
    private String description;
    private ProductCategory category;
    private Review review;


//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    public long getId() {
//        return id;
//    }




}
