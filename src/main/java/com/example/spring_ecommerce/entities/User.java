package com.example.spring_ecommerce.entities;

public class User {

    private int id;
    private int roleId;
    private int addressId;
    private String name;
    private String mail;

    public User(int id, int roleId, int addressId, String name, String mail) {
        this.id = id;
        this.roleId = roleId;
        this.addressId = addressId;
        this.name = name;
        this.mail = mail;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}