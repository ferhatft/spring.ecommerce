package com.example.spring_ecommerce.services.abstracts;

import com.example.spring_ecommerce.entities.Likes;
import com.example.spring_ecommerce.entities.Payment;

import java.util.List;
import java.util.Optional;

public interface PaymentService {

    List<Payment> getAll();

    Optional<Payment> getByID(int id);

    void add(Payment payment);

    void update(Payment payment);

    void delete(int id);
}
