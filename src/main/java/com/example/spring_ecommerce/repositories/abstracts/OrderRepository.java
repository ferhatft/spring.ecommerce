package com.example.spring_ecommerce.repositories.abstracts;

import com.example.spring_ecommerce.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer> {


}
