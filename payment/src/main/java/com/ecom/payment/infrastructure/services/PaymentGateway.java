package com.ecom.payment.infrastructure.services;

import com.ecom.payment.domain.Money;

public interface PaymentGateway {
    String processPayment(Money money, String paymentId);

    String refundPayment(String paymentId);
}
