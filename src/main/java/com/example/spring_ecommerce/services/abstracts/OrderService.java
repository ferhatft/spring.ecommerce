package com.example.spring_ecommerce.services.abstracts;

import com.example.spring_ecommerce.entities.Order;

import java.util.List;

public interface OrderService {
    List<Order> getAll();

    Order getByID(int id);

    void add(Order order);

    Order update(int id, Order order);

    void delete(int id);
}
