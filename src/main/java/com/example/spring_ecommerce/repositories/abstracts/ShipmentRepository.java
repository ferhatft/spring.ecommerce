package com.example.spring_ecommerce.repositories.abstracts;

import com.example.spring_ecommerce.entities.Shipment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShipmentRepository extends JpaRepository<Shipment, Integer> {
}
