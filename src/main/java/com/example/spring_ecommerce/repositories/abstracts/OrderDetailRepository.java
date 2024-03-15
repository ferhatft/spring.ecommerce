package com.example.spring_ecommerce.repositories.abstracts;

import com.example.spring_ecommerce.entities.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailRepository extends JpaRepository<OrderDetails, Integer> {
}