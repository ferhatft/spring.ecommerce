package com.example.spring_ecommerce.repositories.abstracts;

import com.example.spring_ecommerce.entities.Order;

import java.util.List;

public interface OrderRepository {

    List<Order> getAll();

    Order getByID(int id);

    void add(Order order);

    void update(int id, Order order);

    void delete(int id);


}
