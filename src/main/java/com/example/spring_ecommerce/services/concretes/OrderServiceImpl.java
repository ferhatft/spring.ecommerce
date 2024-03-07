package com.example.spring_ecommerce.services.concretes;

import com.example.spring_ecommerce.entities.Order;
import com.example.spring_ecommerce.repositories.abstracts.OrderRepository;
import com.example.spring_ecommerce.services.abstracts.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Pattern;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public List<Order> getAll() {
        return orderRepository.findAll();
    }

    @Override
    public Order getByID(int id) {
        return orderRepository.findById(id).orElse(null);
    }

    @Override
    public void add(Order order) {
        if (!isValidDateFormat(String.valueOf(order.getOrderDate()))) {
            throw new IllegalArgumentException("Date is not in valid dd-mm-yyyy format");
        }
        orderRepository.save(order);
    }

    @Override
    public Order update(int id, Order updatedOrder) {
        Order existingOrder = orderRepository.findById(id).orElse(null);
        if (existingOrder != null) {

            // Update fields of existingOrder with the fields of updatedOrder
            existingOrder.setId(updatedOrder.getId());
            existingOrder.setOrderDate(updatedOrder.getOrderDate());
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

    public static boolean isValidDateFormat(String dateString) {
        String pattern = "^\\d{2}-\\d{2}-\\d{4}$";
        return Pattern.matches(pattern, dateString);
    }
}
