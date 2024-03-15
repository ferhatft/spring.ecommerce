package com.example.spring_ecommerce.services.concretes;

import com.example.spring_ecommerce.entities.*;
import com.example.spring_ecommerce.repositories.abstracts.OrderRepository;
import com.example.spring_ecommerce.services.abstracts.OrderService;
import com.example.spring_ecommerce.services.dtos.order.request.AddOrderRequest;
import com.example.spring_ecommerce.services.dtos.order.request.UpdateOrderRequest;
import com.example.spring_ecommerce.services.dtos.order.response.ListOrdersResponse;
import com.example.spring_ecommerce.services.dtos.review.responses.ReviewListResponse;
import com.example.spring_ecommerce.services.mappers.OrderMapper;
import org.aspectj.weaver.ast.Or;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public List<ListOrdersResponse> getAll() {

        List<Order> orders = orderRepository.findAll();
        List<ListOrdersResponse> response = new ArrayList<>();

        for (Order order: orders) {
            ListOrdersResponse ordersResponse = new ListOrdersResponse(
                    order.getOrderDate(),
                    order.getPaymentid().getId(),
                    order.getShippmentid().getId(),
                    order.getUser().getId()
            );

            response.add(ordersResponse);
        }

        return response;
    }

    @Override
    public Order getByID(int id) {
        return orderRepository.findById(id).orElse(null);
    }

    @Override
    public void add(AddOrderRequest request) {

//        OrderDetails orderDetails1 = new OrderDetails();
//        List<OrderDetails>  orderDetails = new ArrayList<>();
//        orderDetails.add(orderDetails1);
//
//        User user = new User();
//        user.setId(request.getUserId());
//        Payment payment = new Payment();
//        payment.setId(request.getPaymentId());
//        Shipment shipment = new Shipment();
//        shipment.setId(request.getShippmentId());
//
//
//        Order order = new Order();
//        order.setOrderDetails(orderDetails);
//        order.setUser(user);
//        order.setPaymentid(payment);
//        order.setShippmentid(shipment);


        Order order = OrderMapper.INSTANCE.orderFromAddRequest(request);
        orderRepository.save(order);

    }

    @Override
    public Order update(int id, UpdateOrderRequest request) {
        Order existingOrder = orderRepository.findById(id).orElse(null);


        OrderDetails orderDetails1 = new OrderDetails();
        List<OrderDetails>  orderDetails = new ArrayList<>();
        orderDetails.add(orderDetails1);

        User user = new User();
        user.setId(request.getUserId());
        Payment payment = new Payment();
        payment.setId(request.getPaymentId());
        Shipment shipment = new Shipment();
        shipment.setId(request.getShippmentId());

        if (existingOrder != null) {

            // Update fields of existingOrder with the fields of updatedOrder
            existingOrder.setOrderDate(request.getOrderDate());
            existingOrder.setUser(user);
            existingOrder.setPaymentid(payment);
            existingOrder.setPaymentid(payment);
            existingOrder.setOrderDetails(orderDetails);
            // Set other fields as needed

            // Save the updated order
            return orderRepository.save(existingOrder);
        }
        return null; // or throw an exception indicating order not found
    }

    @Override
    public void delete(int id) {
        orderRepository.deleteById(id);

    }

    @Override
    public List<Object[]> findMostSoldHour() {
        return orderRepository.findMostSoldHour();
    }

    public static boolean isValidDateFormat(String dateString) {
        String pattern = "^\\d{2}-\\d{2}-\\d{4}$";
        return Pattern.matches(pattern, dateString);
    }
}
