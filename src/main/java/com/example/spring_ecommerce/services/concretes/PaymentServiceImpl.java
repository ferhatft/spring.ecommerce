package com.example.spring_ecommerce.services.concretes;

import com.example.spring_ecommerce.entities.Likes;
import com.example.spring_ecommerce.entities.Payment;
import com.example.spring_ecommerce.repositories.abstracts.PaymentRepository;
import com.example.spring_ecommerce.services.abstracts.PaymentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PaymentServiceImpl implements PaymentService {
    private PaymentRepository paymentRepository;

    @Override
    public List<Payment> getAll() {
        return paymentRepository.findAll();
    }

    @Override
    public Optional<Payment> getByID(int id) {
        return Optional.empty();
    }

    @Override
    public void add(Payment payment) {

    }

    @Override
    public void update(Payment payment) {

    }

    @Override
    public void delete(int id) {

    }
}
