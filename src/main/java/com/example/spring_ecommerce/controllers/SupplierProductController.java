package com.example.spring_ecommerce.controllers;

import com.example.spring_ecommerce.entities.SupplierProduct;
import com.example.spring_ecommerce.services.abstracts.SupplierProductService;
import com.example.spring_ecommerce.services.dtos.supplierproduct.requests.AddSupplierProductRequest;
import com.example.spring_ecommerce.services.dtos.supplierproduct.requests.UpdateSupplierProductRequest;
import com.example.spring_ecommerce.services.dtos.supplierproduct.responses.GetSupplierProductResponse;
import com.example.spring_ecommerce.services.dtos.supplierproduct.responses.ProductSupplierCountResponse;
import com.example.spring_ecommerce.services.dtos.supplierproduct.responses.SupplierProductListResponse;
import jakarta.validation.Valid;
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
    public List<SupplierProductListResponse> get() {
        return supplierProductService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<GetSupplierProductResponse> getByID(@PathVariable int id) {
        return supplierProductService.getByID(id);
    }

    @PostMapping
    public void add(@RequestBody @Valid AddSupplierProductRequest addSupplierProductRequest) {
        supplierProductService.add(addSupplierProductRequest);
    }

    @PutMapping
    public void update(@RequestBody @Valid UpdateSupplierProductRequest updateSupplierProductRequest) {
        supplierProductService.update(updateSupplierProductRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        supplierProductService.delete(id);
    }

    @GetMapping("ProductsBySupplierCountGreaterThanOne")
    public List<ProductSupplierCountResponse> findProductsBySupplierCountGreaterThanOne(){
        return supplierProductService.findProductsBySupplierCountGreaterThanOne();
    }
}

