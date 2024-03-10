package com.example.spring_ecommerce.controllers;

import com.example.spring_ecommerce.entities.Supplier;
import com.example.spring_ecommerce.services.abstracts.SupplierService;
import com.example.spring_ecommerce.services.dtos.supplier.requests.AddSupplierRequest;
import com.example.spring_ecommerce.services.dtos.supplier.requests.UpdateSupplierRequest;
import com.example.spring_ecommerce.services.dtos.supplier.responses.GetSupplierResponse;
import com.example.spring_ecommerce.services.dtos.supplier.responses.SupplierListResponse;
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
    public List<SupplierListResponse> get() {
        return supplierService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<GetSupplierResponse> getByID(@PathVariable int id) {
        return supplierService.getByID(id);
    }

    @PostMapping
    public void add(@RequestBody AddSupplierRequest addSupplierRequest) {
        supplierService.add(addSupplierRequest);
    }

    @PutMapping
    public void update(@RequestBody UpdateSupplierRequest updateSupplierRequest) {
        supplierService.update(updateSupplierRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        supplierService.delete(id);
    }
}

