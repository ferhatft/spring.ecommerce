package com.example.spring_ecommerce.services.concretes;

import com.example.spring_ecommerce.entities.Supplier;
import com.example.spring_ecommerce.entities.User;
import com.example.spring_ecommerce.entities.UserRole;
import com.example.spring_ecommerce.repositories.abstracts.SupplierRepository;
import com.example.spring_ecommerce.services.abstracts.SupplierService;
import com.example.spring_ecommerce.services.dtos.supplier.requests.AddSupplierRequest;
import com.example.spring_ecommerce.services.dtos.supplier.requests.UpdateSupplierRequest;
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
    public void add(AddSupplierRequest addSupplierRequest) {
        User user = new User();
        user.setId(addSupplierRequest.getUserId());
        Supplier supplier = new Supplier();
        supplier.setUser(user);
        supplierRepository.save(supplier);
    }

    @Override
    public void update(UpdateSupplierRequest updateSupplierRequest) {
        Supplier supplier = supplierRepository.findById(updateSupplierRequest.getId()).orElse(null);

        if (supplier == null) {
            // TODO Handle supplier not found (e.g., log a warning or throw a custom exception later)
            return;
        }
        User user = new User();
        user.setId(updateSupplierRequest.getUserId());
        supplier.setUser(user);
        supplierRepository.save(supplier);
    }

    @Override
    public void delete(int id) {
        supplierRepository.deleteById(id);
    }
}
