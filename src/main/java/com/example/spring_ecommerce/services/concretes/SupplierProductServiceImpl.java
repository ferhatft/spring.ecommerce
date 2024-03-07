package com.example.spring_ecommerce.services.concretes;

import com.example.spring_ecommerce.entities.SupplierProduct;
import com.example.spring_ecommerce.repositories.abstracts.SupplierProductRepository;
import com.example.spring_ecommerce.services.abstracts.SupplierProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class SupplierProductServiceImpl implements SupplierProductService {

    private SupplierProductRepository supplierProductRepository;

    @Override
    public List<SupplierProduct> getAll() {
        return supplierProductRepository.findAll();
    }

    @Override
    public Optional<SupplierProduct> getByID(int id) {
        return supplierProductRepository.findById(id);
    }

    @Override
    public void add(SupplierProduct supplierProduct) {
        supplierProductRepository.save(supplierProduct);
    }

    @Override
    public void update(SupplierProduct supplierProduct) {
        supplierProductRepository.save(supplierProduct);
    }

    @Override
    public void delete(int id) {
        supplierProductRepository.deleteById(id);
    }
}
