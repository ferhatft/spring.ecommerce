package com.example.spring_ecommerce.services.concretes;

import com.example.spring_ecommerce.entities.Shipment;
import com.example.spring_ecommerce.repositories.abstracts.ShipmentRepository;
import com.example.spring_ecommerce.services.abstracts.ShipmentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@AllArgsConstructor
@Service
public class ShipmentServiceImpl implements ShipmentService {
    private  ShipmentRepository shipmentRepository;

    @Override
    public List<Shipment> getAll() {
        return null;
    }

    @Override
    public Optional<Shipment> getByID(int id) {
        return Optional.empty();
    }

    @Override
    public void add(Shipment shipment) {

    }

    @Override
    public void update(Shipment shipment) {

    }

    @Override
    public void delete(int id) {

    }
}
