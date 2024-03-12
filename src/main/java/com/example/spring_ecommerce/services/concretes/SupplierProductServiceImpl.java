package com.example.spring_ecommerce.services.concretes;

import com.example.spring_ecommerce.core.types.SupplierProductNotFoundException;
import com.example.spring_ecommerce.entities.Product;
import com.example.spring_ecommerce.entities.Supplier;
import com.example.spring_ecommerce.entities.SupplierProduct;
import com.example.spring_ecommerce.repositories.abstracts.SupplierProductRepository;
import com.example.spring_ecommerce.services.abstracts.SupplierProductService;
import com.example.spring_ecommerce.services.dtos.supplierproduct.requests.AddSupplierProductRequest;
import com.example.spring_ecommerce.services.dtos.supplierproduct.requests.UpdateSupplierProductRequest;
import com.example.spring_ecommerce.services.dtos.supplierproduct.responses.GetSupplierProductResponse;
import com.example.spring_ecommerce.services.dtos.supplierproduct.responses.ProductSupplierCountResponse;
import com.example.spring_ecommerce.services.dtos.supplierproduct.responses.SupplierProductListResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class SupplierProductServiceImpl implements SupplierProductService {

    private SupplierProductRepository supplierProductRepository;

    @Override
    public List<SupplierProductListResponse> getAll() {
        List<SupplierProduct> supplierProducts= supplierProductRepository.findAll();
        List<SupplierProductListResponse> response = new ArrayList<>();

        for (SupplierProduct supplierProduct: supplierProducts) {
            SupplierProductListResponse dto = new SupplierProductListResponse(
                    supplierProduct.getId(),
                    supplierProduct.getSupplier().getUser().getFirstName(),
                    supplierProduct.getSupplier().getUser().getLastName(),
                    supplierProduct.getProduct().getName());
            response.add(dto);
        }

        return response;
    }

    @Override
    public Optional<GetSupplierProductResponse> getByID(int id) {
        SupplierProduct supplierProduct = supplierProductRepository.findById(id).orElse(null);

        assert supplierProduct != null;
        return Optional.of(new GetSupplierProductResponse(
                supplierProduct.getId(),
                supplierProduct.getSupplier().getUser().getFirstName(),
                supplierProduct.getSupplier().getUser().getLastName(),
                supplierProduct.getProduct().getName()));
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
            throw new SupplierProductNotFoundException(updateSupplierProductRequest.getId());
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

    @Override
    public List<ProductSupplierCountResponse> findProductsBySupplierCountGreaterThanOne() {
        return supplierProductRepository.findProductsBySupplierCountGreaterThanOne();
    }
}
