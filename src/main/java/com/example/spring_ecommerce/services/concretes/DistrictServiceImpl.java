package com.example.spring_ecommerce.services.concretes;

import com.example.spring_ecommerce.entities.City;
import com.example.spring_ecommerce.entities.District;
import com.example.spring_ecommerce.repositories.abstracts.DistrictRepository;
import com.example.spring_ecommerce.services.abstracts.DistrictService;
import com.example.spring_ecommerce.services.dtos.district.request.AddDistrictRequest;
import com.example.spring_ecommerce.services.mappers.CityMapper;
import com.example.spring_ecommerce.services.mappers.DistrictsMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@AllArgsConstructor
@Service
public class DistrictServiceImpl implements DistrictService {
    private DistrictRepository districtRepository;
    @Override
    public List<District> getAll() {
        return districtRepository.findAll();
    }

    @Override
    public Optional<District> getByID(int id) {
        return Optional.empty();
    }

    @Override
    public void add(AddDistrictRequest request) {
        District district = DistrictsMapper.INSTANCE.districtFromAddRequest(request);
        districtRepository.save(district);
    }

    @Override
    public void update(District district) {

    }

    @Override
    public void delete(int id) {

    }
}
