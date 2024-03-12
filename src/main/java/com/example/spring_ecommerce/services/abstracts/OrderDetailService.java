package com.example.spring_ecommerce.services.abstracts;

import com.example.spring_ecommerce.entities.OrderDetails;
import com.example.spring_ecommerce.services.dtos.orderDetail.request.AddOrderDetailRequest;
import com.example.spring_ecommerce.services.dtos.orderDetail.request.UpdateOrderDetailRequest;
import com.example.spring_ecommerce.services.dtos.orderDetail.response.ListOrderDetailsResponse;

import java.util.List;
import java.util.Optional;

public interface OrderDetailService {
    List<ListOrderDetailsResponse> getAll();

    Optional<OrderDetails> getByID(int id);

    void add(AddOrderDetailRequest request);

    void update(UpdateOrderDetailRequest request);

    void delete(int id);
}
