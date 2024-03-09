package com.example.spring_ecommerce.controllers;

import com.example.spring_ecommerce.entities.Supplier;
import com.example.spring_ecommerce.services.abstracts.SupplierService;
import com.example.spring_ecommerce.services.dtos.supplier.requests.AddSupplierRequest;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/suppliers")
@AllArgsConstructor
public class SupplierController {
    private SupplierService supplierService;

    @GetMapping
    public List<Supplier> get() {
        return supplierService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Supplier> getByID(@PathVariable int id) {
        return supplierService.getByID(id);
    }

    @PostMapping
    public void add(@RequestBody AddSupplierRequest addSupplierRequest) {
        supplierService.add(addSupplierRequest);
    }

    @PutMapping
    public void update(@RequestBody Supplier supplier) {
        supplierService.update(supplier);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        supplierService.delete(id);
    }
}

