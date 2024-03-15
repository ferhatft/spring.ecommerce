package com.example.spring_ecommerce.services.concretes;

import com.example.spring_ecommerce.entities.OrderDetails;
import com.example.spring_ecommerce.repositories.abstracts.OrderDetailRepository;
import com.example.spring_ecommerce.repositories.abstracts.OrderRepository;
import com.example.spring_ecommerce.services.abstracts.OrderDetailService;
import com.example.spring_ecommerce.services.dtos.orderDetail.request.AddOrderDetailRequest;
import com.example.spring_ecommerce.services.dtos.orderDetail.request.UpdateOrderDetailRequest;
import com.example.spring_ecommerce.services.dtos.orderDetail.response.ListOrderDetailsResponse;
import com.example.spring_ecommerce.services.mappers.OrderDetailMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class OrderDetailServiceImpl implements OrderDetailService {

    private OrderDetailRepository orderDetailRepository;
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

        OrderDetails orderDetails = OrderDetailMapper.INSTANCE.orderDetailsFromAddRequest(request);
        orderDetailRepository.save(orderDetails);

    }

    @Override
    public void update(UpdateOrderDetailRequest request) {

    }

    @Override
    public void delete(int id) {

    }
}
