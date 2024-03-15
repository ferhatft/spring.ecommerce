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
import com.example.spring_ecommerce.services.mappers.SupplierProductMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class SupplierProductServiceImpl implements SupplierProductService {

    private final SupplierProductRepository supplierProductRepository;

    @Override
    public List<SupplierProductListResponse> getAll() {
        List<SupplierProduct> supplierProducts = supplierProductRepository.findAll();
        List<SupplierProductListResponse> response = new ArrayList<>();

        for (SupplierProduct supplierProduct : supplierProducts) {
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
        SupplierProduct supplierProduct = findSupplierProductById(id);
        GetSupplierProductResponse response = SupplierProductMapper.INSTANCE.getSupplierProductResponseFromSupplierProduct(supplierProduct);
        return Optional.of(response);
    }

    @Override
    public void add(AddSupplierProductRequest addSupplierProductRequest) {
        SupplierProduct supplierProduct = SupplierProductMapper.INSTANCE.supplierProductFromAddRequest(addSupplierProductRequest);
        supplierProductRepository.save(supplierProduct);
    }

    @Override
    public void update(UpdateSupplierProductRequest updateSupplierProductRequest) {
        SupplierProduct supplierProduct = findSupplierProductById(updateSupplierProductRequest.getId());
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
        if (!supplierProductRepository.existsById(id)) {
            throw new SupplierProductNotFoundException(id);
        }
        supplierProductRepository.deleteById(id);
    }

    @Override
    public List<ProductSupplierCountResponse> findProductsBySupplierCountGreaterThanOne() {
        return supplierProductRepository.findProductsBySupplierCountGreaterThanOne();
    }

    private SupplierProduct findSupplierProductById(int id) {
        return supplierProductRepository.findById(id)
                .orElseThrow(() -> new SupplierProductNotFoundException(id));
    }
}
