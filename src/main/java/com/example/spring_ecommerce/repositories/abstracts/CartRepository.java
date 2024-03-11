package com.example.spring_ecommerce.repositories.abstracts;

import com.example.spring_ecommerce.entities.Cart;
import com.example.spring_ecommerce.entities.Shipment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CartRepository extends JpaRepository<Cart,Integer> {

}
