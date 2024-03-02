package com.example.spring_ecommerce.controllers;

import com.example.spring_ecommerce.entities.Order;
import com.example.spring_ecommerce.services.abstracts.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private OrderService orderService;


    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public List<Order> get() {
        return orderService.getAll();
    }

    @GetMapping("/{id}")
    public Order getByID(@PathVariable int id) {
        return orderService.getByID(id);
    }

    @PostMapping
    public void add(@RequestBody Order order) {
        orderService.add(order);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody Order order) {
        orderService.update(id,order);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        orderService.delete(id);
    }

}
