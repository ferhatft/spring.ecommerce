package com.example.spring_ecommerce.repositories.abstracts;

import com.example.spring_ecommerce.entities.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {
}
