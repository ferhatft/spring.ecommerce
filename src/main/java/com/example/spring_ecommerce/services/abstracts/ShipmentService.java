package com.example.spring_ecommerce.services.abstracts;


import com.example.spring_ecommerce.entities.Shipment;
import com.example.spring_ecommerce.services.dtos.shipment.request.AddShipmentRequest;
import com.example.spring_ecommerce.services.dtos.shipment.request.UpdateShipmentRequest;
import com.example.spring_ecommerce.services.dtos.shipment.response.ListShipmentResponse;

import java.util.List;
import java.util.Optional;

public interface ShipmentService {
    List<ListShipmentResponse> getAll();

    Optional<Shipment> getByID(int id);

    void add(AddShipmentRequest request);

    void update(UpdateShipmentRequest request);

    void delete(int id);
}
