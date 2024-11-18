package com.ecom.payment.application.getallpaymenttransaction;

import java.time.LocalDateTime;
import java.util.UUID;

public record GetAllPaymentTransactionQueryResponse(
        UUID id,
        UUID orderId,
        UUID userId,
        double amount,
        LocalDateTime createdAt,
        String status,
        String paymentMethod,
        String transactionId
){}