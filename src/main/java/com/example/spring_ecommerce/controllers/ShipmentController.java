package com.example.spring_ecommerce.controllers;

import com.example.spring_ecommerce.entities.Review;
import com.example.spring_ecommerce.entities.Shipment;
import com.example.spring_ecommerce.services.abstracts.ShipmentService;
import com.example.spring_ecommerce.services.dtos.shipment.request.AddShipmentRequest;
import com.example.spring_ecommerce.services.dtos.shipment.request.UpdateShipmentRequest;
import com.example.spring_ecommerce.services.dtos.shipment.response.ListShipmentResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/shipment")
@AllArgsConstructor
public class ShipmentController {

    private ShipmentService shipmentService;
    @GetMapping
    public List<ListShipmentResponse> get() {
        return shipmentService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Shipment> getByID(@PathVariable int id) {
        return shipmentService.getByID(id);
    }

    @PostMapping
    public void add(@RequestBody @Valid AddShipmentRequest request) {
        shipmentService.add(request);
    }

    @PutMapping
    public void update(@RequestBody  @Valid UpdateShipmentRequest request) {
        shipmentService.update(request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        shipmentService.delete(id);
    }
}
