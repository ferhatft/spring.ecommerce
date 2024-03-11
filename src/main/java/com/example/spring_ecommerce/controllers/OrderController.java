package com.example.spring_ecommerce.controllers;

import com.example.spring_ecommerce.entities.Order;
import com.example.spring_ecommerce.services.abstracts.OrderService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@Data
@AllArgsConstructor
public class OrderController {

    private final OrderService orderService;

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
        orderService.update(id, order);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        orderService.delete(id);
    }


    @GetMapping("/mostSoldHour")
    public List<Object[]> getMostSoldHour() {
        return orderService.findMostSoldHour();
    }

}
