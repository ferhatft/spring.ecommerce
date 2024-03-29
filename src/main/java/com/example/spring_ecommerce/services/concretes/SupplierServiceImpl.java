package com.example.spring_ecommerce.services.concretes;

import com.example.spring_ecommerce.core.types.SupplierNotFoundException;
import com.example.spring_ecommerce.entities.Supplier;
import com.example.spring_ecommerce.entities.User;
import com.example.spring_ecommerce.repositories.abstracts.SupplierRepository;
import com.example.spring_ecommerce.services.abstracts.SupplierService;
import com.example.spring_ecommerce.services.dtos.supplier.requests.AddSupplierRequest;
import com.example.spring_ecommerce.services.dtos.supplier.requests.UpdateSupplierRequest;
import com.example.spring_ecommerce.services.dtos.supplier.responses.GetSupplierResponse;
import com.example.spring_ecommerce.services.dtos.supplier.responses.SupplierListResponse;
import com.example.spring_ecommerce.services.mappers.SupplierMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class SupplierServiceImpl implements SupplierService {

    private final SupplierRepository supplierRepository;

    @Override
    public List<SupplierListResponse> getAll() {
        List<Supplier> suppliers = supplierRepository.findAll();
        List<SupplierListResponse> response = new ArrayList<>();

        for (Supplier supplier : suppliers) {
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
        Supplier supplier = findSupplierById(id);
        GetSupplierResponse response = SupplierMapper.INSTANCE.getSupplierResponseFromSupplier(supplier);
        return Optional.of(response);
    }

    @Override
    public void add(AddSupplierRequest addSupplierRequest) {
        Supplier supplier = SupplierMapper.INSTANCE.supplierFromAddRequest(addSupplierRequest);
        supplierRepository.save(supplier);
    }

    @Override
    public void update(UpdateSupplierRequest updateSupplierRequest) {
        Supplier supplier = findSupplierById(updateSupplierRequest.getId());
        User user = new User();
        user.setId(updateSupplierRequest.getUserId());
        supplier.setUser(user);
        supplierRepository.save(supplier);
    }

    @Override
    public void delete(int id) {
        if (!supplierRepository.existsById(id)) {
            throw new SupplierNotFoundException(id);
        }
        supplierRepository.deleteById(id);
    }

    private Supplier findSupplierById(int id) {
        return supplierRepository.findById(id)
                .orElseThrow(() -> new SupplierNotFoundException(id));
    }
}
