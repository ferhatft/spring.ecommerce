package com.example.spring_ecommerce.controllers;

import com.example.spring_ecommerce.entities.Review;
import com.example.spring_ecommerce.entities.Shipment;
import com.example.spring_ecommerce.services.abstracts.ShipmentService;
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
    public List<Shipment> get() {
        return shipmentService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Shipment> getByID(@PathVariable int id) {
        return shipmentService.getByID(id);
    }

    @PostMapping
    public void add(@RequestBody Shipment shipment) {
        shipmentService.add(shipment);
    }

    @PutMapping
    public void update(@RequestBody Shipment shipment) {
        shipmentService.update(shipment);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        shipmentService.delete(id);
    }
}
