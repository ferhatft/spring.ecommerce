package com.example.spring_ecommerce.controllers;

import com.example.spring_ecommerce.entities.Country;
import com.example.spring_ecommerce.entities.Likes;
import com.example.spring_ecommerce.entities.Payment;
import com.example.spring_ecommerce.repositories.abstracts.PaymentRepository;
import com.example.spring_ecommerce.services.abstracts.PaymentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/payment")
@AllArgsConstructor
public class PaymentController {
    private PaymentService paymentService;
    @GetMapping
    public List<Payment> get(){
        return paymentService.getAll();
    }
    @GetMapping("/{id}")
    public Optional<Payment> getByID(@PathVariable int id) {
        return paymentService.getByID(id);
    }

    @PostMapping
    public void add(@RequestBody Payment payment){
        paymentService.add(payment);
    }

    @PutMapping
    public void update(@RequestBody Payment payment) {
        paymentService.update(payment);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        paymentService.delete(id);
    }
}
