package com.example.spring_ecommerce.services.concretes;

import com.example.spring_ecommerce.entities.Supplier;
import com.example.spring_ecommerce.entities.User;
import com.example.spring_ecommerce.repositories.abstracts.SupplierRepository;
import com.example.spring_ecommerce.services.abstracts.SupplierService;
import com.example.spring_ecommerce.services.dtos.supplier.requests.AddSupplierRequest;
import com.example.spring_ecommerce.services.dtos.supplier.requests.UpdateSupplierRequest;
import com.example.spring_ecommerce.services.dtos.supplier.responses.GetSupplierResponse;
import com.example.spring_ecommerce.services.dtos.supplier.responses.SupplierListResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class SupplierServiceImpl implements SupplierService {

    private SupplierRepository supplierRepository;

    @Override
    public List<SupplierListResponse> getAll() {
        List<Supplier> suppliers = supplierRepository.findAll();
        List<SupplierListResponse> response = new ArrayList<>();

        for (Supplier supplier: suppliers) {
            SupplierListResponse dto = new SupplierListResponse(
                    supplier.getId(),
                    supplier.getUser().getFirstName(),
                    supplier.getUser().getLastName());
            response.add(dto);
        }

        return response;
    }

    @Override
    public Optional<GetSupplierResponse> getByID(int id) {
        Supplier supplier = supplierRepository.findById(id).orElse(null);

        assert supplier!= null;
        return Optional.of(new GetSupplierResponse(
                supplier.getId(),
                supplier.getUser().getFirstName(),
                supplier.getUser().getLastName()));
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
