package com.example.spring_ecommerce.controllers;

import com.example.spring_ecommerce.entities.Order;
import com.example.spring_ecommerce.services.abstracts.OrderService;
import com.example.spring_ecommerce.services.dtos.order.request.AddOrderRequest;
import com.example.spring_ecommerce.services.dtos.order.request.UpdateOrderRequest;
import com.example.spring_ecommerce.services.dtos.order.response.ListOrdersResponse;
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
    public List<ListOrdersResponse> get() {
        return orderService.getAll();
    }

    @GetMapping("/{id}")
    public Order getByID(@PathVariable int id) {
        return orderService.getByID(id);
    }

    @PostMapping
    public void add(@RequestBody AddOrderRequest request) {
        orderService.add(request);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody UpdateOrderRequest request) {
        orderService.update(id, request);
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
