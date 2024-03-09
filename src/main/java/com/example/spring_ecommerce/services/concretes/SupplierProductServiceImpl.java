package com.example.spring_ecommerce.services.concretes;

import com.example.spring_ecommerce.entities.Product;
import com.example.spring_ecommerce.entities.Supplier;
import com.example.spring_ecommerce.entities.SupplierProduct;
import com.example.spring_ecommerce.repositories.abstracts.SupplierProductRepository;
import com.example.spring_ecommerce.services.abstracts.SupplierProductService;
import com.example.spring_ecommerce.services.dtos.supplierproduct.requests.AddSupplierProductRequest;
import com.example.spring_ecommerce.services.dtos.supplierproduct.requests.UpdateSupplierProductRequest;
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
    public void add(AddSupplierProductRequest addSupplierProductRequest) {
        Supplier supplier = new Supplier();
        supplier.setId(addSupplierProductRequest.getSupplierId());
        Product product = new Product();
        product.setId(addSupplierProductRequest.getProductId());
        SupplierProduct supplierProduct = new SupplierProduct();
        supplierProduct.setSupplier(supplier);
        supplierProduct.setProduct(product);
        supplierProductRepository.save(supplierProduct);
    }

    @Override
    public void update(UpdateSupplierProductRequest updateSupplierProductRequest) {
        SupplierProduct supplierProduct = supplierProductRepository.findById(updateSupplierProductRequest.getId()).orElse(null);

        if (supplierProduct == null) {
            // TODO Handle supplierProduct not found (e.g., log a warning or throw a custom exception later)
            return;
        }
        Supplier supplier = new Supplier();
        supplier.setId(updateSupplierProductRequest.getSupplierId());
        Product product = new Product();
        product.setId(updateSupplierProductRequest.getProductId());
        supplierProduct.setSupplier(supplier);
        supplierProduct.setProduct(product);
        supplierProductRepository.save(supplierProduct);
    }

    @Override
    public void delete(int id) {
        supplierProductRepository.deleteById(id);
    }
}
