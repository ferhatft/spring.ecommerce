package com.example.spring_ecommerce.services.concretes;

import com.example.spring_ecommerce.core.types.PaymentNotFoundException;
import com.example.spring_ecommerce.entities.District;
import com.example.spring_ecommerce.entities.Likes;
import com.example.spring_ecommerce.entities.Payment;
import com.example.spring_ecommerce.entities.Shipment;
import com.example.spring_ecommerce.repositories.abstracts.PaymentRepository;
import com.example.spring_ecommerce.services.abstracts.PaymentService;
import com.example.spring_ecommerce.services.dtos.payment.request.AddPaymentRequest;
import com.example.spring_ecommerce.services.dtos.payment.request.UpdatePaymentRequest;
import com.example.spring_ecommerce.services.dtos.payment.response.ListPaymentResponse;
import com.example.spring_ecommerce.services.mappers.DistrictsMapper;
import com.example.spring_ecommerce.services.mappers.PaymentMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PaymentServiceImpl implements PaymentService {
    private PaymentRepository paymentRepository;


    @Override
    public List<ListPaymentResponse> getAll() {
        List<Payment> payments = paymentRepository.findAll();
        List<ListPaymentResponse> response = new  ArrayList<>();

        for (Payment payment : payments)  {
         ListPaymentResponse paymentResponse = new ListPaymentResponse(
                 payment.getPayment_type(),
                 payment.getStatus()
         );

         response.add(paymentResponse);
        }
        return response;
    }

    @Override
    public Optional<Payment> getByID(int id) {
        return Optional.empty();
    }

    @Override
    public void add(AddPaymentRequest request) {

//        Payment payment = new Payment();
//        payment.setPayment_type(request.getPayment_type());
//        payment.setStatus(request.getStatus());



        Payment payment = PaymentMapper.INSTANCE.paymentFromAddRequest(request);


        paymentRepository.save(payment);

    }

    @Override
    public void update(UpdatePaymentRequest request) {
        Optional<Payment> optionalPayment = paymentRepository.findById(request.getId());

        if (optionalPayment.isPresent()){
            Payment payment = optionalPayment.get();
            payment.setPayment_type(request.getPayment_type());
            payment.setStatus(request.getStatus());

            paymentRepository.save(payment);
        }else {
            throw new PaymentNotFoundException("Payment not found with ID: " + request.getId());
        }

    }

    @Override
    public void delete(int id) {

    }
}
