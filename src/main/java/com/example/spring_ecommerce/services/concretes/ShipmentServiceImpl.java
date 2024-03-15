package com.example.spring_ecommerce.services.concretes;

import com.example.spring_ecommerce.core.types.ShipmentNotFoundException;
import com.example.spring_ecommerce.entities.Country;
import com.example.spring_ecommerce.entities.Payment;
import com.example.spring_ecommerce.entities.Shipment;
import com.example.spring_ecommerce.repositories.abstracts.ShipmentRepository;
import com.example.spring_ecommerce.services.abstracts.ShipmentService;
import com.example.spring_ecommerce.services.dtos.country.response.ListCountryResponse;
import com.example.spring_ecommerce.services.dtos.shipment.request.AddShipmentRequest;
import com.example.spring_ecommerce.services.dtos.shipment.request.UpdateShipmentRequest;
import com.example.spring_ecommerce.services.dtos.shipment.response.ListShipmentResponse;
import com.example.spring_ecommerce.services.mappers.PaymentMapper;
import com.example.spring_ecommerce.services.mappers.ShipmentMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@AllArgsConstructor
@Service
public class ShipmentServiceImpl implements ShipmentService {

    private  ShipmentRepository shipmentRepository;

    @Override
    public List<ListShipmentResponse> getAll() {

        List<Shipment> shipments = shipmentRepository.findAll();

        List<ListShipmentResponse> response = new ArrayList<>();

        for (Shipment shipment :shipments) {
            ListShipmentResponse shipmentResponse = new ListShipmentResponse(
                    shipment.getName(),
                    shipment.getEstimateddelivery()
            );

            response.add(shipmentResponse);
        }

        return response;

    }

    @Override
    public Optional<Shipment> getByID(int id) {
        return Optional.empty();
    }

    @Override
    public void add(AddShipmentRequest request) {

//        Shipment shipment = new Shipment();
//
//        shipment.setName(request.getName());
//        shipment.setEstimateddelivery(request.getEstimateddelivery());


        Shipment shipment = ShipmentMapper.INSTANCE.shipmentFromAddRequest(request);
        shipmentRepository.save(shipment);
    }

    @Override
    public void update(UpdateShipmentRequest request) {
        Optional<Shipment> optionalShipment = shipmentRepository.findById(request.getId());

        if (optionalShipment.isPresent()){
            Shipment shipment =optionalShipment.get();

            shipment.setEstimateddelivery(request.getEstimateddelivery());
            shipment.setName(request.getName());

            shipmentRepository.save(shipment);
        }else {
            throw new ShipmentNotFoundException("Shipment not found with ID: " +request.getId());
        }



    }

    @Override
    public void delete(int id) {

    }
}
