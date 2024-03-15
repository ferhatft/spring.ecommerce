package com.example.spring_ecommerce.services.concretes;

import com.example.spring_ecommerce.core.types.BrandNotFoundException;
import com.example.spring_ecommerce.core.types.CountryNotFoundException;
import com.example.spring_ecommerce.entities.Brand;
import com.example.spring_ecommerce.entities.Country;
import com.example.spring_ecommerce.repositories.abstracts.BrandRepository;
import com.example.spring_ecommerce.services.abstracts.BrandServices;
import com.example.spring_ecommerce.services.dtos.brand.request.AddBrandRequest;
import com.example.spring_ecommerce.services.dtos.brand.request.UpdateBrandRequest;
import com.example.spring_ecommerce.services.dtos.brand.response.ListBrandsResponse;
import com.example.spring_ecommerce.services.dtos.country.response.ListCountryResponse;
import com.example.spring_ecommerce.services.mappers.BrandMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class BrandServiceImpl implements BrandServices {

    private  final BrandRepository brandRepository;
    @Override
    public List<ListBrandsResponse> getAll() {

        List<Brand> brands = brandRepository.findAll();

        List<ListBrandsResponse> response = new ArrayList<>();

        for (Brand brand : brands) {
            ListBrandsResponse brandsResponse = new ListBrandsResponse(
                    brand.getName()
            );

            response.add(brandsResponse);
        }

        return response;

    }

    @Override
    public Optional<Brand> getByID(int id) {
        return Optional.empty();
    }

    @Override
    public void add(AddBrandRequest request) {
//        Brand brand = new Brand();
//        brand.setName(request.getName());


        Brand brand = BrandMapper.INSTANCE.brandFromAddRequest(request);

        brandRepository.save(brand);

    }

    @Override
    public void update(UpdateBrandRequest request) {

        Optional<Brand> optionalBrand = brandRepository.findById(request.getId());

        if (optionalBrand.isPresent()){
            Brand brand = optionalBrand.get();

            brand.setName(request.getName());

            brandRepository.save(brand);
        }else {
            throw  new BrandNotFoundException("Brand not found with ID: " + request.getId());
        }

    }

    @Override
    public void delete(int id) {
        brandRepository.deleteById(id);

    }
}
