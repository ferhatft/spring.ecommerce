package com.example.spring_ecommerce.services.concretes;

import com.example.spring_ecommerce.entities.OrderDetails;
import com.example.spring_ecommerce.services.abstracts.OrderDetailService;
import com.example.spring_ecommerce.services.dtos.orderDetail.request.AddOrderDetailRequest;
import com.example.spring_ecommerce.services.dtos.orderDetail.request.UpdateOrderDetailRequest;
import com.example.spring_ecommerce.services.dtos.orderDetail.response.ListOrderDetailsResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class OrderDetailServiceImpl implements OrderDetailService {
    @Override
    public List<ListOrderDetailsResponse> getAll() {
        return null;
    }

    @Override
    public Optional<OrderDetails> getByID(int id) {
        return Optional.empty();
    }

    @Override
    public void add(AddOrderDetailRequest request) {

    }

    @Override
    public void update(UpdateOrderDetailRequest request) {

    }

    @Override
    public void delete(int id) {

    }
}
