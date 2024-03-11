package com.example.spring_ecommerce.services.abstracts;

import com.example.spring_ecommerce.entities.Payment;
import com.example.spring_ecommerce.services.dtos.payment.request.AddPaymentRequest;
import com.example.spring_ecommerce.services.dtos.payment.request.UpdatePaymentRequest;
import com.example.spring_ecommerce.services.dtos.payment.response.ListPaymentResponse;
import com.example.spring_ecommerce.services.dtos.shipment.request.UpdateShipmentRequest;
import jakarta.validation.Valid;

import java.util.List;
import java.util.Optional;

public interface PaymentService {

    List<ListPaymentResponse> getAll();

    Optional<Payment> getByID(int id);

    void add(AddPaymentRequest request);

    void update(UpdatePaymentRequest request);

    void delete(int id);
}
