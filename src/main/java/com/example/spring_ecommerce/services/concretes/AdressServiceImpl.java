package com.example.spring_ecommerce.services.concretes;

import com.example.spring_ecommerce.core.types.AddressNotFoundException;
import com.example.spring_ecommerce.entities.Address;
import com.example.spring_ecommerce.entities.District;
import com.example.spring_ecommerce.entities.User;
import com.example.spring_ecommerce.repositories.abstracts.AddressRepository;
import com.example.spring_ecommerce.services.abstracts.AddressService;
import com.example.spring_ecommerce.services.dtos.address.request.AddAddressRequest;
import com.example.spring_ecommerce.services.dtos.address.request.UpdateAddressRequest;
import com.example.spring_ecommerce.services.dtos.address.response.ListAddressesResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class AdressServiceImpl implements AddressService {

    private AddressRepository addressRepository;

    @Override
    public List<ListAddressesResponse> getAll() {

        List<Address> addresses = addressRepository.findAll();

        List<ListAddressesResponse> responses = new ArrayList<>();

        for (Address address: addresses){
            ListAddressesResponse addressResponse = new ListAddressesResponse(
                    address.getAddress_detail() +
                    address.getDistrict() + address.getUser()
            );

            responses.add(addressResponse);


        }
        return responses;
    }

    @Override
    public Optional<Address> getByID(int id) {
        return Optional.empty();
    }

    @Override
    public void add(AddAddressRequest request) {

        User user = new User();
        user.setId(request.getUserId());

        District district =new District();
        district.setId(request.getDistrictId());


        Address address = new Address();
        address.setAddress_detail(request.getAddress_detail());
        address.setUser(user);
        address.setDistrict(district);

        addressRepository.save(address);

    }

    @Override
    public void update(UpdateAddressRequest request) {

        User user = new User();
        user.setId(request.getUserId());

        District district =new District();
        district.setId(request.getDistrictId());

        Optional<Address> optionalAddress = addressRepository.findById(request.getId());
        if (optionalAddress.isPresent()){
            Address address = optionalAddress.get();

            address.setDistrict(district);
            address.setAddress_detail(request.getAddress_detail());
            address.setUser(user);

        }else {
            throw new AddressNotFoundException("Address not found with ID: " + request.getId());

        }

    }

    @Override
    public void delete(int id) {

    }
}
