package com.example.spring_ecommerce.repositories.abstracts;

import com.example.spring_ecommerce.entities.Country;
import com.example.spring_ecommerce.entities.Shipment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ShipmentRepository extends JpaRepository<Shipment, Integer> {

    Optional<Shipment> findByName(String name);
}
