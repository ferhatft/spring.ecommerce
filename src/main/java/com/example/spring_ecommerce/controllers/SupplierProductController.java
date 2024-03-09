package com.example.spring_ecommerce.controllers;

import com.example.spring_ecommerce.entities.SupplierProduct;
import com.example.spring_ecommerce.services.abstracts.SupplierProductService;
import com.example.spring_ecommerce.services.dtos.supplierproduct.requests.AddSupplierProductRequest;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/api/supplierProducts")
@AllArgsConstructor
public class SupplierProductController {
    private SupplierProductService supplierProductService;

    @GetMapping
    public List<SupplierProduct> get() {
        return supplierProductService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<SupplierProduct> getByID(@PathVariable int id) {
        return supplierProductService.getByID(id);
    }

    @PostMapping
    public void add(@RequestBody AddSupplierProductRequest addSupplierProductRequest) {
        supplierProductService.add(addSupplierProductRequest);
    }

    @PutMapping
    public void update(@RequestBody SupplierProduct supplierProduct) {
        supplierProductService.update(supplierProduct);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        supplierProductService.delete(id);
    }
}

