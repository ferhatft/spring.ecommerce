package com.example.spring_ecommerce.services.concretes;

import com.example.spring_ecommerce.entities.Order;
import com.example.spring_ecommerce.repositories.abstracts.OrderRepository;
import com.example.spring_ecommerce.services.abstracts.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Pattern;

@Service
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public List<Order> getAll() {
        return orderRepository.getAll();
    }

    @Override
    public Order getByID(int id) {
        return orderRepository.getByID(id);
    }

    @Override
    public void add(Order order) {
        if (order.getGrandTotal() < 0) {
            throw new IllegalArgumentException("Grand total can not be smaller than zero!");
        }
        if (order.getCarrier().isEmpty()) {
            throw new IllegalArgumentException("Carrier cannot be left blank!");
        }
        if (!isValidDateFormat(order.getOrderDate())) {
            throw new IllegalArgumentException("Date is not in valid dd-mm-yyyy format");
        }
        orderRepository.add(order);
    }

    @Override
    public void update(int id, Order order) {
        if (order.getGrandTotal() < 0) {
            throw new IllegalArgumentException("Grand total can not be smaller than zero!");
        }
        if (order.getCarrier().isEmpty()) {
            throw new IllegalArgumentException("Carrier cannot be left blank!");
        }
        if (!isValidDateFormat(order.getOrderDate())) {
            throw new IllegalArgumentException("Date is not in valid dd-mm-yyyy format");
        }
        orderRepository.update(id, order);
    }

    @Override
    public void delete(int id) {
        orderRepository.delete(id);
    }

    public static boolean isValidDateFormat(String dateString) {
        String pattern = "^\\d{2}-\\d{2}-\\d{4}$";
        return Pattern.matches(pattern, dateString);
    }
}
