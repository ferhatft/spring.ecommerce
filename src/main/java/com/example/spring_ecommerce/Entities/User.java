package com.example.spring_ecommerce.Entities;

public class User {
    private  long id;
    private  UserRoles role;  // bir kullanıcının sadece bir role e sahip olduğu senaryo düşünüldü.
    private  Addres addres;
    private  String name;
    private String email;

}
