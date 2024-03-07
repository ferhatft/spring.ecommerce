package com.example.spring_ecommerce.services.abstracts;


import com.example.spring_ecommerce.entities.Shipment;

import java.util.List;
import java.util.Optional;

public interface ShipmentService {
    List<Shipment> getAll();

    Optional<Shipment> getByID(int id);

    void add(Shipment shipment);

    void update(Shipment shipment);

    void delete(int id);
}
