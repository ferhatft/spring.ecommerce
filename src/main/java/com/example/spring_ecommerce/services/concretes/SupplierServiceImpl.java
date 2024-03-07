package com.example.spring_ecommerce.services.concretes;

import com.example.spring_ecommerce.entities.Supplier;
import com.example.spring_ecommerce.repositories.abstracts.SupplierRepository;
import com.example.spring_ecommerce.services.abstracts.SupplierService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class SupplierServiceImpl implements SupplierService {

    private SupplierRepository supplierRepository;

    @Override
    public List<Supplier> getAll() {
        return supplierRepository.findAll();
    }

    @Override
    public Optional<Supplier> getByID(int id) {
        return supplierRepository.findById(id);
    }

    @Override
    public void add(Supplier supplier) {
        supplierRepository.save(supplier);
    }

    @Override
    public void update(Supplier supplier) {
        supplierRepository.save(supplier);
    }

    @Override
    public void delete(int id) {
        supplierRepository.deleteById(id);
    }
}
