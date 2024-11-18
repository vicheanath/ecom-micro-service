package com.ecom.payment.infrastructure.services;

import com.ecom.payment.domain.Money;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class MasterCardPaymentGateway implements PaymentGateway{
    @Override
    public String processPayment(Money money, String paymentId) {

        System.out.println("Processing MasterCard payment with payment id " + paymentId + " and amount " + money.getAmount());

        return UUID.randomUUID().toString();
    }

    @Override
    public String refundPayment(String paymentId) {
        System.out.println("Refunding MasterCard payment with payment id " + paymentId );
        return UUID.randomUUID().toString();
    }
}
