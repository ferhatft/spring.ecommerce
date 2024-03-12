package com.example.spring_ecommerce.services.abstracts;

import com.example.spring_ecommerce.entities.Order;
import com.example.spring_ecommerce.services.dtos.order.request.AddOrderRequest;
import com.example.spring_ecommerce.services.dtos.order.request.UpdateOrderRequest;
import com.example.spring_ecommerce.services.dtos.order.response.ListOrdersResponse;

import java.util.List;

public interface OrderService {
    List<ListOrdersResponse> getAll();

    Order getByID(int id);

    void add(AddOrderRequest order);

    Order update(int id, UpdateOrderRequest order);

    void delete(int id);

    List<Object[]> findMostSoldHour();
}
